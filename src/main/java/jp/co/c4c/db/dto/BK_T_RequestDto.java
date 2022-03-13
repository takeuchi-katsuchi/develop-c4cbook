package jp.co.c4c.db.dto;

import java.util.Date;

public class BK_T_RequestDto {

    /** 本ID */
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
    /** 要望メンバーID */
    private int memId;
    /** 要望コメント */
    private String comment;
    /** 要望ステータス */
    private String requestStatus;
    /** 否認コメント */
    private String rejectComment;
    /** 削除フラグ */
    private int delFlg;
    /** データ作成日時 */
    private Date createAt;
    /** データ更新日時 */
    private Date updateAt;

    /**
     * 本IDを取得する
     * @return bookId
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * 本IDを設定する
     * @param bookId
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
     * @param bookImg
     */
    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * 要望メンバーIDを取得する
     * @return mem_id
     */
    public int getMemId() {
        return memId;
    }

    /**
     * 要望メンバーIDを設定する
     * @param mem_id
     */    public void setMemId(int memId) {
        this.memId = memId;
    }
    /**
     * 要望コメントを取得する
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 要望コメントを設定する
     * @param comment
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
     * @param requestStatus
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
}