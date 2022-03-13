/* BK_T_LendDao_updateLendBookforReview.sql */
UPDATE book_db.BK_T_LEND
SET
    REVIEW = /*review*/,
    UPDATE_AT = /*updateAt*/
WHERE
    LEND_ID = /*lendId*/
;