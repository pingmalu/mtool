package me.malu.mtool;

/**
 * 用静态方法减少代码量
 *
 * v1.* 返回值对象JsonResult
 * v2.* 返回值对象JR
 *
 * @author malu
 * @since 2020-04-07
 */
public final class mJson {
    public static boolean debug = false;
    public static String success_msg = "成功";

    public static class JR_debug extends JR {
        public static final int SUCCESS = 0;
        public static final int ERROR = 1;
        String debug_info;

        public JR_debug(String debug_info) {
            super(SUCCESS, "成功", null);
            this.debug_info = debug_info;
        }

        public JR_debug(int state, String message, Object data, String debug_info) {
            super(state, message, data);
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

    public static <T> JR mJson(int state, String message, T data) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JR_debug(state, message, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(state, message, data);
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
            return new JR_debug(1, success_msg, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JR(1, success_msg, data);
        }
    }
}
