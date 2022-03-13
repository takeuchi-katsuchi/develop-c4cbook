/* BK_T_NewsReadDao_updateNewsReadDateByMemId.sql */
update
    book_db.BK_T_NEWS_READ
set
    READ_AT = SYSDATE(),
    UPDATE_AT =  SYSDATE()
where
    MEM_ID = /*memId*/
;