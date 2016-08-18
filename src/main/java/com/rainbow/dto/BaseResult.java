package com.rainbow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//封装json结果
    @JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> {

    //是否成功返回
    private boolean success;

    //返回的数据：泛型
    private T data;

    //返回错误时的错误信息
    private String error;

    //返回正确时的构造函数：success，data
    public BaseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    //返回错误时的构造函数：返回false，error
    public BaseResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public BaseResult(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
