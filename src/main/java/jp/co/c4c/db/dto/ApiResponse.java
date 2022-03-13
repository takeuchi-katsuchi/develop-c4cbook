package jp.co.c4c.db.dto;

import java.util.List;

public class ApiResponse<T> {

    private String status;
    private T data;
    private List<T> dataList;
    List<Integer> myFavoriteBookIdList;
    List<Integer> myLendedBookIdList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse() {
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<Integer> getMyFavoriteBookIdList() {
        return myFavoriteBookIdList;
    }

    public void setMyFavoriteBookIdList(List<Integer> myFavoriteBookIdList) {
        this.myFavoriteBookIdList = myFavoriteBookIdList;
    }

    public List<Integer> getMyLendedBookIdList() {
        return myLendedBookIdList;
    }

    public void setMyLendedBookIdList(List<Integer> myLendedBookIdList) {
        this.myLendedBookIdList = myLendedBookIdList;
    }
}