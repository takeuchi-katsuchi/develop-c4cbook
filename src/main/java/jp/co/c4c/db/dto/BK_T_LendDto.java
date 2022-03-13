package jp.co.c4c.db.dto;

import java.util.Date;

public class BK_T_LendDto {

    /** 貸出ID */
    private int lendId;
    /** 本ID */
    private int bookId;
    /** メンバーID */
    private int memId;
    /** 貸出ステータス */
    private int lendStatus;
    /** 貸出日 */
    private Date fromDate;
    /** 返却日 */
    private Date toDate;
    /** レビュー */
    private String review;
    /** 削除フラグ */
    private int delFlg;
    /** データ作成日時 */
    private Date createAt;
    /** データ更新日時 */
    private Date updateAt;

    /**
     * 貸出IDを取得する
     * @return lendId
     */
    public int getLendId() {
        return lendId;
    }

    /**
     * 貸出IDを取得する
     * @param lendId
     */
    public void setLendId(int lendId) {
        this.lendId = lendId;
    }

    /**
     * 本IDを取得する
     * @return bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * 本IDを設定する
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * メンバーIDを取得する
     * @return memId
     */
    public int getMemId() {
        return memId;
    }

    /**
     * メンバーIDを設定する
     * @param memId
     */
    public void setMemId(int memId) {
        this.memId = memId;
    }

    /**
     * 貸出ステータスを取得する
     * @return lendStatus
     */
    public int getLendStatus() {
        return lendStatus;
    }

    /**
     * 貸出ステータスを取得する
     * @param lendStatus セットする lendStatus
     */
    public void setLendStatus(int lendStatus) {
        this.lendStatus = lendStatus;
    }

    /**
     * 貸出日を取得する
     * @return fromDate
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * 貸出日を設定する
     * @param fromDate
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * 返却日を取得する
     * @return toDate
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * 返却日を設定する
     * @param toDate セットする toDate
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * レビューを取得する
     * @return review
     */
    public String getReview() {
        return review;
    }

    /**
     * レビューを取得する
     * @param review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * 削除フラグを取得する
     * @return delFlg
     */
    public int getDelFlg() {
        return delFlg;
    }

    /**
     * 削除フラグを設定する
     * @param delFlg
     */
    public void setDelFlg(int delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * データ作成日時を取得する
     * @return createAt
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * データ作成日時を設定する
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * データ更新日時を取得する
     * @return updateAt
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * データ更新日時を設定する
     * @param updateAt
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "BK_T_LendDto [lendId=" + lendId + ", bookId=" + bookId + ", memId=" + memId + ", lendStatus="
                + lendStatus + ", fromDate=" + fromDate + ", toDate=" + toDate + ", review=" + review + ", delFlg="
                + delFlg + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
    }

}