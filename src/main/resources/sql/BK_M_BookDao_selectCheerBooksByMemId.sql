/* BK_M_BookDao_selectCheerBooksByMemId.sql */
select
    B.REQUEST_ID
from
    book_db.BK_T_REQUEST_CHEER B
where
    B.MEM_ID = /*memId*/
;