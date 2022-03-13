/* BK_T_RequestDao_insertRequestBook.sql */
insert into book_db.BK_T_REQUEST
(
    REQUEST_ID,
    TITLE,
    TITLE_KANA,
    AUTHOR,
    AUTHOR_KANA,
    BOOK_IMG,
    MEM_ID,
    COMMENT,
    REQUEST_STATUS,
    REJECT_COMMENT,
    DEL_FLG,
    CREATE_AT,
    UPDATE_AT
)
values
(
    /*requestId*/,
    /*title*/,
    /*titleKana*/,
    /*author*/,
    /*authorKana*/,
    /*bookImg*/,
    /*memId*/,
    /*comment*/,
    /*requestStatus*/,
    /*rejectComment*/,
    /*delFlg*/,
    /*createAt*/,
    /*updateAt*/
)
on DUPLICATE key update REQUEST_STATUS = /*requestStatus*/, REJECT_COMMENT = /*rejectComment*/, DEL_FLG = /*delFlg*/, UPDATE_AT = /*updateAt*/
;