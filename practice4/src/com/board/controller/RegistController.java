package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.Board;
import com.board.model.BoardDAO;
import com.controller.Controller;

public class RegistController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.insert(board);
	}

	public String getResultView() {
		return "/view/board/reList";
	}

	public boolean isForward() {
		return false;
	}

}
