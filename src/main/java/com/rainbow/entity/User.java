package com.rainbow.entity;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class User {
    private long userId;
    private String username;
    private String password;
    private String remark;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


}
