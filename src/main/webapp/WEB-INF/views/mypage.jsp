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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/menu.css" media="screen">
<link rel="stylesheet" href="resources/css/mypage.css" media="screen">
<link rel="stylesheet" href="resources/css/modal.css" media="screen">
</head>
<body>
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <jsp:include page="./menu.jsp"></jsp:include>
  <div class="contents">
   <div class="title">マイページ</div>
   <div class="bk-cnt">いままでに読んだ本…<p>${myForm.count}</p>冊</div>

   <div class="tab">
    <div class="tab-wrap">
     <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" /><label class="tab-label" for="TAB-01">予約・履歴</label>
     <div class="tab-content">
      <div class="card mb-2">
       <div class="card-header"><h5>予約中の本</h5></div>
       <div class="card-body">
        <c:if test="${myForm.myResevedBookList.size() == 0}">
         <%-- ログインユーザーが予約中の本がない場合 --%>
                    予約中の本はありません。
                  </c:if>
        <%-- ログインユーザーが予約中の本がある場合 --%>
        <c:forEach items="${myForm.myResevedBookList}" var="myReserveBook">
         <c:url var="detailLink" value="/detail"><c:param name="bookId" value="${myReserveBook.bookId}" /></c:url>
         <div class="row justify-content-center mb-2">
          <div class="col-6">
           <div><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${myReserveBook.encodedBookImg}" alt=""></a></div>
          </div>
          <div class="col-6">
           <table>
            <tr>
             <td class="name"><a href="${detailLink}">${myReserveBook.title}</a></td>
            </tr>
            <tr>
             <td class="author">${myReserveBook.author}</td>
            </tr>
           </table>
          </div>
         </div>
        </c:forEach>
       </div>
      </div>

      <div class="card mb-2">
       <div class="card-header"><h5>あなたに貸出中の本</h5></div>
       <div class="card-body">
        <c:if test="${myForm.myLendingBookList.size() == 0}">
         <%-- ログインユーザーに貸出中の本がない場合 --%>
                  あなたに貸出中の本はありません。
                </c:if>
        <c:forEach items="${myForm.myLendingBookList}" var="myLendingBook">
         <c:url var="detailLink" value="/detail"><c:param name="bookId" value="${myLendingBook.bookId}" /></c:url>
         <div class="row mb-2">
          <%-- ログインユーザーに貸出中の本がある場合 --%>
          <div class="col-12 lendBook-area"><span class="lendBook-mark">返却期日</span> <span class="toDate"><fmt:formatDate value="${myLendingBook.toDate}" pattern="yyyy/MM/dd" /></span> <span></span></div>
          <div class="col-6"><div><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${myLendingBook.encodedBookImg}" alt=""></a></div></div>
          <div class="col-6">
           <table>
            <tr>
             <td class="name"><a href="${detailLink}">${myLendingBook.title}</a></td>
            </tr>
            <tr>
             <td class="author">${myLendingBook.author}</td>
            </tr>
           </table>
          </div>
         </div>
        </c:forEach>
       </div>
      </div>

      <div class="card mb-2">
       <div class="card-header">
        <h5>いままでに読んだ本</h5>
       </div>
       <div class="card-body">
        <c:if test="${myForm.myReturnedBookList.size() == 0}">
         <%-- ログインユーザーが今までに読んだ本がない場合 --%>
                  いままでに読んだ本はありません。
                </c:if>
        <c:forEach items="${myForm.myReturnedBookList}" var="myReturnedBook">
         <c:url var="detailLink" value="/detail">
          <c:param name="bookId" value="${myReturnedBook.bookId}" />
         </c:url>
         <div class="row mb-2">
          <%-- ログインユーザーが今までに読んだ本がある場合 --%>
          <div class="col-6">
           <div>
            <a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${myReturnedBook.encodedBookImg}" alt=""></a>
           </div>
          </div>
          <div class="col-6">
           <table>
            <tr>
             <td class="name"><a href="${detailLink}">${myReturnedBook.title}</a></td>
            </tr>
            <tr>
             <td class="author">${myReturnedBook.author}</td>
            </tr>
           </table>
          </div>
         </div>
        </c:forEach>
       </div>
      </div>
     </div>

     <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /> <label class="tab-label" for="TAB-02">おすすめ</label>
     <div class="tab-content">
      <div class="card mb-2">
       <div class="card-header"><h5>おすすめの本</h5></div>
       <div class="card-body">
        <c:if test="${myForm.recomToMeBookList.size() == 0}">
         <%-- ログインユーザーにおすすめの本がない場合 --%>
                  おすすめの本はありません。
                </c:if>
        <%-- ログインユーザーにおすすめの本がある場合 --%>
        <c:forEach items="${myForm.recomToMeBookList}" var="recomToMeBook">
         <c:url var="detailLink" value="/detail"><c:param name="bookId" value="${recomToMeBook.bookId}" /></c:url>
         <div class="row mb-2">
          <div class="col-12 recom-area"><span class="recom-mark">おすすめ者</span> <span class="recom-mem">${recomToMeBook.memName}</span></div>
          <div class="col-6"><div><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${recomToMeBook.encodedBookImg}" alt=""></a></div></div>
          <div class="col-6">
           <table>
            <tr>
             <td class="name"><a href="${detailLink}">${recomToMeBook.title}</a></td>
            </tr>
            <tr>
             <td class="author">${recomToMeBook.author}</td>
            </tr>
           </table>
          </div>
         </div>
        </c:forEach>
       </div>
      </div>

     </div>
     <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">お気に入り</label>
     <div class="tab-content">
      <div class="card mb-2">
       <div class="card-header"><h5>お気に入りの本</h5></div>
       <div class="card-body">
        <c:if test="${myForm.myFavoriteBookList.size() == 0}">
         <%-- ログインユーザーがお気に入りの本がない場合 --%>
                  おすすめの本はありません。
                </c:if>
        <%-- ログインユーザーがお気に入りの本がある場合 --%>
        <c:forEach items="${myForm.myFavoriteBookList}" var="myFavoriteBook">
         <c:url var="detailLink" value="/detail"><c:param name="bookId" value="${myFavoriteBook.bookId}" /></c:url>
         <div class="row justify-content-center mb-2">
          <div class="col-6"><div><a href="${detailLink}"><img class="book-img" src="data:image/jpeg;base64,${myFavoriteBook.encodedBookImg}" alt=""></a></div></div>
          <div class="col-6">
           <table>
            <tr>
             <td class="name"><a href="${detailLink}">${myFavoriteBook.title}</a></td>
            </tr>
            <tr>
             <td class="author">${myFavoriteBook.author}</td>
            </tr>
           </table>
          </div>
         </div>
        </c:forEach>
       </div>
      </div>

     </div>
    </div>
   </div>
  </div>
 </section>
 <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</body>
</html>