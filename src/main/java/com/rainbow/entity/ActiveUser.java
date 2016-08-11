package com.rainbow.entity;

import java.io.Serializable;

/**
 * Created by rainbow on 2016/8/11.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//用户身份信息存储
public class ActiveUser implements Serializable {
    private String userId;//用户id
    private String userCode;//用户账号
    private String username;//用户名

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
