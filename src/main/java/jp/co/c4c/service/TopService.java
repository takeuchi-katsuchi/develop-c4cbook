package jp.co.c4c.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.BK_M_BookDao;
import jp.co.c4c.db.dao.BK_T_FavoriteDao;
import jp.co.c4c.db.dao.BK_T_LendDao;
import jp.co.c4c.db.dao.BK_T_NewsReadDao;
import jp.co.c4c.db.dao.BK_T_RequestDao;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class TopService {

    @Autowired
    private BK_T_RequestDao requestDao;
    @Autowired
    private BK_M_BookDao bookDao;
    @Autowired
    private BK_T_LendDao lendDao;
    @Autowired
    private BK_T_NewsReadDao newsReadDao;
    @Autowired
    private BK_T_FavoriteDao favoriteDao;

    /**
     * トップページに表示させる本のリストを取得
     * @return
     */
    @Transactional
    public List<V_TopAndDetailDto> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    /**
     * ログインユーザーがお気に入り済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyFavoriteBookDto> getFavoriteBooks(int memId) {
        return bookDao.selectFavoriteBooksByMemId(memId);
    }

    /**
     * ログインユーザーが読書済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getlendedBooks(int memId) {
        return bookDao.selectLendHistorysByMemId(memId);
    }

    /**
     * お気に入りの本を登録
     * @param bk_T_FavoriteDto
     */
    @Transactional
    public void saveMyFavoriteBook(BK_T_FavoriteDto bk_T_FavoriteDto) {
        favoriteDao.insertMyFavoriteBook(bk_T_FavoriteDto);
    }

    /**
     * お気に入りの本を削除
     * @param bk_T_FavoriteDto
     */
    @Transactional
    public void deleteMyFavoriteBook(BK_T_FavoriteDto bk_T_FavoriteDto) {
        favoriteDao.deleteMyFavoriteBookByBookIdAndMemId(bk_T_FavoriteDto);
    }

    /**
     * 貸出期限のお知らせ情報取得用
     * @param memId
     * @return
     */
    @Transactional
    public List<BK_T_LendDto> getLendNewsByMemId(int memId) {
        return lendDao.selectLendPiriodByMemId(memId);
    }

    /**
     * お知らせの既読時間を取得
     * @param memId
     * @return
     */
    @Transactional
    public BK_T_NewsReadDto getNewReadTime(int memId) {
        return newsReadDao.selectNewsReadTime(memId);
    }

    /**
     * お知らせの既読状態を取得
     */
    public boolean getRedStatus(Date readTime) {
        Date currentTime = new Date();

        // 既読時間が現時刻より前か判定
        return readTime.before(currentTime);
    }

    /**
     * お知らせの既読状態を取得
     * @param memId
     * @return
     */
    @Transactional
    public void updateReadTimeNews(int memId) {
        newsReadDao.updateNewsReadDateByMemId(memId);
    }

    /**
     * 新規提供本有無を確認
     * @param readTime
     * @return
     */
    @Transactional
    public List<V_TopAndDetailDto> getOfferBookNewsList(Date readTime) {
        return bookDao.selectOfferBookNewsData(readTime);
    }

    /**
     * おすすめされた本を確認
     * @param memId,readTime
     * @return
     */
    @Transactional
    public List<BK_T_RequestDto> getRequestBookNewsList(int memId, Date readTime) {
        return requestDao.selectRequestBookNewsData(memId, readTime);
    }

    /**
     * おすすめされた本を確認
     * @param memId,readTime
     * @return
     */
    @Transactional
    public List<V_RecomToMeBookDto> getRecomeBookNewsList(int memId, Date readTime) {
        return bookDao.selectRecomeBookNewsData(memId, readTime);
    }

}
