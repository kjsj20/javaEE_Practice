package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.controller.Controller;

public class DeleteController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int board_id = Integer.parseInt(req.getParameter("board_id"));
		int result = boardDAO.delete(board_id);
		req.setAttribute("result", result);
	}

	public String getResultView() {
		return "/view/board/delete";
	}

	public boolean isForward() {
		return true;
	}

}
