/* BK_M_BookDao_selectBookByBookId.sql */
select
  B.BOOK_ID,
  B.TITLE,
  B.AUTHOR,
  B.TAG_IDS,
  B.OUTLINE,
  B.BOOK_IMG,
  LM.LEND_ID,
  LM.MEM_ID,
  LM.LEND_STATUS,
  LM.MEM_NAME,
  FC.FAV_COUNT,
  RC.LEND_COUNT
from
  book_db.BK_M_BOOK as B
left join
 (select
    book_db.BK_T_LEND.BOOK_ID,
    book_db.BK_T_LEND.LEND_ID,
    book_db.BK_T_LEND.MEM_ID,
    book_db.BK_T_LEND.LEND_STATUS,
    book_db.M_MEM_BASIC.MEM_NAME
  from
    book_db.BK_T_LEND
  join
    book_db.M_MEM_BASIC
  on
    book_db.BK_T_LEND.MEM_ID = book_db.M_MEM_BASIC.MEM_ID
  where
    LEND_STATUS = 11) as LM
on
  B.BOOK_ID = LM.BOOK_ID
left join
(select
    BOOK_ID,
    count(BOOK_ID) as FAV_COUNT

  from
    book_db.BK_T_FAVORITE
  group by
    BOOK_ID
) as FC
on
  B.BOOK_ID = FC.BOOK_ID
left join
 (select
    BOOK_ID,
    count(BOOK_ID) as LEND_COUNT
  from
    book_db.BK_T_LEND
  group by
    BOOK_ID
) as RC
on
  B.BOOK_ID = RC.BOOK_ID
where
  B.BOOK_ID = /*bookId*/
;