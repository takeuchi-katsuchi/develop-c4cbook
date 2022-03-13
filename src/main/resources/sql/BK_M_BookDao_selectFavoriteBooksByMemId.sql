/* BK_M_BookDao_selectFavoriteBooksByMemId.sql */
select
    B.BOOK_ID,
    B.TITLE,
    B.AUTHOR,
    B.TAG_IDS,
    B.OUTLINE,
    B.BOOK_IMG,
    FC.MEM_ID,
    FC.MEM_NAME
from
    book_db.BK_M_BOOK B join (
        select
            book_db.BK_T_FAVORITE.BOOK_ID,
            book_db.BK_T_FAVORITE.MEM_ID,
            book_db.M_MEM_BASIC.MEM_NAME
        from
            book_db.BK_T_FAVORITE join book_db.M_MEM_BASIC
                on book_db.BK_T_FAVORITE.MEM_ID = book_db.M_MEM_BASIC.MEM_ID
        where
            book_db.BK_T_FAVORITE.MEM_ID = /*memId*/
    ) as FC
        on B.BOOK_ID = FC.BOOK_ID
;