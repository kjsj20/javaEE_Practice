<%@page import="com.board.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	int result = (Integer)request.getAttribute("result");
	
	StringBuilder sb = new StringBuilder();
	
	sb.append("<script>");
	if(result == 0){
		sb.append("alert('삭제 실패...');");
		sb.append("history.back()");
	} else{
		sb.append("alert('삭제 성공!');");
		sb.append("location.href = '/board/list.do';");
	}
	sb.append("</script>");
	
	out.print(sb);
%>