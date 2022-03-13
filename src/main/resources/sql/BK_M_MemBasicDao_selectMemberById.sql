-- BK_M_MemBasicDao_selectMemberById
SELECT
    M.MEM_ID,
    M.MEM_NAME,
    M.DEL_FLG,
    M.CREATE_AT,
    M.UPDATE_AT
FROM
    book_db.M_MEM_BASIC as M
WHERE
    MEM_ID = /*memId*/
AND
    DEL_FLG = 0
;