/* BK_T_RequestDao_selectRequestBookNewsData.sql */
select
    REQUEST_ID,
    TITLE,
    MEM_ID,
    REQUEST_STATUS,
    UPDATE_AT
from
    book_db.BK_T_REQUEST
where
    MEM_ID = /*memId*/
and
    REQUEST_STATUS = 1
and
    UPDATE_AT > /*readTime*/
;