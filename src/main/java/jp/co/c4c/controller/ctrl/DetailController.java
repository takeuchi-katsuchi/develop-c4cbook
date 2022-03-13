package jp.co.c4c.controller.ctrl;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.db.dto.BK_M_MemBasicDto;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.DetailService;
import jp.co.c4c.util.CommonUtil;

@Controller
@RequestMapping("/detail")
@SessionAttributes("webSessionDto")
public class DetailController {

    @Autowired
    DetailService detailService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, @RequestParam("bookId") int bookId, Model model, DetailForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        // 全メンバー取得してログインユーザー自身を除外してformにセット（おすすめする人の選択肢表示用）
        int memId = webSessionDto.getMemId();
        List<BK_M_MemBasicDto> bk_m_memBasicDtoList = detailService.getAllMembers().stream()
                .filter(obj -> obj.getMemId() != memId)
                .collect(Collectors.toList());
        form.setBk_M_MemBasicDtoList(bk_m_memBasicDtoList);

        // 対象の本
        V_TopAndDetailDto v_topAndDetailDto = detailService.getBookById(bookId);
        // 画像のバイナリデータを文字列に変換
        CommonUtil commonUtil = new CommonUtil();
        String dataString = commonUtil.convByteToString(v_topAndDetailDto.getBookImg());
        v_topAndDetailDto.setEncodedBookImg(dataString);

        /* tagIdを文字列に変換 */
        String[] tagIds = v_topAndDetailDto.getTagIds().split(",");
        CommonUtil.convertTag(tagIds);
        v_topAndDetailDto.setTagIds(String.join(",", tagIds));
        form.setV_TopAndDetailDto(v_topAndDetailDto);

        // 貸出履歴　返却ステータス以外を除外してformにセット
        List<V_LendHistoryDto> lendHistoryDtoList = detailService.getLendHistorysByBookId(bookId);
        Iterator<V_LendHistoryDto> iterator = lendHistoryDtoList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLendStatus() != 19) {
                iterator.remove();
            }
        }
        form.setV_LendHistoryDtoList(lendHistoryDtoList);
        // 対象の本を読書済みのmemIdリストを取得
        List<Integer> lendedMemIdList = lendHistoryDtoList.stream()
                .map(V_LendHistoryDto::getMemId)
                .collect(Collectors.toList());
        form.setLendedMemIdList(lendedMemIdList);

        // お気に入りしてる人
        List<V_FavoriteMemberDto> v_favoriteMemberDtoList = detailService.getFavoriteMembersById(bookId);
        form.setV_FavoriteMemberDtoList(v_favoriteMemberDtoList);
        // 対象の本をお気に入りしているmemIdリストformにセット
        List<Integer> favoriteMemIdList = v_favoriteMemberDtoList.stream()
                .map(V_FavoriteMemberDto::getMemId)
                .collect(Collectors.toList());
        form.setFavoriteMemIdList(favoriteMemIdList);

        // おすすめしてる人
        form.setV_RecomMemDtoList(detailService.getRecomMembersById(bookId));
        return "detail";
    }

}
