package me.malu.mtool;

/**
 * 用静态方法减少代码量
 * @author malu
 * @since 2020-04-07
 */
public final class mJson {
    public static <T> JsonResult mJson(int state, String message, T data) {
        return new JsonResult(state, message, data);
    }

    public static JsonResult mJson(int state, String message) {
        return new JsonResult(state, message);
    }

    public static JsonResult mJson() {
        return new JsonResult(1, "成功");
    }

    public static JsonResult mJson(String error) {
        return new JsonResult(2, error, null);
    }


}
