package jp.co.c4c.db.dto;

public class BK_T_FavoriteDto {

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
    /** メンバーID */
    private int memId;

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

    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

}