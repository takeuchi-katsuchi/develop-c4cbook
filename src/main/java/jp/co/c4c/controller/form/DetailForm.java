package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_RecomMemDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * 詳細画面 Formクラス
 */
public class DetailForm {

    /** 本詳細 */
    V_TopAndDetailDto v_TopAndDetailDto;
    /** 貸出履歴 ByBookId */
    List<V_LendHistoryDto> v_LendHistoryDtoList;
    /** お気に入りした人 */
    List<V_FavoriteMemberDto> v_FavoriteMemberDtoList;
    /** おすすめしてる人 */
    List<V_RecomMemDto> v_RecomMemDtoList;
    /** 貸出履歴 ByLendId */
    BK_T_LendDto bk_T_LendDto;
    /** メンバー全員 ByLendId */
    List<BK_M_MemBasicDto> bk_M_MemBasicDtoList;

    List<Integer> favoriteMemIdList;

    List<Integer> lendedMemIdList;

    public V_TopAndDetailDto getV_TopAndDetailDto() {
        return v_TopAndDetailDto;
    }

    public void setV_TopAndDetailDto(V_TopAndDetailDto v_TopAndDetailDto) {
        this.v_TopAndDetailDto = v_TopAndDetailDto;
    }

    public List<V_LendHistoryDto> getV_LendHistoryDtoList() {
        return v_LendHistoryDtoList;
    }

    public void setV_LendHistoryDtoList(List<V_LendHistoryDto> v_LendHistoryDtoList) {
        this.v_LendHistoryDtoList = v_LendHistoryDtoList;
    }

    public List<V_FavoriteMemberDto> getV_FavoriteMemberDtoList() {
        return v_FavoriteMemberDtoList;
    }

    public void setV_FavoriteMemberDtoList(List<V_FavoriteMemberDto> v_FavoriteMemberDtoList) {
        this.v_FavoriteMemberDtoList = v_FavoriteMemberDtoList;
    }

    public BK_T_LendDto getBk_T_LendDto() {
        return bk_T_LendDto;
    }

    public void setBk_T_LendDto(BK_T_LendDto bk_T_LendDto) {
        this.bk_T_LendDto = bk_T_LendDto;
    }

    public List<BK_M_MemBasicDto> getBk_M_MemBasicDtoList() {
        return bk_M_MemBasicDtoList;
    }

    public void setBk_M_MemBasicDtoList(List<BK_M_MemBasicDto> bk_M_MemBasicDtoList) {
        this.bk_M_MemBasicDtoList = bk_M_MemBasicDtoList;
    }

    public List<V_RecomMemDto> getV_RecomMemDtoList() {
        return v_RecomMemDtoList;
    }

    public void setV_RecomMemDtoList(List<V_RecomMemDto> v_RecomMemDtoList) {
        this.v_RecomMemDtoList = v_RecomMemDtoList;
    }

    public List<Integer> getFavoriteMemIdList() {
        return favoriteMemIdList;
    }

    public void setFavoriteMemIdList(List<Integer> favoriteMemIdList) {
        this.favoriteMemIdList = favoriteMemIdList;
    }

    public List<Integer> getLendedMemIdList() {
        return lendedMemIdList;
    }

    public void setLendedMemIdList(List<Integer> lendedMemIdList) {
        this.lendedMemIdList = lendedMemIdList;
    }
}
