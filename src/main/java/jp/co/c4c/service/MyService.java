package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.BK_M_BookDao;
import jp.co.c4c.db.dao.BK_T_LendDao;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;

@Component
public class MyService {

    @Autowired
    BK_T_LendDao lendDao;
    @Autowired
    BK_M_BookDao bookDao;

    /**
     * マイページに表示させる予約・貸出履歴のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyLendHistoryDto> getBooksByMemId(int memId) {
        return lendDao.selectBooksByMemId(memId);
    }

    /**
     * マイページに表示させるおすすめされている本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_RecomToMeBookDto> getRecommendedBooksByMemId(int memId) {
        return bookDao.selectRecommendedBooksByMemId(memId);
    }

    /**
     * マイページに表示させるお気に入り本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyFavoriteBookDto> getMyFavoriteBooksByMemId(int memId) {
        return bookDao.selectFavoriteBooksByMemId(memId);
    }

}
