<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- ソートModal -->
<div class="modal fade" id="sort_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title sort_title" id="exampleModalLabel">並び替え</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
   </div>
   <div class="modal-body">
    <div class="row">
     <div class="col-6"><input id="sort_1" type="checkbox" name="sortCond" value="1" disabled="disabled"> <label for="sort_1">最新入荷日順</label></div>
     <div class="col-6"><input id="sort_2" type="checkbox" name="sortCond" value="2" disabled="disabled"> <label for="sort_2">五十音順</label></div>
     <div class="col-6"><input id="sort_3" type="checkbox" name="sortCond" value="3" disabled="disabled"> <label for="sort_3">お気に入り数順</label></div>
     <div class="col-6"><input id="sort_4" type="checkbox" name="sortCond" value="4" disabled="disabled"> <label for="sort_4">読まれた回数順</label></div>
    </div>
   </div>
   <div class="modal-footer"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button></div>
  </div>
 </div>
</div>

<!-- フィルターModal -->
<div class="modal fade" id="filter_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title filter_title">タグ絞り込み</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
   </div>
   <div class="modal-body">
    <div class="row">
     <div class="col-4"><input id="filter_1" type="checkbox" name="filterCond" value="1" disabled="disabled" /> <label for="filter_1">資格</label></div>
     <div class="col-4"><input id="filter_column2" type="checkbox" name="filterCond" value="2" disabled="disabled" /> <label for="filter_column2">入門書</label></div>
     <div class="col-4"><input id="filter_column3" type="checkbox" name="filterCond" value="3" disabled="disabled" /> <label for="filter_column3">web開発</label></div>
     <div class="col-4"><input id="filter_column4" type="checkbox" name="filterCond" value="4" disabled="disabled" /> <label for="filter_column4">実用書</label></div>
     <div class="col-4"><input id="filter_column5" type="checkbox" name="filterCond" value="5" disabled="disabled" /> <label for="filter_column5">娯楽</label></div>
    </div>
   </div>
   <div class="modal-footer"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button></div>
  </div>
 </div>
</div>
