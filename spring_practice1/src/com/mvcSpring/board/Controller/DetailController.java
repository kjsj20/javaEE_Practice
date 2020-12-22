package com.mvcSpring.board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.board.domain.Board;
import com.board.model.BoardDAO;

public class DetailController implements Controller {
	BoardDAO boardDAO = new BoardDAO();

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		Board board = boardDAO.select(board_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("/board/detail");
		return mav;
	}
}
