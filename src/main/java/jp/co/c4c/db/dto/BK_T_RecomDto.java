package jp.co.c4c.db.dto;

import java.util.Date;

public class BK_T_RecomDto {

    /** おすすめID */
    private int recomId;
    /** 本ID */
    private int bookId;
    /** おすすめ元メンバーID */
    private int fromMemId;
    /** おすすめ先メンバーID */
    private int toMemId;
    /** おすすめ日 */
    private Date recomDate;
    /** 削除フラグ */
    private int delFlg;
    /** データ作成日時 */
    private Date createAt;
    /** データ更新日時 */
    private Date updateAt;

    /**
     * おすすめIDを取得する
     * @return recomId
     */
    public int getRecomId() {
        return recomId;
    }

    /**
     * おすすめIDを設定する
     * @param recomId
     */
    public void setRecomId(int recomId) {
        this.recomId = recomId;
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
     * おすすめ元メンバーIDを取得する
     * @return fromMemId
     */
    public int getFromMemId() {
        return fromMemId;
    }

    /**
     * おすすめ元メンバーIDを設定する
     * @param fromMemId セットする fromMemId
     */
    public void setFromMemId(int fromMemId) {
        this.fromMemId = fromMemId;
    }

    /**
     * おすすめ先メンバーIDを取得する
     * @return toMemId
     */
    public int getToMemId() {
        return toMemId;
    }

    /**
     * おすすめ先メンバーIDを設定する
     * @param toMemId セットする toMemId
     */
    public void setToMemId(int toMemId) {
        this.toMemId = toMemId;
    }

    /**
     * おすすめ日を取得する
     * @return recomDate
     */
    public Date getRecomDate() {
        return recomDate;
    }

    /**
     * おすすめ日を設定する
     * @param recomDate
     */
    public void setRecomDate(Date recomDate) {
        this.recomDate = recomDate;
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