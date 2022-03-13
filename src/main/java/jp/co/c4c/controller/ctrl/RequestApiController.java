package jp.co.c4c.controller.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_T_RequestCheerDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.service.RequestService;

/**
 * @author kobarigenki
 *
 */
@RestController
public class RequestApiController {

    @Autowired
    RequestService requestService;

    /**
     * 新しい本の要望登録処理
     * @param bK_T_RequestDto
     * @param request
     * @return ResponseEntity<Object>
     */
    @RequestMapping(value = "/api/requestBook", method = RequestMethod.POST)
    public ResponseEntity<Object> requestBook(@RequestBody BK_T_RequestDto bK_T_RequestDto, HttpServletRequest request) {

        ApiResponse<BK_T_RequestDto> apiResponse = new ApiResponse<BK_T_RequestDto>();

        // CSRF対策トークンチェック処理
        // リクエストから画面にセットされたトークンを取得
        String csrf_token = request.getHeader("csrf-token");
        // セッションを取得
        HttpSession session = request.getSession(true);
        // セッションのトークンを取得
        String token = (String) session.getAttribute("token");
        // トークンチェック
        if (token == null || !(token.equals(csrf_token))) {
            // トークンがないor画面とサーバのトークンが違う場合はエラーを返す
            return new ResponseEntity<Object>(apiResponse, HttpStatus.NOT_FOUND);
        }

        apiResponse = new ApiResponse<>("sucess", bK_T_RequestDto);

        // 入力された本を登録
        requestService.saveRequestBook(bK_T_RequestDto);

        // 成功を返す
        return new ResponseEntity<Object>(apiResponse, HttpStatus.OK);
    }

    /**
     * 本の応援を登録
     * @param bk_T_LendDto
     * @return ResponseEntity<Object>
     */
    @RequestMapping(value = "/api/cheerBook", method = RequestMethod.POST)
    public ResponseEntity<Object> cheerBook(@RequestBody BK_T_RequestCheerDto bK_T_RequestCheerDto) {

        ApiResponse<BK_T_RequestCheerDto> response = new ApiResponse<>("sucess", bK_T_RequestCheerDto);

        // 本に対する応援を登録
        requestService.saveCheerCount(bK_T_RequestCheerDto);

        // 成功を返す
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}