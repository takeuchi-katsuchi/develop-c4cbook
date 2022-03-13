/* BK_T_LendDao_selectLendHistorysById.sql */
SELECT
    B.BOOK_ID,
    L.LEND_ID,
    L.MEM_ID,
    L.LEND_STATUS,
    L.FROM_DATE,
    L.TO_DATE,
    L.REVIEW,
    L.UPDATE_AT,
    M.MEM_NAME
FROM
    book_db.BK_M_BOOK as B
JOIN
    book_db.BK_T_LEND as L
ON
    B.BOOK_ID = L.BOOK_ID
JOIN
    book_db.M_MEM_BASIC as M
ON
    L.MEM_ID = M.MEM_ID
WHERE
    B.BOOK_ID = /*bookId*/
;