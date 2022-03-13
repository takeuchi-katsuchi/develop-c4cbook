package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.V_RequestDto;

/**
 * 本要望画面 Formクラス
 */
public class RequestForm {

    /** 本要望情報一覧 */
    private List<V_RequestDto> reqInfoList;
    private List<Integer> myCheerBookIdList;

    public boolean chkMyCheerReqIdExist(int reqId) {
        return myCheerBookIdList.contains(reqId);
    }

    public List<Integer> getMyCheerBookIdList() {
        return myCheerBookIdList;
    }

    public void setMyCheerBookIdList(List<Integer> myCheerBookIdList) {
        this.myCheerBookIdList = myCheerBookIdList;
    }

    public List<V_RequestDto> getReqInfoList() {
        return reqInfoList;
    }

    public void setReqInfoList(List<V_RequestDto> reqInfoList) {
        this.reqInfoList = reqInfoList;
    }
}
