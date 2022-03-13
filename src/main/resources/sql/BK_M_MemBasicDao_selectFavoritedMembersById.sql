/* BK_M_MemBasicDao_selectFavoritedMembersById.sql */
SELECT
    F.BOOK_ID,
    F.MEM_ID,
    M.MEM_NAME
FROM
    book_db.BK_T_FAVORITE as F
JOIN
    book_db.M_MEM_BASIC as M
ON
    F.MEM_ID = M.MEM_ID
WHERE
    BOOK_ID = /*bookId*/;