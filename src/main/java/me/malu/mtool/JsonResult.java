package me.malu.mtool;

import java.io.Serializable;

/**
 * 用于封装服务器到客户端的Json返回值
 *
 * @author malu
 * @since 2020-04-07
 */
public class JsonResult<T> implements Serializable {
    //Serializable将对象的状态保存在存储媒体中以便可以在以后重新创建出完全相同的副本
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    public static final int OTHER = 2;

    private int state;
    private String message = "";
    private String debug_info = "";
    private T data;
    private String pass = "";

    public JsonResult() {
        state = SUCCESS;
    }

    //为了方便，重载n个构造器
    public JsonResult(int state, String message, T data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int state, String message, T data, String debug_info) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
        this.debug_info = debug_info;
    }

    public JsonResult(int state, String error) {
        this(state, error, null);
    }

    public JsonResult(int state, T data) {
        this(state, "", data);
    }

    public JsonResult(String error) {
        this(ERROR, error, null);
    }

    public JsonResult(T data) {
        this(SUCCESS, "", data);
    }

    public JsonResult(int state) {
        this(state, "", null);
    }

    public JsonResult(Throwable e) {
        this(ERROR, e.getMessage(), null);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getDebug_info() {
        return debug_info;
    }

    public void setDebug_info(String debug_info) {
        this.debug_info = debug_info;
    }

    public static int getSuccess() {
        return SUCCESS;
    }

    public static int getError() {
        return ERROR;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", message=" + message + ", pass=" + pass + ", debug_info=" + debug_info + ", data=" + data + "]";
    }
}