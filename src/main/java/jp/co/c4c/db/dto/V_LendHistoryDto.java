package jp.co.c4c.db.dto;

import java.util.Date;

public class V_LendHistoryDto {

    /////////////////////
    // BK_M_BookDto
    /////////////////////
    /** 本ID */
    private int bookId;

    /////////////////////
    // BK_T_LendDto
    /////////////////////
    /** 貸出ID */
    private int lendId;
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
    /** 更新日 */
    private Date updateAt;

    /////////////////////
    // BK_M_MemBasicDto
    /////////////////////
    /** メンバー名 */
    private String memName;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLendId() {
        return lendId;
    }

    public void setLendId(int lendId) {
        this.lendId = lendId;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public int getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(int lendStatus) {
        this.lendStatus = lendStatus;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReview() {
        return review;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

}
