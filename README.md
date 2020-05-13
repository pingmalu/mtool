# mtool

用于规范Java中编码方式，统一接口管理，最小化代码量

## mJson 使用说明

### v1.* 返回值对象JsonResult

### v2.* 修改返回值对象JR

### v3.* 重新定义返回码

### v4.* 新增R返回对象，支持链式调用，兼容多种入参结构

支持以下写法：

```java
// 使用前先导入
import me.malu.mtool.R;
import static me.malu.mtool.R.R;  // 导入静态方法

R.debug = true;  // 开启debug
return R();
return R("成功");
return R("没有权限").code(R.ERROR);
return R("没有权限",R.ERROR);
return R(200,"保存成功");
return R(404,"没有该接口","error");
return R().code(5001).data("T object").message("some message");
return R.ok();
return R.ok().data("T object");
return R.ok("更新完成");
return R.ok("更新完成").data("T object");
return R.ok("更新完成").data("T object").code(R.SUCCESS);
return R.error().message("错误消息").code(503);
return R.error("更新失败").code(503);
return R.error("这个失败信息会被覆盖").code(5001).data("T object").message("some message");
```

开启关闭debug演示：

```java
@RequestMapping("/debug/on")
public R debug_on() {
    R.debug = true;
    return R("debug开启");
}

@RequestMapping("/debug/off")
public R debug_off() {
    R.debug = false;
    return R("debug关闭");
}
```

code默认只定义2个

```java
public static final int SUCCESS = 200;
public static final int ERROR = 500;
```

建议参考 RFC 2616 规范

||code区间|类型|含义|
|:-|:-|:-|:-|
|1**|	100-199|	信息	|服务器接收到请求，需要请求者继续执行操作|
|2**|	200-299|	成功	|请求被成功接收并处理|
|3**|	300-399|	重定向	|需要进一步的操作以完成请求|
|4**|	400-499|	客户端错误	|请求包含语法错误或无法完成请求|
|5**|	500-599|	服务器错误	|服务器在处理的时候发生错误|