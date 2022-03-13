<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<section class="header">
 <div class="header-wrap">
  <h2 class="title">C4CBOOK</h2>
  <div class="menu">
   <ul class="pulldown">
    <li class="use_top"><img id="filtering" src="resources/img/filter.png" alt="フィルタ" data-toggle="modal" data-target="#filter_modal"></li>
    <li class="use_top"><img id="sorting" src="resources/img/sort.png" alt="ソート" data-toggle="modal" data-target="#sort_modal"></li>
    <li class="slidebtn"><a href="#"><img src="resources/img/news.png" alt="お知らせ"></a>
     <ul class="submenu">
      <c:if test="${LendingCnt >= 1}">
       <li class="news"><a href="/c4cbook/mypage">返却期限が近付いている本が${LendingCnt}件あります。</a></li>
      </c:if>
      <c:if test="${newBooksCnt >= 1}">
       <c:forEach items="${topForm.offerBookNewsList}" var="list"><li class="news"><a href="/c4cbook/detail?bookId=${list.bookId}">新しく「${list.title}」が入りました。</a></li></c:forEach>
      </c:if>
      <c:if test="${newApprovalCnt >= 1}">
       <c:forEach items="${topForm.requestBookNewsList}" var="list"><li class="news">要望していた「${list.title}」が承認されました。</li></c:forEach>
      </c:if>
      <c:if test="${recomeBooksCnt >= 1}">
       <c:forEach items="${topForm.recomeBookNewsList}" var="list"><li class="news"><a href="/c4cbook/detail?bookId=${list.bookId}">「${list.title}」がおすすめされました。</a></li></c:forEach>
      </c:if>
     </ul></li>
     <li class="drowerbtn">
     <a href="#"><img src="resources/img/menu.png" alt="メニュー"></a>
     </li>
     <ul class="drowermenu">
      <li class="menu"><a><form:form action="top" method="post" enctype="multipart/form-data"><input type="submit" value="トップ"></form:form></a></li>
      <li class="menu"><a><form:form action="mypage" method="post" enctype="multipart/form-data"><input type="submit" value="mypage"></form:form></a></li>
      <li class="menu"><a><form:form action="request" method="post" enctype="multipart/form-data"><input type="submit" value="要望"></form:form></a></li>
     </ul>
   </ul>
  </div>
 </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="resources/js/header.js"></script>
<script src="resources/js/menu.js"></script>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>