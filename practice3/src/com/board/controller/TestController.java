package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class TestController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	public String getResultView() {
		return "/view/test";
	}

	public boolean isForward() {
		return false;
	}
	
}
