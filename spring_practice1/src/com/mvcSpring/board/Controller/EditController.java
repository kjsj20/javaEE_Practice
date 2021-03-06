package com.mvcSpring.board.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.board.domain.Board;
import com.board.model.BoardDAO;

public class EditController implements Controller{
	BoardDAO boardDAO = new BoardDAO();
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.update(board);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.addObject("currentPage", currentPage);
		mav.addObject("board", board);
		mav.setViewName("/board/edit");
		return mav;
	}

}
