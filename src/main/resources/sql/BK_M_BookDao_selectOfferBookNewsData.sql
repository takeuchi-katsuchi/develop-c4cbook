/* BK_M_BookDao_selectOfferBookNewsData.sql */
select
    BOOK_ID,
    TITLE
from
    book_db.BK_M_BOOK
where
   OFFER_DATE > /*readTime*/
;