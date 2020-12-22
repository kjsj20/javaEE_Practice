<%@page import="com.board.domain.Board"%>
<%@ page contentType="text/html;charset=utf-8"%> 
<%
	Board board = (Board)request.getAttribute("board");
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
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
.cmmtList{
	overflow : hidden;
}

.cmmtBox{
	background:yellow;
}

.cmmtList{
	overflow:hidden;
}

.cmmtList p{
	background:yellow;
	float : left;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$($("input[type = 'button']")[0]).click(function(){
		if(confirm("수정하시겠습니까?")){
			edit();			
		}
	});
	$($("input[type='button']")[1]).click(function(){
		if(confirm("삭제하시겠습니까?")){
			del();
		}
	});
	getCmmtList();
});

function edit(){
	$("form").attr({
		method:"post",
		action:"/board/edit"
	});		
	
	$("form").submit();
}

function del(){
	$("form").attr({
		method:"get",
		action:"/board/delete"
	});
	$("form").submit();
}

function getCmmtList(){
	$.ajax({
		url: "/cmmt/list.do",
		type:"get",
		data:{board_id:<%=board.getBoard_id()%>},
		success: function(result){
			console.log(result);
			$("#list-area").html("");
			var tag = "";
			for(var i = 0; i < result.list.length; i++){
				var json = result.list[i];
				tag += "<div class = 'cmmtList'>";
				tag += "<p style = 'width:75%'>"+json.msg+"</p>";
				tag += "<p style = 'width:15%'>"+json.author+"</p>";
				tag += "<p style = 'width:10%'>"+json.cdate+"</p>";
				tag += "</div>";
			}
			$("#list-area").html(tag);
		}
	});
}

function registComment(){
	$.ajax({
		url: "/cmmt/regist.do",
		type:"POST",
		data: {
			msg:$("input[name = 'msg']").val(),
			author:$("input[name = 'author']").val(),
			board_id:<%=board.getBoard_id()%>
		},
		success: function(result){
			if(result == 0){
				alert("등록실패");
			} else {
				getCmmtList();
			}
		}
	});
}
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
  	<input type="hidden" name="currentPage" value="<%=currentPage%>">
    <input type="hidden" name="board_id" value="<%=board.getBoard_id()%>">
    <input type="text" name="title" value="<%=board.getTitle()%>">
 
    <input type="text" name="writer" value="<%=board.getWriter()%>">

    <textarea name="content" style="height:200px"><%=board.getContent()%></textarea>

    <input type="button" value="글수정">
    <input type="button" value="글삭제">
    <input type="button" value="목록보기" onClick="location.href='/board/list?currentPage=<%=currentPage%>'">
    
    <div id = "cmmtList">
    	<input type = "text" name = "msg" placeholder="댓글 입력.." style = "width:75%"/>
    	<input type = "text" name = "author" placeholder="작성자 입력.." style = "width:10%"/>
    	<button type = "button" onClick="registComment()">댓글등록</button>
    </div>
    <div id = "list-area"></div>
  </form>
</div>

</body>
</html>