package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.controller.Controller;

public class ListController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list = boardDAO.selectAll();
		req.setAttribute("boardList", list);
	}

	public String getResultView() {
		return "/view/board/list";
	}

	public boolean isForward() {
		return true;
	}
	
}
