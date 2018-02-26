<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Board Game Admin</title>
<link href="${pageContext.request.contextPath}/resource/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath}/resource/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="${pageContext.request.contextPath}/resource/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath}/resource/css/sb-admin.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/resource/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resource/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resource/vendor/datatables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/resource/vendor/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/resource/js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->
<script src="${pageContext.request.contextPath}/resource/js/sb-admin-datatables.min.js"></script>

<script type="text/javascript">
  	$(document).ready(function(){
  		$("#navDiv").load("/BoardGame/html/menu.html");  		
  	});
  	
  </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<div id="navDiv"></div>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> 게임 수정
				</div>
				<form action="adminGameModify.do" method="post" enctype="multipart/form-data">
					<div class="card-body">
						<input type="hidden" name="gameNo" value="${game.gameNo}"> 
						<label> 게임명 : <input type="text" name="title" value="${game.title}"></label><br>
						<label> 상태 : <input type="text" name="state" value="${game.state}"> (O:서비스중, C:서비스종료, D:개발중)</label><br>
						<label> 설명 : <textarea rows="10" cols="50" name="description">${game.description}</textarea></label><br> 
						<label> 버전 : <input type="text" name="version" value="${game.version}"></label><br>
						<label> 대표이미지 : <input type="file" name="coverImage" value="${game.coverImage}"></label><br>
						<label> Game File : <input type="file" name="gameFile" value="${game.fileName}"></label><br><br>
						<input type="submit" class="btn btn-primary" id="toggleNavPosition" value="등록"> 
						&nbsp;&nbsp;&nbsp;<a class="btn btn-secondary" href="adminGameList.do">취소</a>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</div>
				</form>				
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright © Your Website 2018</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>

</body>

</html>

