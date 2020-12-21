package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller.Controller;
import com.board.domain.Board;
import com.board.model.BoardDAO;

public class EditController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Board  board = new Board();
		String board_id = req.getParameter("board_id");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String filename = req.getParameter("author");
		String content = req.getParameter("content");
		
		board.setBoard_id(Integer.parseInt(board_id));
		board.setTitle(title);
		board.setWriter(writer);
		board.setFilename(filename);
		board.setContent(content);
		
		int result = boardDAO.update(board);
	}

	public String getResultView() {
		return "/view/board/edit";
	}

	public boolean isForward() {
		return true;
	}
	
}
