/* BK_M_BookDao_selectLendHistorysByMemId.sql */
select
  book_db.BK_M_BOOK.BOOK_ID,
  book_db.BK_M_BOOK.TITLE,
  book_db.BK_M_BOOK.TITLE_KANA,
  book_db.BK_M_BOOK.AUTHOR,
  book_db.BK_M_BOOK.TAG_IDS,
  book_db.BK_M_BOOK.BOOK_IMG,

  book_db.BK_T_LEND.BOOK_ID,
  book_db.BK_T_LEND.LEND_ID,
  book_db.BK_T_LEND.MEM_ID,
  book_db.BK_T_LEND.LEND_STATUS,
  book_db.BK_T_LEND.FROM_DATE,
  book_db.BK_T_LEND.TO_DATE
from
  book_db.BK_M_BOOK
join
  book_db.BK_T_LEND on book_db.BK_M_BOOK.BOOK_ID = book_db.BK_T_LEND.BOOK_ID
where
  book_db.BK_T_LEND.DEL_FLG = 0
and
  book_db.BK_T_LEND.MEM_ID = /*memId*/
and
  book_db.BK_T_LEND.LEND_STATUS= 19
order by
  book_db.BK_T_LEND.BOOK_ID asc,
  book_db.BK_T_LEND.LEND_ID asc
;