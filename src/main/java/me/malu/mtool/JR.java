package me.malu.mtool;

import java.io.Serializable;

/**
 * 用于封装服务器到客户端的Json返回值
 *
 * @author malu
 * @since 2020-04-07
 */
public class JR<T> implements Serializable {
    //Serializable将对象的状态保存在存储媒体中以便可以在以后重新创建出完全相同的副本
    public static final int SUCCESS = 200;
    public static final int ERROR = 500;
    public static String success_msg = "success"; // 成功默认提示

    private int code;
    private String message = "";
    private T data;

    public JR() {
        code = SUCCESS;
        message = success_msg;
    }

    //为了方便，重载n个构造器
    public JR(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JR(int code, String error) {
        this(code, error, null);
    }

    public JR(int code, T data) {
        this(code, "", data);
    }

    public JR(String error) {
        this(ERROR, error, null);
    }

    public JR(T data) {
        this(SUCCESS, success_msg, data);
    }

    public JR(int code) {
        this(code, "", null);
    }

    public JR(Throwable e) {
        this(ERROR, e.getMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static int getSuccess() {
        return SUCCESS;
    }

    public static int getError() {
        return ERROR;
    }

    @Override
    public String toString() {
        return "JR [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}