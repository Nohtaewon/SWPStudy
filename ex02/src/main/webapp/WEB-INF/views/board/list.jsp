<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel-heading">Board List Page</div>
		<button id='regBtn' type="button" class="btn btn-xs pull-right" onclick="location.href='/board/register'">Register New Board</button>
		<div class="panel-body">
			<table class="table table-striped table-border table-hover">
				<thead>
					<tr>
						<th>#번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>수정일</th>
					</tr>
				</thead>
				
				<c:forEach items="${list }" var="board">
					<tr>
						<td><c:out value="${board.bno }"/> </td>
						<td><a href='/board/get?bno=<c:out value="${board.bno }"/>'><c:out value="${board.title }"/></a></td>
						<td><c:out value="${board.writer }"/> </td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/> </td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>