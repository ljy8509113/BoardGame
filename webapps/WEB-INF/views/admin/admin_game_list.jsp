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
  <link href="resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resource/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="resource/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="resource/css/sb-admin.css" rel="stylesheet">
  
  <!-- Bootstrap core JavaScript-->
    <script src="resource/vendor/jquery/jquery.min.js"></script>
    <script src="resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resource/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="resource/vendor/datatables/jquery.dataTables.js"></script>
    <script src="resource/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resource/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="resource/js/sb-admin-datatables.min.js"></script>
    
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#navDiv").load("html/menu.html");  		
  	});
  </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <div id="navDiv">
  </div>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> 게임 목록
          <a class="btn btn-primary" href="adminGameRegist.do" id="toggleNavPosition" style="float:right">추가</a>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>게임명</th>
                  <th>상태</th>
                </tr>
              </thead>
              <tbody>
              	<c:choose>
					<c:when test="${empty list}">
        				<tr colspan="3">리스트가 존재하지 않습니다.</tr>
    				</c:when>
					<c:otherwise>
        				<c:forEach items="${ list }" var="game">
	        				<tr>
	        					<td>${game.gameNo} </td>
	                  			<td>${game.title}</td>
	                  			<c:choose>
	                  				<c:when test="${game.state eq 'D'}">
	                  					<td>개발중</td>
	                  				</c:when>
	                  				<c:when test="${game.state eq 'O'}">
	                  					<td>서비스중</td>
	                  				</c:when>
	                  				<c:when test="${game.state eq 'C'}">
	                  					<td>서비스종료</td>
	                  				</c:when>
	                  				<c:otherwise>
	                  					<td>-</td>
	                  				</c:otherwise>
	                  			</c:choose>
	                  				                  			
	                		</tr>
        				</c:forEach>
    				</c:otherwise>
				</c:choose>
                
              </tbody>
            </table>
          </div>
        </div>        
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    
  </div>
  
</body>

</html>

