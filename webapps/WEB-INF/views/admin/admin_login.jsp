<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Login</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resource/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resource/css/sb-admin.css" rel="stylesheet">
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resource/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resource/vendor/jquery-easing/jquery.easing.min.js"></script>
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="<c:url value='/login-processing'/>" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Email</label>
            <input class="form-control" id="exampleInputEmail1" name="email" type="email" placeholder="Email" required>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name="password" type="password" placeholder="Password" required>
          </div>
          <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
          <input type="submit" class="btn btn-primary btn-block" value="Login">
        </form>
        
        <c:if test="${ param.error == 'login' }">
        	<br>
			<p style="color:#FF0000">이메일 혹은 비밀번호를 잘못 입력하셨습니다.</p>
		</c:if>        
      </div>
    </div>
    
    
  </div>
  
</body>

</html>
