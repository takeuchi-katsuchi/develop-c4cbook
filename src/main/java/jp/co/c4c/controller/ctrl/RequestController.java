package jp.co.c4c.controller.ctrl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.RequestForm;
import jp.co.c4c.db.dto.V_MyCheerBookDto;
import jp.co.c4c.db.dto.V_RequestDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.RequestService;
import jp.co.c4c.util.CommonUtil;

@Controller
@RequestMapping("/request")
@SessionAttributes("webSessionDto")
public class RequestController {

    @Autowired
    RequestService requestService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    /**
     * 要望画面初期表示処理
     * @param webSessionDto
     * @param model
     * @param form
     * @param request
     * @return String
     */
    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, RequestForm form, HttpServletRequest request) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        // 未ログインの場合はログイン画面を返す
        if (!isLogined) return "redirect:login";

        // トークンチェック用トークン生成＆保存
        // セッションを取得
        HttpSession session = request.getSession(true);
        // トークンをセッションに保存
        session.setAttribute("token", getCsrfToken());

        int memId = webSessionDto.getMemId();

        // ログインユーザーが応援している本のリストformにセット
        List<V_MyCheerBookDto> bk_T_CheerDtoList = requestService.getCheerBooks(memId);
        // 応援している本のリストから要望Idのリストを作成
        List<Integer> myCheerBookIdList = bk_T_CheerDtoList.stream()
                .map(V_MyCheerBookDto::getRequestId)
                .collect(Collectors.toList());
        // 要望Idのリストをformにセット
        form.setMyCheerBookIdList(myCheerBookIdList);
        // 要望されている本の一覧を取得
        List<V_RequestDto> requestDtoList = requestService.getRequestList();

        CommonUtil commonUtil = new CommonUtil();
        for(V_RequestDto dto : requestDtoList) {
            String dataString = commonUtil.convByteToString(dto.getBookImg());
            dto.setEncodedBookImg(dataString);
        }

        form.setReqInfoList(requestDtoList);

        return "request";
    }

    /**
     * CSRF用16byteのトークン文字列を生成
     * @return String
     */
    public static String getCsrfToken() {
        byte token[] = new byte[16];
        StringBuffer buf = new StringBuffer();
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            random.nextBytes(token);
            for (int i = 0; i < token.length; i++) {
                buf.append(String.format("%02x", token[i]));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

}
