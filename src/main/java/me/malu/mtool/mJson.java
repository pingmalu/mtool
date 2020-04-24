package me.malu.mtool;

/**
 * 用静态方法减少代码量
 *
 * @author malu
 * @since 2020-04-07
 */
public final class mJson {
    public static boolean debug = false;
    public static String success_msg = "成功";

    public static <T> JsonResult mJson(int state, String message, T data) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JsonResult(state, message, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JsonResult(state, message, data);
        }
    }

    public static JsonResult mJson(int state, String message) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JsonResult(state, message, null, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JsonResult(state, message);
        }
    }

    public static JsonResult mJson() {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JsonResult(1, success_msg, null, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JsonResult(1, success_msg);
        }
    }

    public static JsonResult mJson(String error) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JsonResult(2, error, null, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JsonResult(2, error, null);
        }
    }

    public static <T> JsonResult mJson(T data) {
        if (debug) {
            Thread currentThread = Thread.currentThread();
            StackTraceElement stackTrace = currentThread.getStackTrace()[2];
            return new JsonResult(1, success_msg, data, stackTrace.getFileName() + ":" + stackTrace.getLineNumber());
        } else {
            return new JsonResult(1, success_msg, data);
        }
    }
}
