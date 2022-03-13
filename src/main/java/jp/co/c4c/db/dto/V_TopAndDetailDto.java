package jp.co.c4c.db.dto;

import java.util.Date;

public class V_TopAndDetailDto {

    /////////////////////
    // BK_M_BookDto
    /////////////////////
    /** 本ID */
    private int bookId;
    /** タイトル */
    private String title;
    /** タイトルかな */
    private String titleKana;
    /** 著者 */
    private String author;
    /** 著者かな */
    private String authorKana;
    /** タグ */
    private String tagIds;
    /** 概要 */
    private String outline;
    /** 画像 */
    private byte[] bookImg;
    /** 画像（encode）*/
    private String encodedBookImg;
    /** 提供メンバーID */
    private int offerMemId;
    /** 提供メンバーコメント */
    private String offerMemComment;
    /** 提供日 */
    private Date offerDate;

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

    /////////////////////
    // BK_M_MemBasicDto
    /////////////////////
    /** メンバー名 */
    private String memName;

    /////////////////////
    // その他
    /////////////////////
    /** お気に入り回数 */
    private int favCount;
    /** 貸出回数 */
    private int lendCount;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleKana() {
        return titleKana;
    }

    public void setTitleKana(String titleKana) {
        this.titleKana = titleKana;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorKana() {
        return authorKana;
    }

    public void setAuthorKana(String authorKana) {
        this.authorKana = authorKana;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public byte[] getBookImg() {
        return bookImg;
    }

    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    public String getEncodedBookImg() {
        return encodedBookImg;
    }

    public void setEncodedBookImg(String encodedBookImg) {
        this.encodedBookImg = encodedBookImg;
    }

    public int getOfferMemId() {
        return offerMemId;
    }

    public void setOfferMemId(int offerMemId) {
        this.offerMemId = offerMemId;
    }

    public String getOfferMemComment() {
        return offerMemComment;
    }

    public void setOfferMemComment(String offerMemComment) {
        this.offerMemComment = offerMemComment;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
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

    public void setReview(String review) {
        this.review = review;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getFavCount() {
        return favCount;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public int getLendCount() {
        return lendCount;
    }

    public void setLendCount(int lendCount) {
        this.lendCount = lendCount;
    }

}
