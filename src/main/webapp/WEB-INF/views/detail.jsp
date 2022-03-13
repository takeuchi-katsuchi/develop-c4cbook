<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>C4C BOOK</title>
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/menu.css" media="screen">
<link rel="stylesheet" href="resources/css/book-list.css" media="screen">
<link rel="stylesheet" href="resources/css/detail.css" media="screen">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href='resources/js/fullcalendar/core/main.css' rel='stylesheet' />
<link href='resources/js/fullcalendar/daygrid/main.css' rel='stylesheet' />
<script src='resources/js/fullcalendar/core/main.js'></script>
<script src='resources/js/fullcalendar/daygrid/main.js'></script>
<script src="https://kit.fontawesome.com/fdfc67613f.js" crossorigin="anonymous"></script>
</head>
<body>
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <input id="loginMember" type="hidden" value="${webSessionDto.memId}">
 <section class="bdy">
  <jsp:include page="./menu.jsp"></jsp:include>
  <div class="book_box">
   <div class="book_img_area"><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${detailForm.v_TopAndDetailDto.encodedBookImg}" alt=""></a></div>

   <div class="book_info">
    <div class="name"><a href="${detailLink}">${detailForm.v_TopAndDetailDto.title}</a></div>
    <div class="author">${detailForm.v_TopAndDetailDto.author}</div>
    <c:choose>
     <c:when test="${detailForm.v_TopAndDetailDto.memName != null}">
      <%-- 条件に当てはまる場合 --%>
      <div class="rent_disable">${detailForm.v_TopAndDetailDto.memName}さんに貸出中</div>
     </c:when>
     <c:otherwise>
      <%-- 上記すべての条件に当てはまらない場合 --%>
      <div class="rent_able">貸出可能です</div>
     </c:otherwise>
    </c:choose>
    <ul class="tag"><c:forEach items="${detailForm.v_TopAndDetailDto.tagIds}" var="tag"><li>${tag}</li></c:forEach></ul>
    <div class="icon_img_wrap">
     <div class="icon_img_area">
      <c:choose>
       <c:when test="${detailForm.lendedMemIdList.contains(webSessionDto.memId)}">
        <%-- 読書済みの場合 --%>
        <i class="fas fa-book-open fa-2x"></i>
       </c:when>
       <c:otherwise>
        <%-- 読書済みでない場合 --%>
        <i class="noread fas fa-book fa-2x"></i>
       </c:otherwise>
      </c:choose>
     </div>
     <div class="icon_img_area book-count">${detailForm.v_TopAndDetailDto.lendCount}</div>
     <div class="icon_img_area">
      <c:choose>
       <c:when test="${detailForm.favoriteMemIdList.contains(webSessionDto.memId)}">
        <%-- お気に入りしてる場合 --%>
        <i class="fas fa-heart fa-2x" name="fav" data-id="${detailForm.v_TopAndDetailDto.bookId}"></i>
       </c:when>
       <c:otherwise>
        <%-- お気に入りしていない場合 --%>
        <i class="noheart fas fa-heart fa-2x" name="fav" data-id="${detailForm.v_TopAndDetailDto.bookId}"></i>
       </c:otherwise>
      </c:choose>
     </div>
     <div class="icon_img_area heart-count">${detailForm.v_TopAndDetailDto.favCount}</div>
    </div>
   </div>
  </div>

  <div class="contents">
   <div class="col">
    <i class="fas fa-pencil-alt"></i> 概要
    <p class="com">${detailForm.v_TopAndDetailDto.outline}</p>
    <i class="far fa-comment-dots"></i> 提供メンバーコメント
    <p class="com">${detailForm.v_TopAndDetailDto.offerMemComment}コメントコメントコメント</p>
   </div>
   <button id="openLendingProcedureModal" type="button" class="btn btn-secondary btn-block mt-3">貸出・予約・返却</button>
   <div class="tab">
    <div class="tab-wrap">
     <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" /><label class="tab-label" for="TAB-01">貸出し履歴</label>
     <div class="tab-content">
      <c:choose>
       <c:when test="${empty detailForm.v_LendHistoryDtoList}">
        <div>貸出し履歴はありません。</div>
       </c:when>
       <c:otherwise>
        <div class="table-wrapper">
         <table class="text-center table table-bordered">
          <thead>
           <tr>
            <th>貸出日</th>
            <th>返却日</th>
            <th>名前</th>
           </tr>
          </thead>
          <tbody>
           <c:forEach items="${detailForm.v_LendHistoryDtoList}" var="lendHistory">
            <tr>
             <td><fmt:formatDate value="${lendHistory.fromDate}" pattern="yyyy/MM/dd" /></td>
             <td><fmt:formatDate value="${lendHistory.toDate}" pattern="yyyy/MM/dd" /></td>
             <td>${lendHistory.memName}</td>
            </tr>
           </c:forEach>
          </tbody>
         </table>
        </div>
       </c:otherwise>
      </c:choose>
     </div>
     <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-02">お気に入りしている人</label>
     <div class="tab-content">
      <div class="container">
       <c:choose>
        <c:when test="${empty detailForm.v_FavoriteMemberDtoList}">
         <div>お気に入りしている人はいません。</div>
        </c:when>
        <c:otherwise>
         <div class="table-body">
          <table class="text-center table table-borderless">
           <tbody>
            <c:forEach items="${detailForm.v_FavoriteMemberDtoList}" var="favoriteMember">
             <tr>
              <td>${favoriteMember.memName}</td>
             </tr>
            </c:forEach>
           </tbody>
          </table>
         </div>
        </c:otherwise>
       </c:choose>
      </div>
     </div>
     <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">おすすめしている人</label>
     <div class="tab-content">
      <div class="container">
       <c:choose>
        <c:when test="${empty detailForm.v_RecomMemDtoList}">
         <div>おすすめしている人はいません。</div>
        </c:when>
        <c:otherwise>
         <div class="table-body">
          <table class="text-center table table-borderless">
           <tbody>
            <c:forEach items="${detailForm.v_RecomMemDtoList}" var="recomMember">
             <tr>
              <td>${recomMember.memName}</td>
             </tr>
            </c:forEach>
           </tbody>
          </table>
         </div>
        </c:otherwise>
       </c:choose>
      </div>
     </div>
    </div>
   </div>
  </div>
  <div class="detail-review">
   <div class="review-title"><i class="fas fa-star"></i>レビュー</div>
   <div id="review-list-more">
    <c:if test="${empty detailForm.v_LendHistoryDtoList}">レビューはありません。</c:if>
    <ul>
     <c:forEach items="${detailForm.v_LendHistoryDtoList}" var="lendHistory">
      <c:if test="${not empty lendHistory.review}">
       <li>
        <div class="review-contents">${lendHistory.review}</div>
        <div class="reviewer"><span><fmt:formatDate value="${lendHistory.updateAt}" pattern="yyyy/MM/dd" /></span> <span>${lendHistory.memName}</span></div>
       </li>
      </c:if>
     </c:forEach>
    </ul>
    <div class="read-more" id="more-btn">その他のレビューを表示<i class="fa fa-chevron-down" aria-hidden="true"></i></div>
    <div class="read-more" id="close-btn">閉じる<i class="fa fa-chevron-up" aria-hidden="true"></i></div>
   </div>
  </div>
 </section>
 <jsp:include page="detailModal.jsp"></jsp:include>

 <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 <script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 <script src="resources/js/detail.js"></script>
</body>
</html>