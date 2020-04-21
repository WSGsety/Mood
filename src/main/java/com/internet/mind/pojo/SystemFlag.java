package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("系统用户标签")
public class SystemFlag {

    @ApiModelProperty(value = "系统用户标签",example = "000001")
    public Integer sysFlagId;
    @ApiModelProperty(value = "系统用户标签名",example = "内向")
    public String sysFlagName;

    public Integer getSysFlagId() {
        return sysFlagId;
    }

    public void setSysFlagId(Integer sysFlagId) {
        this.sysFlagId = sysFlagId;
    }

    public String getSysFlagName() {
        return sysFlagName;
    }

    public void setSysFlagName(String sysFlagName) {
        this.sysFlagName = sysFlagName;
    }
}
