<%@page import="com.cmmt.domain.Cmmt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/json; charset=utf-8" pageEncoding="utf-8"%>
<%
	List<Cmmt> list = (List)request.getAttribute("cmmtList");
	StringBuilder sb = new StringBuilder();
	
	sb.append("{");
	sb.append("\"list\":[");
	for(int i = 0; i < list.size(); i++){
		Cmmt cmmt = list.get(i);
		sb.append("{");
		sb.append("\"msg\":\""+cmmt.getMsg()+"\",");
		sb.append("\"author\":\""+cmmt.getAuthor()+"\",");
		sb.append("\"cdate\":\""+cmmt.getCdate()+"\"");
		if(i<list.size()-1){
			sb.append("},");			
		} else {
			sb.append("}");						
		}
	}
	sb.append("]");
	sb.append("}");
	out.print(sb.toString());
%>