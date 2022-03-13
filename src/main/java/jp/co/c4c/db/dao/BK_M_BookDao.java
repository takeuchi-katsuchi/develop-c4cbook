package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyCheerBookDto;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_M_BookDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させる本のデータを取得
     * @param bookId
     * @return
     */
    public V_TopAndDetailDto selectBookByBookId(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectBookByBookId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        return sqlManager.getSingleResult(V_TopAndDetailDto.class, sqlSrc, param);
    }

    /**
     * トップページに表示させる本リストのデータを取得
     * @return
     */
    public List<V_TopAndDetailDto> selectAllBooks() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectAllBooks.sql");
        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc);
    }

    /**
     * マイページに表示させるおすすめされている本のリストを取得
     * @param memId
     * @return
     */
    public List<V_RecomToMeBookDto> selectRecommendedBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectRecommendedBooksByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_RecomToMeBookDto.class, sqlSrc, param);
    }

    /**
     * ログインユーザーがお気に入り済みの本のリストを取得
     * @param memId
     * @return
     */
    public List<V_MyFavoriteBookDto> selectFavoriteBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectFavoriteBooksByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_MyFavoriteBookDto.class, sqlSrc, param);
    }

    /**
     * ログインユーザーが応援済みの本のリストを取得
     * @param memId
     * @return List<V_MyCheerBookDto>
     */
    public List<V_MyCheerBookDto> selectCheerBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectCheerBooksByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_MyCheerBookDto.class, sqlSrc, param);
    }

    /**
     * ログインユーザーが読書済みのリストを取得
     * @param memId
     * @return
     */
    public List<V_LendHistoryDto> selectLendHistorysByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectLendHistorysByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_LendHistoryDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させる新規入荷本のデータを取得
     * @param readTime
     * @return
     */
    public List<V_TopAndDetailDto> selectOfferBookNewsData(Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectOfferBookNewsData.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("readTime", readTime);
        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させるおすすめされた本のデータを取得
     * @param memId,readTime
     * @return
     */
    public List<V_RecomToMeBookDto> selectRecomeBookNewsData(int memId,Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDao_selectRecomeBookNewsData.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        param.put("readTime", readTime);
        return sqlManager.getResultList(V_RecomToMeBookDto.class, sqlSrc, param);
    }
}
