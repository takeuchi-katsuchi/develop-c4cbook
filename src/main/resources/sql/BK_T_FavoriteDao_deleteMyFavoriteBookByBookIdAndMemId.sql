DELETE FROM
	book_db.BK_T_FAVORITE
WHERE
	(BOOK_ID = /*bookId*/)
	and
	(`MEM_ID` = /*memId*/);
