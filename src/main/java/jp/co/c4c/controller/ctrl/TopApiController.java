package jp.co.c4c.controller.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.c4c.db.dto.ApiResponse;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.co.c4c.service.TopService;
import jp.co.c4c.util.CommonUtil;

/**
 * @author takayukiyamaoka
 *
 */
@RestController
public class TopApiController {

    @Autowired
    TopService topService;

    /**
     * お気に入り登録
     * @param bk_T_FavoriteDto
     * @return
     */
    @RequestMapping(value = "/api/favorite", method = RequestMethod.POST)
    public ResponseEntity<Object> saveMyFavoriteBook(@RequestBody BK_T_FavoriteDto bk_T_FavoriteDto) {
        ApiResponse<BK_T_FavoriteDto> response = new ApiResponse<>();

        topService.saveMyFavoriteBook(bk_T_FavoriteDto);

        response.setStatus("お気に入り登録しました。");
        response.setData(bk_T_FavoriteDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/favorite-delete", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteMyFavoriteBook(@RequestBody BK_T_FavoriteDto bk_T_FavoriteDto) {
        ApiResponse<BK_T_FavoriteDto> response = new ApiResponse<>();

        topService.deleteMyFavoriteBook(bk_T_FavoriteDto);

        response.setStatus("お気に入りを削除しました。");
        response.setData(bk_T_FavoriteDto);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // 並び替え、タグ絞り込みように本のリストを取得
    @RequestMapping(value = "/api/getBookList", method = RequestMethod.GET)
    public ResponseEntity<Object> showBookList(@RequestParam(name = "memId") int memId) {
        ApiResponse<V_TopAndDetailDto> response = new ApiResponse<>();

        List<V_TopAndDetailDto> v_topAndDetailDtoList = topService.getAllBooks();
        CommonUtil commonUtil = new CommonUtil();
        for (V_TopAndDetailDto v_topAndDetailDto : v_topAndDetailDtoList) {
            // 画像のバイナリデータを文字列に変換
            String dataString = commonUtil.convByteToString(v_topAndDetailDto.getBookImg());
            v_topAndDetailDto.setEncodedBookImg(dataString);
        }

        /* tagIdを文字列に変換 */
        for (int i = 0; i < v_topAndDetailDtoList.size(); i++) {
            String[] tagIds = v_topAndDetailDtoList.get(i).getTagIds().split(",");
            CommonUtil.convertTag(tagIds);
            v_topAndDetailDtoList.get(i).setTagIds(String.join(",", tagIds));
        }

        // ログインユーザーがお気に入りしている本のリストを取得
        List<V_MyFavoriteBookDto> bk_T_FavoriteDtoList = topService.getFavoriteBooks(memId);
        List<Integer> myFavoriteBookIdList = bk_T_FavoriteDtoList.stream()
                .map(V_MyFavoriteBookDto::getBookId)
                .collect(Collectors.toList());

        // ログインユーザーが読書済みの本のリストを取得を取得
        List<V_LendHistoryDto> bk_T_LendDtoList = topService.getlendedBooks(memId);
        List<Integer> myLendedBookIdList = bk_T_LendDtoList.stream()
                .map(V_LendHistoryDto::getBookId)
                .collect(Collectors.toList());

        response.setStatus("Success");
        response.setDataList(v_topAndDetailDtoList);
        response.setMyFavoriteBookIdList(myFavoriteBookIdList);
        response.setMyLendedBookIdList(myLendedBookIdList);

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
