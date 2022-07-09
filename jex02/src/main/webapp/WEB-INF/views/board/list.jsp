<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/list.jsp</title>
<style>
	.pull-right a{
		text-decoration: none;
		color: #000;
	}
	
	.pull-right a:hover{
		text-decoration: underline;
	}
	
	.pull-right a.active{
		color: red;
		font-weight: bold;
		text-decoration: underline;
	}
	.pull-right ul{
		list-style-type: none;
		padding: 0;
	}
	
	.pull-right ul > li{
		float: left;
		padding: 5px;
	}
</style>
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
						<td>
							<a href='/board/get?pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount }&bno=<c:out value="${board.bno }"/>'>
								<c:out value="${board.title }"/>
							</a>
						</td>
						<td><c:out value="${board.writer }"/> </td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/> </td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/> </td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="pull-right cleatfix">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<li class="paginate_button previous"><a href="list?pageNum=${pageMaker.startPage-1 }">Previous</a></li>
					</c:if>
					
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<!-- <li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":"" }">
							<a href="list?pageNum=${num }">${num }</a>
						</li> -->
						<li>
							<c:choose>
								<c:when test="${pageMaker.cri.pageNum eq num }">
									<a  class="active" href='list?pageNum=${num }&amount=${pageMaker.cri.amount }'>
										${num }
									</a>
								</c:when>
								<c:otherwise>
									<a href='list?pageNum=${num }&amount=${pageMaker.cri.amount }'>${num }</a>
								</c:otherwise>
							</c:choose>
						</li>
					</c:forEach>
					
					<c:if test="${pageMaker.next }">
						<li class="paginate_button next"><a href="list?pageNum=${pageMaker.endPage+1 }">Next</a></li>
					</c:if>
				</ul>
				<form action="/board/list" method='get' id='actionForm'>
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" />
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }" />
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>