<%@page import="com.board.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	int result = (Integer)request.getAttribute("result");
	int currentPage = (Integer)request.getAttribute("currentPage");
	Board board= (Board)request.getAttribute("board");
	StringBuilder sb = new StringBuilder();
	sb.append("<script>");
	if(result == 0){
		sb.append("alert('수정실패');");
		sb.append("history.back();");
	} else {
		sb.append("alert('수정성공');");
		sb.append("location.href='/board/detail?board_id="+board.getBoard_id()+"&currentPage="+currentPage+"';");
	}
	sb.append("</script>");
	out.print(sb);
%>