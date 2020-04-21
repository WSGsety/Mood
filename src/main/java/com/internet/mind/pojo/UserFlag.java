package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("用户兴趣爱好标签")
public class UserFlag {

    @ApiModelProperty(value = "用户id",example = "000001")
    public Integer userId;
    @ApiModelProperty(value = "标签id",example = "000001")
    public Integer flagId;
    @ApiModelProperty(value = "标签类型（0：系统，1：自定义）",example = "0")
    public String flagType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    public String getFlagType() {
        return flagType;
    }

    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }
}
