package com.mvcSpring.board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.board.domain.Board;
import com.board.model.BoardDAO;

public class RegistController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board();
		
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.insert(board);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("board",board);
		mav.setViewName("redirect:/board/list");
		return mav;
	}

}
