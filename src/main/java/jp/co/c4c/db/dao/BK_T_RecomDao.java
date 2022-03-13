package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class BK_T_RecomDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * おすすめを登録
     * @param bk_T_RecomDto
     */
    public void insertRecom(BK_T_RecomDto bk_T_RecomDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_RecomDao_insertRecom.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("bookId", bk_T_RecomDto.getBookId());
        param.put("fromMemId", bk_T_RecomDto.getFromMemId());
        param.put("toMemId", bk_T_RecomDto.getToMemId());
        param.put("recomDate", date);
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
