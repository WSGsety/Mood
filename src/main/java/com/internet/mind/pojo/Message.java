package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/9
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("全局信息")
public class Message {

    @ApiModelProperty(value = "错误代码",example = "101")
    public int code;
    @ApiModelProperty(value = "错误信息",example = "用户名或密码错误")
    public String errorMessage;
    @ApiModelProperty(value = "具体信息",example = "User")
    public Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
