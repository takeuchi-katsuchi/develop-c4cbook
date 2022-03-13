<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<!-- 予約・貸出手続きModal -->
<div class="modal bd-example-modal-lg" id="LendingProcedureModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
 <div class="modal-dialog modal-lg" role="document">
  <div class="modal-content">

   <div class="modal-header">
    <h5 class="modal-title" id="myLargeModalLabel">貸出・予約・返却 手続き</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
     <span aria-hidden="true">&times;</span>
    </button>
   </div>

   <div class="modal-body">
    <div id='calendar'></div>
    <!-- 現在のLendStatus -->
    <div id="showStatus"></div>
    <form id="lendReserveForm" class="row mt-2" action="">
     <div class="col-sm-4 mb-1">貸出：<input id="lendChkBox" type="checkbox"> 予約：<input id="reserveChkBox" type="checkbox" checked="checked"></div>
     <div class="col-sm-4 mb-1">貸出日：<input id="postFromDate" type="text" name="fromDate" readonly="readonly"></div>
     <div class="col-sm-4 mb-1">返却日：<input id="postToDate" type="text" name="toDate" readonly="readonly"></div>
     <div>
      <!-- BookId -->
      <input id="postBookId" type="hidden" name="bookId" value="${detailForm.v_TopAndDetailDto.bookId}">
      <!-- メンバーID -->
      <input id="postMemberId" type="hidden" name="memId" value="${webSessionDto.memId}">
      <!-- LendStatus -->
      <input id="postLendStatus" type="hidden" name="lendStatus" value=10>
      <!-- 誰かに貸出中 -->
      <input id="isSomeoneLending" type="hidden" name="isSomeoneLending" value=0>
     </div>
    </form>
   </div>

   <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
    <button id="save" type="button" class="btn btn-primary">確定</button>
   </div>

  </div>
 </div>
</div>

<!-- 予約・貸出ステータス更新Modal -->
<div class="modal fade" id="myModal2">
 <div class="modal-dialog modal-dialog-centered">
  <div class="modal-content">
   <div class="modal-header">
    <h4 class="modal-title">ステータス更新</h4>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
   </div>
   <div class="modal-body form-group">
    <form id="updateLendStatusForm" action="">
     貸出：<input id="updateLendChkBox" type="checkbox"> 予約：<input id="updateReserveChkBox" type="checkbox"><br> 貸出日：<input id="updateFromDate" class="form-control" type="date" name="fromDate"> 返却日：<input id="updateToDate" class="form-control" type="date" name="toDate">
     <!-- LendId -->
     <input id="updateLendId" type="hidden" name="lendId" value="">
     <!-- BookId -->
     <input id="updateBookId" type="hidden" name="bookId" value="${detailForm.v_TopAndDetailDto.bookId}">
     <!-- メンバーID -->
     <input id="updateMemberId" type="hidden" name="memId" value="${webSessionDto.memId}">
     <!-- LendStatus -->
     <input id="updateLendStatus" type="hidden" name="lendStatus" value="">
    </form>
   </div>
   <div class="modal-footer">
    <button id="returnBook" type="button" class="btn btn-success d-none">返却</button>
    <button id="cancelReserve" type="button" class="btn btn-danger d-none">予約取消</button>
    <button id="update" type="button" class="btn btn-primary">更新</button>
   </div>
  </div>
 </div>
</div>

<!-- おすすめ・レビューModal -->
<div class="modal fade" id="reviewModal">
 <div class="modal-dialog modal-dialog-centered modal-lg">
  <div class="modal-content">
   <div class="modal-header"><h4 class="modal-title">おすすめ・レビュー</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
   <div class="modal-body form-group">
    <h4>おすすめしてみませんか?（最大5人まで）</h4>
    <div class="col-6">
     <form id="recomForm" action="">
      <div id="toMemberWrapper">
       <input id="toMemberId" type="hidden" value="">
       <div id="toMemberNames">
        <c:forEach items="${detailForm.bk_M_MemBasicDtoList}" var="member">
         <input type="checkbox" id="toMem_${member.memId}" value="${member.memId}" name="toMem">
         <label for="toMem_${member.memId}">${member.memName} さん</label><br>
        </c:forEach>
       </div>
      </div>
      <!-- BookId -->
      <input id="recomBookId" type="hidden" name="bookId" value="${detailForm.v_TopAndDetailDto.bookId}">
      <!-- fromメンバーID -->
      <input id="fromMemberId" type="hidden" name="memId" value="${webSessionDto.memId}">
     </form>
    </div>
    <br>
    <h4>この本のレビューをしましょう</h4>
    <div class="col">
     <form id="reviewForm" class="mt-2" action=""><textarea id="reviewContent" class="form-control" rows="5" cols=""></textarea></form>
     <div class="text-right"><span id="reviewLength">0</span>/1000</div>
    </div>
   </div>
   <div class="modal-footer"><button id="sendReview" type="button" class="btn btn-primary">送信</button></div>
  </div>
 </div>
</div>
