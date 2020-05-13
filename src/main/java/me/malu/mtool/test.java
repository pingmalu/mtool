package me.malu.mtool;

/**
 * 类说明: 测试类
 *
 * @author : Malu
 * @date : 2020-05-13 10:37
 **/
public class test {

    public R t1() {
        return R.ok("23").data("ccc");
    }

    public static void main(String[] args) {
        test r = new test();
        R re = r.t1();
        System.out.println(re);
    }
}
