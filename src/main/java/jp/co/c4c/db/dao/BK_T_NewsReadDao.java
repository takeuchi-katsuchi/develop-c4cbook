package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_NewsReadDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_T_NewsReadDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * お知らせの未読情報を取得
     * @param memId
     * @return
     */
    public BK_T_NewsReadDto selectNewsReadTime(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_NewsReadDao_selectNewsReadTime.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        // sql実行のため力技でパラメータを設定
        String sqlPramOrg = param.toString();
        char sqlPram = sqlPramOrg.charAt(7);

        // TODO: 後ほど修正
        return sqlManager.getSingleResultBySql(BK_T_NewsReadDto.class,
                "select READ_AT from book_db.BK_T_NEWS_READ where book_db.BK_T_NEWS_READ.MEM_ID = " + sqlPram);
        //           return sqlManager.getSingleResult(BK_T_NewsReadDto.class,sqlSrc,param);
    }

    /**
     * 既読日時更新
     * @param memId
     */
    public void updateNewsReadDateByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_NewsReadDao_updateNewsReadDateByMemId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);

        sqlManager.executeUpdate(sqlSrc, param);
    }
}
