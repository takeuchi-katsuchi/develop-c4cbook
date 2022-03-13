package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.db.dto.V_RequestDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_T_RequestDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 要望 データ登録
     * @param BK_T_RequestDto
     */
    public void insertRequestBook(BK_T_RequestDto bK_T_RequestDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestDao_insertRequestBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("title", bK_T_RequestDto.getTitle());
        param.put("titleKana", bK_T_RequestDto.getTitleKana());
        param.put("author", bK_T_RequestDto.getAuthor());
        param.put("authorKana", bK_T_RequestDto.getAuthorKana());
        param.put("memId", bK_T_RequestDto.getMemId());
        param.put("comment", bK_T_RequestDto.getComment());
        param.put("requestStatus", 0);
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

    /**
     * 要望ページに表示させるデータを取得
     * @return List<V_RequestDto>
     */
    public List<V_RequestDto> selectRequestList() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestDao_selectRequestList.sql");
        Map<String, Object> param = new HashMap<>();
        return sqlManager.getResultList(V_RequestDto.class, sqlSrc, param);
    }

    /**
     * お知らせに表示させる承認された本のデータを取得
     * @param memId,readTime
     * @return
     */
    public List<BK_T_RequestDto> selectRequestBookNewsData(int memId,Date readTime) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestDao_selectRequestBookNewsData.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        param.put("readTime", readTime);
        return sqlManager.getResultList(BK_T_RequestDto.class, sqlSrc, param);
    }

}
