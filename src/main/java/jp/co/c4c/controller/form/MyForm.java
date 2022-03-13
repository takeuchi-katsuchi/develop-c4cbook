package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;

/**
 * マイページ画面 Formクラス
 */
public class MyForm {

    /** 読んだ本の数 */
    private String count;
    /** ログインユーザーが予約中の本 */
    private List<V_MyLendHistoryDto> myResevedBookList;
    /** ログインユーザーに貸出中の本 */
    private List<V_MyLendHistoryDto> myLendingBookList;
    /** ログインユーザーが返却済み（読書済み）の本 */
    private List<V_MyLendHistoryDto> myReturnedBookList;
    /** ログインユーザーにおすすめされている本 */
    private List<V_RecomToMeBookDto> recomToMeBookList;
    /** ログインユーザーがお気に入りの本 */
    private List<V_MyFavoriteBookDto> myFavoriteBookList;

    /**
     * 読んだ本の数
     *
     * @return 読んだ本の数
     */
    public String getCount() {
        return count;
    }

    /**
     * 読んだ本の数
     *
     * @param count 読んだ本の数
     */
    public void setCount(String count) {
        this.count = count;
    }

    public List<V_MyLendHistoryDto> getMyResevedBookList() {
        return myResevedBookList;
    }

    public void setMyResevedBookList(List<V_MyLendHistoryDto> myResevedBookList) {
        this.myResevedBookList = myResevedBookList;
    }

    public List<V_MyLendHistoryDto> getMyLendingBookList() {
        return myLendingBookList;
    }

    public void setMyLendingBookList(List<V_MyLendHistoryDto> myLendingBookList) {
        this.myLendingBookList = myLendingBookList;
    }

    public List<V_MyLendHistoryDto> getMyReturnedBookList() {
        return myReturnedBookList;
    }

    public void setMyReturnedBookList(List<V_MyLendHistoryDto> myReturnedBookList) {
        this.myReturnedBookList = myReturnedBookList;
    }

    public List<V_RecomToMeBookDto> getRecomToMeBookList() {
        return recomToMeBookList;
    }

    public void setRecomToMeBookList(List<V_RecomToMeBookDto> recomToMeBookList) {
        this.recomToMeBookList = recomToMeBookList;
    }

    public List<V_MyFavoriteBookDto> getMyFavoriteBookList() {
        return myFavoriteBookList;
    }

    public void setMyFavoriteBookList(List<V_MyFavoriteBookDto> myFavoriteBookList) {
        this.myFavoriteBookList = myFavoriteBookList;
    }

}
