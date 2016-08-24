package com.rainbow.dto;

/**
 * Created by rainbow on 2016/8/22.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class UserResult {

    private Long userId;
    private String username;

    //构造函数


    public UserResult(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
