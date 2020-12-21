package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class TestServlet implements Controller{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public String getResultView() {
		return "/view/test/result";
	}

	@Override
	public String isForward() {
		return null;
	}
	
}
