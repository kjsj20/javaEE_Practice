package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.Board;
import com.board.model.BoardDAO;
import com.controller.Controller;

public class EditController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int board_id = Integer.parseInt(req.getParameter("board_id"));
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.update(board);
		
		req.setAttribute("board", board);
		req.setAttribute("result", result);
	}

	public String getResultView() {
		return "/view/board/edit";
	}

	public boolean isForward() {
		return true;
	}

}
