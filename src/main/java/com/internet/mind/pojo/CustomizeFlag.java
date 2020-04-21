package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("自定义用户标签")
public class CustomizeFlag {

    @ApiModelProperty(value = "自定义用户标签Id",example = "000001")
    public Integer cusFalgId;
    @ApiModelProperty(value = "自定义用户标签名",example = "仙气十足")
    public String cusFlagName;

    public Integer getCusFalgId() {
        return cusFalgId;
    }

    public void setCusFalgId(Integer cusFalgId) {
        this.cusFalgId = cusFalgId;
    }

    public String getCusFlagName() {
        return cusFlagName;
    }

    public void setCusFlagName(String cusFlagName) {
        this.cusFlagName = cusFlagName;
    }
}
