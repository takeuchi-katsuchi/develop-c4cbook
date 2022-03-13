<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<section class="book-list">
 <c:forEach items="${topForm.topAndDetailDtoList}" var="topAndDetail">

  <c:url var="detailLink" value="/detail">
   <c:param name="bookId" value="${topAndDetail.bookId}" />
  </c:url>

  <div class="book_box">
   <div class="book_img_area"><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${topAndDetail.encodedBookImg}" alt=""></a></div>
   <div class="book_info">
    <div class="name"><a href="${detailLink}">${topAndDetail.title}</a></div>
    <div class="author">${topAndDetail.author}</div>
    <c:choose>
     <c:when test="${topAndDetail.memName != null}">
      <%-- 条件に当てはまる場合 --%>
      <div class="rent_disable">${topAndDetail.memName}さんに貸出中</div>
     </c:when>
     <c:otherwise>
      <%-- 上記すべての条件に当てはまらない場合 --%>
      <div class="rent_able">貸出可能です</div>
     </c:otherwise>
    </c:choose>
    <ul class="tag"><c:forEach items="${topAndDetail.tagIds}" var="tag"><li>${tag}</li></c:forEach></ul>
    <div class="icon_img_wrap">
     <div class="icon_img_area">
      <c:choose>
       <c:when test="${topForm.myLendedBookIdList.contains(topAndDetail.bookId)}">
        <%-- 読書済みの場合 --%>
        <i class="fas fa-book-open fa-2x"></i>
       </c:when>
       <c:otherwise>
        <%-- 読書済みでない場合 --%>
        <i class="noread fas fa-book fa-2x"></i>
       </c:otherwise>
      </c:choose>
     </div>
     <div class="icon_img_area book-count">${topAndDetail.lendCount}</div>
     <div class="icon_img_area">
      <c:choose>
       <c:when test="${topForm.myFavoriteBookIdList.contains(topAndDetail.bookId)}">
        <%-- お気に入りしてる場合 --%>
        <i class="fas fa-heart fa-2x" name="fav" data-id="${topAndDetail.bookId}"></i>
       </c:when>
       <c:otherwise>
        <%-- お気に入りしていない場合 --%>
        <i class="noheart fas fa-heart fa-2x" name="fav" data-id="${topAndDetail.bookId}"></i>
       </c:otherwise>
      </c:choose>
     </div>
     <div class="icon_img_area heart-count">${topAndDetail.favCount}</div>
    </div>
   </div>
  </div>

 </c:forEach>
</section>
