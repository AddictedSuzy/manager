package com.zhiyue.manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T o) {
        this.code = code;
        this.message = message;
        this.data = (T) o;
    }

    public static CommonResult success() {
        CommonResult vo = new CommonResult();
        vo.setCode(200);
        vo.setMessage("成功");
        return vo;
    }

    public static CommonResult success(String message) {
        CommonResult vo = new CommonResult();
        vo.setCode(200);
        vo.setMessage(message);
        return vo;
    }

    public static CommonResult success(Object data) {
        CommonResult vo = new CommonResult();
        vo.setCode(200);
        vo.setMessage("成功");
        vo.setData(data);
        return vo;
    }

    public static CommonResult fail() {
        CommonResult vo = new CommonResult();
        vo.setCode(500);
        vo.setMessage("失败");
        return vo;
    }

    public static CommonResult fail(String message) {
        CommonResult vo = new CommonResult();
        vo.setCode(500);
        vo.setMessage(message);
        return vo;
    }

    public static CommonResult fail(Object data) {
        CommonResult vo = new CommonResult();
        vo.setCode(500);
        vo.setMessage("失败");
        vo.setData(data);
        return vo;
    }

}