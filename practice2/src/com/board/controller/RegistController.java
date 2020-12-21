package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller.Controller;
import com.board.domain.Board;
import com.board.model.BoardDAO;

public class RegistController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Board board = new Board(); 
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String filename = req.getParameter("photo");
		String content = req.getParameter("content");
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setFilename(filename);
		board.setContent(content);
		
		boardDAO.insert(board);
	}

	public String getResultView() {
		return "/view/board/reList";
	}

	public boolean isForward() {
		return false;
	}
	
}
