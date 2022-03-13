package jp.co.c4c.db.dto;

public class V_FavoriteMemberDto {

    /////////////////////
    // BK_M_BookDto
    /////////////////////
    /** 本ID */
    private int bookId;

    /////////////////////
    // BK_T_FavoriteDto
    /////////////////////
    /** メンバーID */
    private int memId;

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

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

}
