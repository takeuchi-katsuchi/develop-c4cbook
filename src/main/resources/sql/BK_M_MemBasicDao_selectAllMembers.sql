/* BK_M_MemBasicDao_selectAllMembers.sql */
select
    M.MEM_ID,
    M.MEM_NAME,
    M.DEL_FLG,
    M.CREATE_AT,
    M.UPDATE_AT
from
    book_db.M_MEM_BASIC as M
where
    DEL_FLG = 0
;