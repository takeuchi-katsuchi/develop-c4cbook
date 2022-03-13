package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_RequestCheerDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_T_RequestCheerDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 応援 データ登録
     * @param BK_T_RequestDto
     */
    public void insertCheerBook(BK_T_RequestCheerDto bK_T_RequestCheerDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RequestCheerDao_insertCheerBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("requestId", bK_T_RequestCheerDto.getRequestId());
        param.put("memId", bK_T_RequestCheerDto.getMemId());
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
