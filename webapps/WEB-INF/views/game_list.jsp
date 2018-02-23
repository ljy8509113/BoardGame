<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Board Game</title>
    <!-- Bootstrap core CSS -->
    <link href="resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="resource/css/simple-sidebar.css" rel="stylesheet">
</head>

<body>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Board Game
                    </a>
                </li>
                <li>
                    <a href="#">게임목록</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
            	<div>
            		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Menu</a> &nbsp;&nbsp;&nbsp;게임 목록
            	</div>
            	<br/>
            	<c:forEach items="${ list }" var="game">
	            	<div class="card mb-3">
	            		<a href="#">
	               			<img class="card-img-top img-fluid w-100" src="${game.coverImage}" alt="">
	            		</a>
	             		<div class="card-body">
	               			<h6 class="card-title mb-1">${game.title}</h6>
	               			<hr>
	                		<p class="card-text small">${game.description}</p>
	                  	</div>
	                 </div>
	            </c:forEach>                          
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap core JavaScript -->
    <script src="resource/vendor/jquery/jquery.min.js"></script>
    <script src="resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>