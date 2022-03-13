package jp.co.c4c.controller.ctrl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.constant.LendStatus;
import jp.co.c4c.controller.form.MyForm;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_RecomToMeBookDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.MyService;
import jp.co.c4c.util.CommonUtil;

@Controller
@RequestMapping("/mypage")
@SessionAttributes("webSessionDto")
public class MyController {

    @Autowired
    MyService myService;
    @Autowired
    CommonService commonService;

    // セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, MyForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        int memId = webSessionDto.getMemId();

        //////////////////////////////////////////////
        // ログインユーザーの予約・貸出履歴
        //////////////////////////////////////////////
        // ログインユーザーの貸出・予約履歴全件取得
        List<V_MyLendHistoryDto> myLendHistoryDtoList = myService.getBooksByMemId(memId);

        // 画像のバイナリデータを文字列に変換
        CommonUtil commonUtil = new CommonUtil();
        for (V_MyLendHistoryDto v_myLendHistoryDto : myLendHistoryDtoList) {
            String dataString = commonUtil.convByteToString(v_myLendHistoryDto.getBookImg());
            v_myLendHistoryDto.setEncodedBookImg(dataString);
        }

        // ログインユーザーが予約中の本で絞り込み
        List<V_MyLendHistoryDto> myResevedBookList = myLendHistoryDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.RESERVED.getLendStatus())
                .collect(Collectors.toList());

        // ログインユーザーが借りている本で絞り込み
        List<V_MyLendHistoryDto> myLendingBookList = myLendHistoryDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.LENDING.getLendStatus())
                .collect(Collectors.toList());

        // ログインユーザーが返却済み（読書済み）の本で絞り込み
        List<V_MyLendHistoryDto> myAllReturnedBookList = myLendHistoryDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.RETURNED.getLendStatus())
                .collect(Collectors.toList());

        // 画面に表示させる返却済み（読書済み）の本
        List<V_MyLendHistoryDto> editedMyReturnedBookList = new ArrayList<>();

        // BookIdのリストを取得
        List<Integer> bookIdList = myAllReturnedBookList.stream()
                .map(V_MyLendHistoryDto::getBookId)
                .collect(Collectors.toList());

        // 重複しているBookIdを削除
        List<Integer> trimedBookIdList = new ArrayList<>(new LinkedHashSet<>(bookIdList));
        for (int i = 0; i < trimedBookIdList.size(); i++) {
            int index = i;
            // BookIdに該当する先頭のObjをeditedMyReturnedBookListに追加
            Optional<V_MyLendHistoryDto> optional = myAllReturnedBookList.stream()
                    .filter(obj -> obj.getBookId() == trimedBookIdList.get(index))
                    .findFirst();

            optional.ifPresent(obj -> editedMyReturnedBookList.add(obj));
        }

        // ログインユーザーが読書済みの本の数
        String readBookCount = String.valueOf(trimedBookIdList.size());

        //////////////////////////////////////////////
        // ログインユーザーにおすすめされている本
        //////////////////////////////////////////////
        List<V_RecomToMeBookDto> recomToMeBookDtoList = myService.getRecommendedBooksByMemId(memId);
        // 画像のバイナリデータを文字列に変換
        for (V_RecomToMeBookDto v_recomToMeBookDto : recomToMeBookDtoList) {
            String dataString = commonUtil.convByteToString(v_recomToMeBookDto.getBookImg());
            v_recomToMeBookDto.setEncodedBookImg(dataString);
        }

        List<Integer> bookIdList2 = recomToMeBookDtoList.stream()
                .map(V_RecomToMeBookDto::getBookId)
                .collect(Collectors.toList());
        List<Integer> trimedBookIdList2 = new ArrayList<>(new LinkedHashSet<>(bookIdList2));

        // 画面に表示させるおすすめされている本
        List<V_RecomToMeBookDto> editedrecomToMeBookDtoList = new ArrayList<>();
        for (int i = 0; i < trimedBookIdList2.size(); i++) {
            int index = i;
            int objCount = (int) recomToMeBookDtoList.stream()
                    .filter(obj -> obj.getBookId() == trimedBookIdList2.get(index))
                    .count();

            // BookIdに該当する先頭のObjをmyRecommendedBookDtoListに追加
            Optional<V_RecomToMeBookDto> optional = recomToMeBookDtoList.stream()
                    .filter(obj -> obj.getBookId() == trimedBookIdList2.get(index))
                    .findFirst();
            optional.ifPresent(obj -> editedrecomToMeBookDtoList.add(obj));

            // おすすめ者が複数人の場合、おすすめ者全員の名前を取得、連結してmemNameにセット
            if (1 < objCount) {
                String memNames = recomToMeBookDtoList.stream()
                        .filter(obj -> obj.getBookId() == trimedBookIdList2.get(index))
                        .map(V_RecomToMeBookDto::getMemName)
                        .collect(Collectors.joining(","));
                editedrecomToMeBookDtoList.get(i).setMemName(memNames);
            }
        }

        //////////////////////////////////////////////
        // ログインユーザーがお気に入りの本
        //////////////////////////////////////////////
        List<V_MyFavoriteBookDto> myFavoriteBookDtoList = myService.getMyFavoriteBooksByMemId(memId);
        // 画像のバイナリデータを文字列に変換
        for (V_MyFavoriteBookDto v_myFavoriteBookDto : myFavoriteBookDtoList) {
            String dataString = commonUtil.convByteToString(v_myFavoriteBookDto.getBookImg());
            v_myFavoriteBookDto.setEncodedBookImg(dataString);
        }

        // ログインユーザーが読書済みの本の数をformにセット
        form.setCount(readBookCount);
        // ログインユーザーが予約中の本のリストをformにセット
        form.setMyResevedBookList(myResevedBookList);
        // ログインユーザーに貸出中の本のリストをformにセット
        form.setMyLendingBookList(myLendingBookList);
        // ログインユーザーがこれまでに読んだ本のリストをformにセット
        form.setMyReturnedBookList(editedMyReturnedBookList);
        // ログインユーザーにおすすめされている本のリストをformにセット
        form.setRecomToMeBookList(editedrecomToMeBookDtoList);
        // ログインユーザーがお気に入りの本のリストをformにセット
        form.setMyFavoriteBookList(myFavoriteBookDtoList);

        return "mypage";
    }
}
