package jp.co.c4c.controller.form;

import java.util.List;

import jp.co.c4c.db.dto.BK_M_MemBasicDto;

public class LoginForm {

    private List<BK_M_MemBasicDto> bk_M_MemBasicDtoList;

    public List<BK_M_MemBasicDto> getBk_M_MemBasicDtoList() {
        return bk_M_MemBasicDtoList;
    }

    public void setBk_M_MemBasicDtoList(List<BK_M_MemBasicDto> bk_M_MemBasicDtoList) {
        this.bk_M_MemBasicDtoList = bk_M_MemBasicDtoList;
    }

}
