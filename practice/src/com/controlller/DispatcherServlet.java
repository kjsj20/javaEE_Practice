package com.controlller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DispatcherServlet extends HttpServlet{
	FileReader fr;
	JSONObject controllerMap, viewMap;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		String realPath = config.getServletContext().getRealPath(contextConfigLocation);
		
		try {
			fr = new FileReader(realPath);
			JSONParser jsonParser = new JSONParser();
			
			JSONObject json = (JSONObject)jsonParser.parse(fr);
			
			controllerMap = (JSONObject)json.get("controller");
			viewMap = (JSONObject)json.get("views");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String controllerName = (String) controllerMap.get(uri);
		
		Class controllerClass = null;
		Controller controller = null;
		
		try {
			controllerClass = Class.forName(controllerName);
			controller = (Controller) controllerClass.newInstance();
			controller.execute(req, resp);
			
			String viewKey = controller.getResultView();
			String viewPage = (String) viewMap.get(viewKey);
			
			resp.sendRedirect(viewPage);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
