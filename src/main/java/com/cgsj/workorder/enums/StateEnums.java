package com.cgsj.workorder.enums;

public enum StateEnums {
    WAIT_RECEIVE("待接收"),
    RECEIVED("已接收");

    private final String chName;

    StateEnums(String chName) {
        this.chName = chName;
    }

    public String getChName() {
        return chName;
    }
}
