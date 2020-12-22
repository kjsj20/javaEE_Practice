package com.mvcSpring.board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.board.model.BoardDAO;

public class DeleteController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int result = boardDAO.delete(board_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("/board/delete");
		return mav;
	}

}
