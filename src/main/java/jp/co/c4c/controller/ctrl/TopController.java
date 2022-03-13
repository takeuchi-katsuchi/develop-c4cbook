package jp.co.c4c.controller.ctrl;

import jp.co.c4c.constant.LendStatus;
import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dto.*;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.MyService;
import jp.co.c4c.service.TopService;
import jp.co.c4c.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = { "/", "/top" })
@SessionAttributes("webSessionDto")
public class TopController {

    @Autowired
    TopService topService;
    @Autowired
    CommonService commonService;
    @Autowired
    MyService myService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, TopForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined)
            return "redirect:login";

        // 全ての本のリストをfromにセット
        List<V_TopAndDetailDto> v_topAndDetailDtoList = topService.getAllBooks();
        CommonUtil commonUtil = new CommonUtil();
        for (V_TopAndDetailDto v_topAndDetailDto : v_topAndDetailDtoList) {
            // 画像のバイナリデータを文字列に変換
            String dataString = commonUtil.convByteToString(v_topAndDetailDto.getBookImg());
            v_topAndDetailDto.setEncodedBookImg(dataString);
        }
        form.setTopAndDetailDtoList(v_topAndDetailDtoList);

        int memId = webSessionDto.getMemId();

        // ログインユーザーがお気に入りしている本のリストformにセット
        List<V_MyFavoriteBookDto> bk_T_FavoriteDtoList = topService.getFavoriteBooks(memId);
        List<Integer> myFavoriteBookIdList = bk_T_FavoriteDtoList.stream()
                .map(V_MyFavoriteBookDto::getBookId)
                .collect(Collectors.toList());
        form.setMyFavoriteBookIdList(myFavoriteBookIdList);

        // ログインユーザーが読書済みの本のリストを取得
        List<V_LendHistoryDto> bk_T_LendDtoList = topService.getlendedBooks(memId);
        List<Integer> myLendedBookIdList = bk_T_LendDtoList.stream()
                .map(V_LendHistoryDto::getBookId)
                .collect(Collectors.toList());
        form.setMyLendedBookIdList(myLendedBookIdList);

        // ログインユーザーの貸出・予約履歴全件取得
        List<V_MyLendHistoryDto> myPageDtoList = myService.getBooksByMemId(memId);

        List<V_MyLendHistoryDto> myLendingBookList = myPageDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.LENDING.getLendStatus())
                .collect(Collectors.toList());
        form.setMyLendingBookList(myLendingBookList);

        /* tagIdを文字列に変換 */
        for (int i = 0; i < form.getTopAndDetailDtoList().size(); i++) {
            String[] tagIds = form.getTopAndDetailDtoList().get(i).getTagIds().split(",");
            CommonUtil.convertTag(tagIds);
            form.getTopAndDetailDtoList().get(i).setTagIds(String.join(",", tagIds));
        }

        // お知らせメッセージ_貸出期限通知用の情報を取得
        List<BK_T_LendDto> lendNewsList = topService.getLendNewsByMemId(memId);
        form.setLendNewsList(lendNewsList);

        int LendingCnt = form.getCountMyLendingBookList();
        model.addAttribute("LendingCnt", LendingCnt);

        // お知らせ既読時間を取得
        try {
            BK_T_NewsReadDto newsReadAt = topService.getNewReadTime(memId);
            form.setReadTimeNews(newsReadAt.getReadAt());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // お知らせ既読ステータスを取得
            Date readTime = form.getReadTimeNews();
            boolean readStatus = topService.getRedStatus(readTime);
            model.addAttribute("readStatus", readStatus);

            // お知らせメッセージ_本入荷通知の情報を取得
            List<V_TopAndDetailDto> offerBookNewsList = topService.getOfferBookNewsList(readTime);
            form.setOfferBookNewsList(offerBookNewsList);

            // 入荷された本の数を確認
            int newBooksCnt = offerBookNewsList.size();
            model.addAttribute("newBooksCnt", newBooksCnt);

            // お知らせメッセージ_要望した本の承認通知の情報を取得
            List<BK_T_RequestDto> requestBookNewsList = topService.getRequestBookNewsList(memId, readTime);
            form.setRequestBookNewsList(requestBookNewsList);

            // 承認された本の数を確認
            int newApprovalCnt = requestBookNewsList.size();
            model.addAttribute("newApprovalCnt", newApprovalCnt);

            // お知らせメッセージ_おすすめされた本通知の情報を取得
            List<V_RecomToMeBookDto> recomeBookNewsList = topService.getRecomeBookNewsList(memId, readTime);
            form.setRecomeBookNewsList(recomeBookNewsList);

            // おすすめされた本の数を確認
            int recomeBooksCnt = recomeBookNewsList.size();
            model.addAttribute("recomeBooksCnt", recomeBooksCnt);

            // お知らせ既読状態更新
            topService.updateReadTimeNews(memId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "top";
    }
}