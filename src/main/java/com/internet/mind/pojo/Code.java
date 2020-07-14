package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Wzx
 * @Date: 2020/4/9
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("验证码")
public class Code {
    @ApiModelProperty(value = "验证码",example = "AS05")
    public String code;
    @ApiModelProperty(value = "验证码长度",example = "4")
    public Integer codeLength;
}
