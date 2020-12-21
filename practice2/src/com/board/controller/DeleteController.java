package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller.Controller;
import com.board.model.BoardDAO;

public class DeleteController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	int result = 0;
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String board_id = req.getParameter("board_id");
		result = boardDAO.delete(Integer.parseInt(board_id));
	}

	public String getResultView() {
		if(result == 0) {
			return "/view/error/error";
		} else {
			return "/view/board/reList";			
		}
	}

	public boolean isForward() {
		return false;
	}
	
}
