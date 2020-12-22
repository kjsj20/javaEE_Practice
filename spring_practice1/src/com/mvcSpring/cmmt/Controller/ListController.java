package com.mvcSpring.cmmt.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.board.model.BoardDAO;

public class ListController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
