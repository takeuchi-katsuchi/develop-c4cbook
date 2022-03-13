/* BK_T_LendDao_selectLendPiriodByMemId.sql */
select
  book_db.BK_T_LEND.MEM_ID,
  book_db.BK_T_LEND.LEND_STATUS,
  book_db.BK_T_LEND.TO_DATE
from
  book_db.BK_T_LEND
where
  book_db.BK_T_LEND.DEL_FLG = 0
and
  book_db.BK_T_LEND.MEM_ID = /*memId*/
and
  book_db.BK_T_LEND.LEND_STATUS = 11
;