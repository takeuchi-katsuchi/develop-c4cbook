package jp.co.c4c.db.dto;

import java.util.Date;

public class V_RequestDto {

    /////////////////////
    // V_RequestDto
    /////////////////////
    /** 要望ID */
    private int requestId;
    /** タイトル */
    private String title;
    /** タイトルかな */
    private String titleKana;
    /** 著者 */
    private String author;
    /** 著者かな */
    private String authorKana;
    /** 画像 */
    private byte[] bookImg;
    /** 画像（encode）*/
    private String encodedBookImg;
    /** 要望者ID */
    private String memId;
    /** 要望コメント */
    private String comment;
    /** 要望ステータス */
    private String requestStatus;
    /** 否認コメント */
    private String rejectComment;
    /** データ作成日時 */
    private Date createAt;

    /////////////////////
    // BK_M_MemBasicDto
    /////////////////////
    /** 要望者名 */
    private String memName;

    /////////////////////
    // その他
    /////////////////////
    /** 応援数 */
    private int reqCount;

    /**
     * 要望IDを取得する
     * @return requestId
     */    public int getRequestId() {
        return requestId;
    }

     /**
      * 要望IDを設定する
      * @return requestId
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /**
     * タイトルを取得する
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定する
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * タイトルかなを取得する
     * @return titleKana
     */
    public String getTitleKana() {
        return titleKana;
    }

    /**
     * タイトルかなを設定する
     * @param titleKana
     */
    public void setTitleKana(String titleKana) {
        this.titleKana = titleKana;
    }

    /**
     * 著者を取得する
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 著者を設定する
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 著者かなを取得する
     * @return authorKana
     */
    public String getAuthorKana() {
        return authorKana;
    }

    /**
     * 著者かなを設定する
     * @param authorKana
     */
    public void setAuthorKana(String authorKana) {
        this.authorKana = authorKana;
    }

    /**
     * 画像を取得する
     * @return bookImg
     */
    public byte[] getBookImg() {
        return bookImg;
    }

    /**
     * 画像を設定する
     * @param authorKana
     */
    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * 画像（encode）を取得する
     * @return bookImg
     */
    public String getEncodedBookImg() {
        return encodedBookImg;
    }

    /**
     * 画像（encode）を設定する
     * @param authorKana
     */
    public void setEncodedBookImg(String encodedBookImg) {
        this.encodedBookImg = encodedBookImg;
    }

    /**
     * 要望者IDを取得する
     * @return memId
     */
    public String getMemId() {
        return memId;
    }

    /**
     * 要望者IDを設定する
     * @param memId セットする memId
     */
    public void setMemId(String memId) {
        this.memId = memId;
    }

    /**
     * 要望者コメントを取得する
     * @return memId
     */
    public String getComment() {
        return comment;
    }

    /**
     * 要望者コメントを設定する
     * @param memId セットする memId
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 要望ステータスを取得する
     * @return requestStatus
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * 要望ステータスを設定する
     * @param requestStatus セットする requestStatus
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * 否認コメントを取得する
     * @return rejectComment
     */
    public String getRejectComment() {
        return rejectComment;
    }

    /**
     * 否認コメントを設定する
     * @param rejectComment セットする rejectComment
     */
    public void setRejectComment(String rejectComment) {
        this.rejectComment = rejectComment;
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
     * @param createAt セットする createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 要望者名を取得する
     * @return memName
     */
    public String getMemName() {
        return memName;
    }

    /**
     * 要望者名を設定する
     * @param memName セットする memName
     */
    public void setMemName(String memName) {
        this.memName = memName;
    }

    /**
     * 応援数を取得する
     * @return reqCount
     */
    public int getReqCount() {
        return reqCount;
    }

    /**
     * 応援数を設定する
     * @param reqCount セットする reqCount
     */
    public void setReqCount(int reqCount) {
        this.reqCount = reqCount;
    }
}
