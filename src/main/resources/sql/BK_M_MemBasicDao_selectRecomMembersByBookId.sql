/* BK_M_MemBasicDao_selectRecomMembersByBookId.sql */
select distinct
    book_db.BK_T_RECOM.BOOK_ID,
    book_db.M_MEM_BASIC.MEM_NAME
from
    book_db.BK_T_RECOM join book_db.M_MEM_BASIC
        on book_db.BK_T_RECOM.FROM_MEM_ID = book_db.M_MEM_BASIC.MEM_ID
where
    BOOK_ID = /*bookId*/
order by
    book_db.BK_T_RECOM.RECOM_DATE desc
;
