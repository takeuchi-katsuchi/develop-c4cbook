package jp.co.c4c.constant;

public enum SortCondition {

    LATEST("1"),
    KANA("2"),
    FAVORITE("3"),
    LEND("4");

    private String sortCond;

    SortCondition(String sortCond) {
        this.sortCond = sortCond;
    }

    public String getSortCond() {
        return sortCond;
    }
}
