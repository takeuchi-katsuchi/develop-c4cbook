package jp.co.c4c.db.dto;

import java.util.Arrays;
import java.util.Date;

public class V_RecomToMeBookDto {

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
    /** 画像 */
    private byte[] bookImg;
    /** 画像（encode）*/
    private String encodedBookImg;

    /////////////////////
    // BK_T_RecomDto
    /////////////////////
    /** FROMメンバーID */
    private int memId;
    /** おすすめ日 */
    private Date recomDate;

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

    public byte[] getBookImg() {
        return bookImg;
    }

    public String getEncodedBookImg() {
        return encodedBookImg;
    }

    public void setEncodedBookImg(String encodedBookImg) {
        this.encodedBookImg = encodedBookImg;
    }

    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public Date getRecomDate() {
        return recomDate;
    }

    public void setRecomDate(Date recomDate) {
        this.recomDate = recomDate;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    @Override
    public String toString() {
        return "V_MyRecommendedBookDto [bookId=" + bookId + ", title=" + title + ", titleKana=" + titleKana
                + ", author=" + author + ", authorKana=" + authorKana + ", tagIds=" + tagIds + ", bookImg="
                + Arrays.toString(bookImg) + ", memId=" + memId + ", recomDate=" + recomDate + ", memName=" + memName
                + "]";
    }

}
