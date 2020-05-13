package me.malu.mtool;

import java.io.Serializable;

/**
 * 类说明: 接口统一结果返回，极简R类
 *
 * @author : Malu
 * @since : 2020-05-13 09:51
 **/
public class R<T> implements Serializable {
    public static final int SUCCESS = 200;
    public static final int ERROR = 500;
    public static String success_msg = "success"; // 成功默认提示
    public static String error_msg = "error"; // 失败默认提示

    public static boolean debug = false;

    private int code;
    private String message = "";
    private T data;

    public static class debug extends R {

        public String debug_info;

        public debug() {
            super();
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[3];
            this.debug_info = stackTrace.getFileName() + ":" + stackTrace.getLineNumber();
        }
    }

    private R() {
    }

    // 创建多个静态方法，兼容多种入参结构
    public static R R() {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.SUCCESS);
        r.setMessage(R.success_msg);
        return r;
    }

    public static R R(String message) {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.SUCCESS);
        r.setMessage(message);
        return r;
    }

    public static <T> R R(T data) {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.SUCCESS);
        r.setMessage(R.success_msg);
        r.setData(data);
        return r;
    }

    public static R R(int code, String message) {
        R r = debug ? new R.debug() : new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R R(String message, int code) {
        R r = debug ? new R.debug() : new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static <T> R R(String message, int code, T data) {
        R r = debug ? new R.debug() : new R();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    public static <T> R R(int code, String message, T data) {
        R r = debug ? new R.debug() : new R();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    // 通用返回成功
    public static R ok() {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.SUCCESS);
        r.setMessage(R.success_msg);
        return r;
    }

    // 通用返回成功message
    public static R ok(String message) {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.SUCCESS);
        r.setMessage(message);
        return r;
    }

    // 通用返回失败
    public static R error() {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.ERROR);
        r.setMessage(R.error_msg);
        return r;
    }

    // 通用返回失败message
    public static R error(String message) {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.ERROR);
        r.setMessage(message);
        return r;
    }

    // 通用返回失败code
    public static R error(int code) {
        R r = debug ? new R.debug() : new R();
        r.setCode(code);
        return r;
    }

    // 通用返回失败Throwable
    public static R error(Throwable e) {
        R r = debug ? new R.debug() : new R();
        r.setCode(R.ERROR);
        r.setMessage(e.getMessage());
        return r;
    }

    /**
     * ------------使用链式调用-----------
     **/

    // 通用设置data
    public R data(T data) {
        this.data = data;
        return this;
    }

    // 自定义状态信息
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public R code(Integer code) {
        this.setCode(code);
        return this;
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
}
