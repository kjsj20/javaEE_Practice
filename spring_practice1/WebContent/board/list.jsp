<%@page import="com.board.domain.Board"%>
<%@page import="com.board.util.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%> 
<%
	List<Board> list = (List)request.getAttribute("boardList");
	Pager pager = new Pager();
	pager.init(request, list);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.regist {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.regist:hover {
  background-color: #45a049;
}

#blockPage {
	text-decoration : none;
}

.curPage{
	border : 2px solid;
	padding : 3px;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			int curPos = pager.getCurPos();
			int num = pager.getNum();
		%>
		<%for(int i = 1; i<pager.getPageSize() + 1; i++){ %>
		<%if(num<1)break; %>
		<%Board board = list.get(curPos++);%> 
			<tr>
				<td><%=num-- %></td>
				<td><a href = "/board/detail?board_id=<%=board.getBoard_id()%>&currentPage=<%=pager.getCurrentPage()%>"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getContent() %></td>
				<td><%=board.getRegdate() %></td>
				<td><%=board.getHit() %></td>
			</tr>
		<%} %>
		<tr>
			<td colspan="6" style="text-align:center">
				<a id = "blockPage" href = "/board/list?currentPage=<%=1%>">◀◀</a>
				<%if(pager.getCurrentPage() > 1){%>
				<a id = "blockPage" href = "/board/list?currentPage=<%=pager.getFirstPage() - pager.getBlockSize()%>">◀</a>
				<%}else{ %>
					<a id = "blockPage">◀</a>
				<%} %>
				<%for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ %>
				<%if(pager.getTotalPage() < i)break; %>
					<a id = "blockPage" <%if(pager.getCurrentPage() == i){ %>class = "curPage"<%} %> href = "/board/list?currentPage=<%=i%>"><%=i %></a>
				<%} %>
				<%if(pager.getCurrentPage() == pager.getTotalPage()) {%>
					<a id = "blockPage">▶</a>
				<%} else { %>
					<a id = "blockPage" href = "/board/list?currentPage=<%=pager.getLastPage() + 1%>">▶</a>
				<%} %>
				<a id = "blockPage" href = "/board/list?currentPage=<%=pager.getTotalPage()%>">▶▶</a>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<button class = "regist" onClick="location.href='/board/regist_form.jsp'">글등록</button>
			</td>
		</tr>
	</table>

</body>
</html>