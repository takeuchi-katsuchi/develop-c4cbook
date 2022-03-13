/* BK_M_BookDao_selectRecommendedBooksByMemId.sql */
select
    B.BOOK_ID,
    B.TITLE,
    B.TITLE_KANA,
    B.AUTHOR,
    B.AUTHOR_KANA,
    B.TAG_IDS,
    B.BOOK_IMG,
    LR.FROM_MEM_ID,
    LR.MEM_NAME,
    LR.RECOM_DATE
from
    book_db.BK_M_BOOK B join (
        select
            book_db.BK_T_RECOM.RECOM_ID,
            book_db.BK_T_RECOM.BOOK_ID,
            book_db.BK_T_RECOM.FROM_MEM_ID,
            book_db.BK_T_RECOM.TO_MEM_ID,
            book_db.BK_T_RECOM.RECOM_DATE,
            book_db.M_MEM_BASIC.MEM_NAME
        from
            book_db.BK_T_RECOM join book_db.M_MEM_BASIC
                on book_db.BK_T_RECOM.FROM_MEM_ID = book_db.M_MEM_BASIC.MEM_ID
        where
            DATE_ADD(RECOM_DATE, interval 3 month) > current_timestamp ()
            and book_db.BK_T_RECOM.TO_MEM_ID = /*memId*/
    ) as LR
        on B.BOOK_ID = LR.BOOK_ID
 ;