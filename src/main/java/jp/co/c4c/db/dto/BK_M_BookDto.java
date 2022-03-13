package jp.co.c4c.db.dto;

import java.util.Date;

public class BK_M_BookDto {

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
    /** 提供メンバーID */
    private int offerMemId;
    /** 提供メンバーコメント */
    private String offerMemComment;
    /** 提供日 */
    private Date offerDate;
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
     * @param authorKana セットする authorKana
     */
    public void setAuthorKana(String authorKana) {
        this.authorKana = authorKana;
    }

    /**
     * タグを取得する
     * @return tagIds
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     * タグを設定する
     * @param tagIds
     */
    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    /**
     * 概要を取得する
     * @return outline
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 概要を設定する
     * @param outline
     */
    public void setOutline(String outline) {
        this.outline = outline;
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
     * 提供メンバーIDを取得する
     * @return offerMemId
     */
    public int getOfferMemId() {
        return offerMemId;
    }

    /**
     * 提供メンバーIDを設定する
     * @param offerMemId
     */
    public void setOfferMemId(int offerMemId) {
        this.offerMemId = offerMemId;
    }

    /**
     * 提供メンバーコメントを取得する
     * @return offerMemComment
     */
    public String getOfferMemComment() {
        return offerMemComment;
    }

    /**
     * 提供メンバーコメントを設定する
     * @param offerMemComment
     */
    public void setOfferMemComment(String offerMemComment) {
        this.offerMemComment = offerMemComment;
    }

    /**
     * 提供日を取得する
     * @return offerDate
     */
    public Date getOfferDate() {
        return offerDate;
    }

    /**
     * 提供日を設定する
     * @param offerDate
     */
    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
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