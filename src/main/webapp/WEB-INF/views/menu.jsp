<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<section class="drower-menu">
 <div class="nav-menu">
  <ul class="menu-area">
   <li class="top"><a><form:form action="top" method="post" enctype="multipart/form-data"><input type="submit" value="トップ"></form:form></a></li>
   <li class="mypage"><a><form:form action="mypage" method="post" enctype="multipart/form-data"><input type="submit" value="mypage"></form:form></a></li>
   <li class="request"><a><form:form action="request" method="post" enctype="multipart/form-data"><input type="submit" value="要望"></form:form></a></li>
  </ul>
 </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>