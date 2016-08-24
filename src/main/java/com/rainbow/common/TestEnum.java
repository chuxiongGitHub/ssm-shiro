package com.rainbow.common;

/**
 * Created by rainbow on 2016/8/23.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public enum TestEnum {
    YES(1, "是"),
    No(-1, "否");
    private int status;
    private String statusInfo;

    TestEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }


    public static TestEnum statusOf(int index) {
        for (TestEnum status : values()) {
            if (status.getStatus() == index) {
                return status;
            }
        }
        return null;
    }
}
