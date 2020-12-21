package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.domain.Board;
import com.board.model.BoardDAO;
import com.controller.Controller;

public class DetailController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int board_id = Integer.parseInt(req.getParameter("board_id"));
		Board board = boardDAO.select(board_id);
		req.setAttribute("board", board);
	}

	public String getResultView() {
		return "/veiw/board/detail";
	}

	public boolean isForward() {
		return true;
	}

}
