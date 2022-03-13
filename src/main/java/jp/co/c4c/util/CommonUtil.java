package jp.co.c4c.util;

import jp.co.c4c.constant.TagCondition;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class CommonUtil {

    /**
     * 数値チェック
     * @param num
     * @return　数値：true、数値以外:false
     */
    public boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
            } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * byte[]の画像データをStringに変換
     * @param data
     * @return img
     */
    public String convByteToString(byte[] data) {
        if (data == null) { return null; }

        // 画像ファイルをBase64 String に変換する
        String dataString = Base64.getEncoder().encodeToString(data);
        return dataString;
    }
    /**
     * tagIdを文字列に変換するメソッド（作成中）
     * @param strings
     * @return
     */
    public static String[] convertTag(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "1":
                    strings[i] = TagCondition.SHIKAKU.getTagName(); // 定数に入れ替える
                    break;
                case "2":
                    strings[i] = TagCondition.NYUMONSYO.getTagName();
                    break;
                case "3":
                    strings[i] = TagCondition.WEBKAIHATSU.getTagName();
                    break;
                case "4":
                    strings[i] = TagCondition.JIKOKEIHATSU.getTagName();
                    break;
                case "5":
                    strings[i] = TagCondition.GORAKU.getTagName();
                    break;
                default:
                    break;
            }
        }
        return strings;
    }

}
