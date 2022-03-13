package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_T_LendDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 貸出・予約手続き データ登録
     * @param bk_T_LendDto
     */
    public void insertLendBook(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_insertLendBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("bookId", bk_T_LendDto.getBookId());
        param.put("memId", bk_T_LendDto.getMemId());
        param.put("lendStatus", bk_T_LendDto.getLendStatus());
        param.put("fromDate", bk_T_LendDto.getFromDate());
        param.put("toDate", bk_T_LendDto.getToDate());
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 貸出・予約ステータス更新
     * @param bk_T_LendDto
     */
    public void updateLendBookByLendId(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_updateLendBookByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("lendId", bk_T_LendDto.getLendId());
        param.put("lendStatus", bk_T_LendDto.getLendStatus());
        param.put("fromDate", bk_T_LendDto.getFromDate());
        param.put("toDate", bk_T_LendDto.getToDate());
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 貸出履歴にレビューを登録
     * @param bk_T_LendDto
     */
    public void updateLendBookforReview(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_updateLendBookforReview.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("lendId", bk_T_LendDto.getLendId());
        param.put("review", bk_T_LendDto.getReview());
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 詳細ページに表示させる貸出履歴のデータを取得
     * @param bookId
     * @return
     */
    public List<V_LendHistoryDto> selectLendHistorysById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_selectLendHistorysById.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        return sqlManager.getResultList(V_LendHistoryDto.class, sqlSrc, param);
    }

    /**
     * マイページに表示させる予約・貸出履歴のリストを取得
     * @param memId
     * @return
     */
    public List<V_MyLendHistoryDto> selectBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_selectBooksByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_MyLendHistoryDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させる貸出期限が近い本の件数を取得
     * @param memId
     * @return
     */
    public List<BK_T_LendDto> selectLendPiriodByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_selectLendPiriodByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        return sqlManager.getResultList(BK_T_LendDto.class, sqlSrc, param);
    }

    /**
     * 予約取り消し
     * @param lendId
     */
    public void deleteLendBookByLendId(int lendId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_deleteLendBookByLendId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("lendId", lendId);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
