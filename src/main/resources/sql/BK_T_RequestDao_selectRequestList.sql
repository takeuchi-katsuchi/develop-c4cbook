/* BK_T_RequestDao_selectRequestList.sql */
select
    book_db.BK_T_REQUEST.REQUEST_ID,
    book_db.BK_T_REQUEST.TITLE,
    book_db.BK_T_REQUEST.TITLE_KANA,
    book_db.BK_T_REQUEST.AUTHOR,
    book_db.BK_T_REQUEST.AUTHOR_KANA,
    book_db.BK_T_REQUEST.BOOK_IMG,
    book_db.BK_T_REQUEST.MEM_ID,
    book_db.BK_T_REQUEST.comment,
    book_db.BK_T_REQUEST.REQUEST_STATUS,
    book_db.BK_T_REQUEST.REJECT_COMMENT,
    book_db.BK_T_REQUEST.CREATE_AT,
    RM.MEM_NAME,
    CC.REQ_COUNT
from
    book_db.BK_T_REQUEST
    left join (
        select
            book_db.BK_T_REQUEST.REQUEST_ID,
            book_db.BK_T_REQUEST.MEM_ID,
            book_db.M_MEM_BASIC.MEM_NAME
        from
            book_db.BK_T_REQUEST join book_db.M_MEM_BASIC
                on book_db.BK_T_REQUEST.MEM_ID = book_db.M_MEM_BASIC.MEM_ID
    ) as RM
        on book_db.BK_T_REQUEST.REQUEST_ID = RM.REQUEST_ID
    left join (
        select
            book_db.BK_T_REQUEST_CHEER.REQUEST_ID,
            book_db.BK_T_REQUEST_CHEER.MEM_ID,
            count(book_db.BK_T_REQUEST_CHEER.REQUEST_ID) as REQ_COUNT
        from
            book_db.BK_T_REQUEST join book_db.BK_T_REQUEST_CHEER
                on book_db.BK_T_REQUEST.REQUEST_ID = book_db.BK_T_REQUEST_CHEER.REQUEST_ID
        group by
            BK_T_REQUEST.REQUEST_ID
    ) as CC
        on book_db.BK_T_REQUEST.REQUEST_ID = CC.REQUEST_ID
where
    DEL_FLG = 0
order by
book_db.BK_T_REQUEST.REQUEST_STATUS = 9 ASC,
book_db.BK_T_REQUEST.CREATE_AT DESC
;