<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Board Game Admin</title>
  <link href="${pageContext.request.contextPath}/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resource/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/resource/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
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
  <div id="navDiv">
  </div>
  <div class="content-wrapper">
    <div class="container-fluid">
      <label>${game.gameNo}</label> <br>
      <label>${game.title}</label> <br>
      <label>${game.description}</label> <br>
      <label>${game.coverImage}</label> <br>
      <label>${game.state}</label> <br>
      <label>${game.fileName}</label> <br>
      
      <a href="adminGameModify.do?gameNo=${game.gameNo}" class="btn btn-primary" id="toggleNavPosition" >수정</a> 
		&nbsp;&nbsp;&nbsp;<a class="btn btn-secondary" href="adminGameList.do">뒤로</a><br><br>
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    
  </div>
  
</body>

</html>

