package jp.co.c4c.constant;

public enum TagCondition {

    SHIKAKU("1", "資格"),
    NYUMONSYO("2", "入門書"),
    WEBKAIHATSU("3", "WEB開発"),
    JIKOKEIHATSU("4", "実用書"),
    GORAKU("5", "娯楽");

    private final String tagCond;
    private final String tagName;

     TagCondition(String tagCond, String tagName) {
        this.tagCond = tagCond;
        this.tagName = tagName;
    }

    public String getTagCond() {
        return tagCond;
    }

    public String getTagName() {
        return tagName;
    }
}
