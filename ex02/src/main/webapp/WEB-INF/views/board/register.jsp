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
		<h1 class="page-header">Board Register</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel-heading">Board Register</div>
		<div class="panel-body">
			<form action="/board/register" role="form" method="post">
				<div class="form-group">
					<label>Title</label><input name="title" class="form-control">
				</div>
				<div class="form-group">
					<label>Text area</label>
					<textarea name="content" rows="3" class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label><input name="writer" class="form-control">
				</div>
				<button class="btn btn-default" type="submit">Submit Button</button>
				<button class="btn btn-default" type="reset">Reset Button</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>