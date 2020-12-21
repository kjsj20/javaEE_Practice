<%@page import="com.board.domain.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%	
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	var bt_list = $("input[type='button']")[0];
	var bt_edit = $("input[type='button']")[1];
	var bt_del = $("input[type='button']")[2];
	
	$(bt_list).click(function(){
		
	});
	
	$(bt_edit).click(function(){
		edit();
	});
	$(bt_del).click(function(){
		del();
	});
});

function edit(){
	if(confirm("수정하시겠어요?")){
		$("form").attr({
				method:"post",
				action:"/board/edit.do"		
		});
		$("form").submit();
	}
}

function del(){
	if(confirm("삭제하시겠어요?")){
		location.href = "/board/delete.do?board_id=<%=board.getBoard_id()%>";		
	}
}

</script>
</head>
<body>
	<h3>게시판 상세보기</h3>
	<div class="container">
	  <form>
	  	<input type="hidden" name="board_id" value="<%=board.getBoard_id()%>">
	    <input type="text" name="writer" value="<%=board.getWriter()%>" >
		
	    <input type="text" name="title" value="<%=board.getTitle() %>">
	    
	    <textarea name="content" style="height:200px"><%=board.getContent() %></textarea>
	   	
	    <input type="button" value="목록보기" onClick="location.href='/board/list.do'">
	    <input type="button" value="수정하기">
	    <input type="button" value="삭제하기">
	  </form>
	</div>
</body>
</html>
