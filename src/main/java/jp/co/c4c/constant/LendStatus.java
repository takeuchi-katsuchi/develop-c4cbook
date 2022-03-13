package jp.co.c4c.constant;

public enum LendStatus {

    RESERVED(10),
    LENDING(11),
    RETURNED(19);

    private int lendStatus;

    LendStatus(int lendStatus) {
        this.lendStatus = lendStatus;
    }

    public int getLendStatus() {
        return lendStatus;
    }

}
