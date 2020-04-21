package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/9
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("验证码")
public class Code {
    @ApiModelProperty(value = "验证码",example = "AS05")
    public String code;
    @ApiModelProperty(value = "验证码长度",example = "4")
    public Integer codeLength;

    public Code(String code, Integer codeLength) {
        this.code = code;
        this.codeLength = codeLength;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }
}
