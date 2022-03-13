/* BK_M_BookDao_selectRecomeBookNewsData.sql */
select
    B.BOOK_ID,
    B.TITLE,
    R.TO_MEM_ID,
    R.RECOM_DATE
from
    book_db.BK_T_RECOM R join
    book_db.BK_M_BOOK B
on R.BOOK_ID = B.BOOK_ID
where
    R.TO_MEM_ID = /*memId*/ and
    R.RECOM_DATE > /*readTime*/
order by
    B.BOOK_ID asc
 ;