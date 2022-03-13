<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>C4C BOOK</title>
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/fdfc67613f.js" crossorigin="anonymous"></script>
</head>
<body>
 <section class="header"><h2 class="title">C4CBOOK</h2></section>
 <div class="container">
  <div class="row justify-content-center">
   <div class="col-sm-4 mt-4">
    <h4>ログイン</h4>
    <form action="" method="post">
     <select class="form-control" name="memId">
      <c:forEach items="${loginForm.bk_M_MemBasicDtoList}" var="member">
       <option value="${member.memId}">${member.memName}</option>
      </c:forEach>
     </select> <input type="submit" class="btn btn-primary btn-block mt-1">
    </form>
   </div>
  </div>
 </div>
</body>
</html>