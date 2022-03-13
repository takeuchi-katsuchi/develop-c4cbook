package jp.co.c4c.db.dto;

public class V_RecomMemDto {

    /////////////////////
    // BK_T_RecomDto
    /////////////////////
    /** 本ID */
    private int bookId;

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

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }
}
