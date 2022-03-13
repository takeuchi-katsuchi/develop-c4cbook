package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.BK_M_BookDao;
import jp.co.c4c.db.dao.BK_T_RequestCheerDao;
import jp.co.c4c.db.dao.BK_T_RequestDao;
import jp.co.c4c.db.dto.BK_T_RequestCheerDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.db.dto.V_MyCheerBookDto;
import jp.co.c4c.db.dto.V_RequestDto;

@Component
public class RequestService {

    @Autowired
    private BK_M_BookDao bookDao;
    @Autowired
    private BK_T_RequestCheerDao requestCheerDao;
    @Autowired
    private BK_T_RequestDao requestDao;

    /**
     * 要望ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_RequestDto> getRequestList() {
        return requestDao.selectRequestList();
    }

    /**
     * 本の要望を登録
     * @param BK_T_RequestDto
     */
    @Transactional
    public void saveRequestBook(BK_T_RequestDto bK_T_RequestDto) {
        requestDao.insertRequestBook(bK_T_RequestDto);
    }

    /**
     * 本の応援数を登録
     * @param BK_T_RequestDto
     */
    @Transactional
    public void saveCheerCount(BK_T_RequestCheerDto bK_T_RequestCheerDto) {
        requestCheerDao.insertCheerBook(bK_T_RequestCheerDto);
    }

    /**
     * ログインユーザーが応援済みの本のリストを取得
     * @param memId
     * @return
     */
    @Transactional
    public List<V_MyCheerBookDto> getCheerBooks(int memId) {
        return bookDao.selectCheerBooksByMemId(memId);
    }
}
