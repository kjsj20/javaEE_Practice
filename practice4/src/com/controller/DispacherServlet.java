package com.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DispacherServlet extends HttpServlet{
	FileReader fr;
	JSONObject controllerMap, viewMap;
	
	public void init(ServletConfig config) throws ServletException {
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		String realPath = config.getServletContext().getRealPath(contextConfigLocation);
		try {
			fr = new FileReader(realPath);
			JSONParser jsonParser = new JSONParser();
			JSONObject json = (JSONObject)jsonParser.parse(fr);
			controllerMap = (JSONObject) json.get("controller");
			viewMap = (JSONObject) json.get("views");
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
		
		Class controllerClass = null;
		Controller controller = null;
		String controllerName = (String) controllerMap.get(uri);
		try {
			controllerClass = Class.forName(controllerName);
			controller = (Controller) controllerClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		controller.execute(req, resp);
		
		String resultKey = controller.getResultView();
		String viewPage = (String) viewMap.get(resultKey);
		
		if(controller.isForward()) {
			RequestDispatcher dis = req.getRequestDispatcher(viewPage);
			dis.forward(req, resp);
		}else {
			resp.sendRedirect(viewPage);			
		}
	}
	
	public void destroy() {
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
