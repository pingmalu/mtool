package me.malu.mtool;

/**
 * 用静态方法减少代码量
 * <p>
 * v1.* 返回值对象JsonResult
 * v2.* 返回值对象JR
 * v3.* 重新定义返回码
 *
 * @author malu
 * @since 2020-04-07
 */
public final class mJson {
    public static boolean debug = false;

    public static class JR_debug extends JR {

        public String debug_info;

        public JR_debug(String debug_info) {
            super(SUCCESS, success_msg, null);
            this.debug_info = debug_info;
        }

        public JR_debug(int code, String message, Object data, String debug_info) {
            super(code, message, data);
            this.debug_info = debug_info;
        }

        public JR_debug(Throwable e, String debug_info) {
            super(ERROR, e.getMessage(), null);
            this.debug_info = debug_info;
        }

        public String getDebug_info() {
            return debug_info;
        }

        public void setDebug_info(String debug_info) {
            this.debug_info = debug_info;
        }
    }

    public static <T> JR mJson(int code, String message, T data) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(code, message, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(code, message, data);
        }
    }

    public static JR mJson(int code, String message) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(code, message, null, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(code, message, null);
        }
    }

    public static JR mJson() {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR();
        }
    }

    public static JR mJson(Throwable e) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(e, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(e);
        }
    }

    public static <T> JR mJson(T data) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(JR.SUCCESS, JR.success_msg, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(JR.SUCCESS, JR.success_msg, data);
        }
    }
}
