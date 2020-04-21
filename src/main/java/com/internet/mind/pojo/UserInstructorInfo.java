package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/11
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("朋辈辅导员额外信息")
public class UserInstructorInfo {

    @ApiModelProperty(value = "用户Id",example = "000001")
    public Integer userId;
    @ApiModelProperty(value = "真实姓名",example = "张三")
    public String insRealName;
    @ApiModelProperty(value = "学历",example = "大学")
    public String insEdu;
    @ApiModelProperty(value = "个人简历",example = "我是xxx，毕业于xxxx大学")
    public String insIntro;
    @ApiModelProperty(value = "身份证号",example = "410504200002021256")
    public Integer insIdCard;
    @ApiModelProperty(value = "银行卡",example = "6217002450011596572")
    public Integer insBankId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInsRealName() {
        return insRealName;
    }

    public void setInsRealName(String insRealName) {
        this.insRealName = insRealName;
    }

    public String getInsEdu() {
        return insEdu;
    }

    public void setInsEdu(String insEdu) {
        this.insEdu = insEdu;
    }

    public String getInsIntro() {
        return insIntro;
    }

    public void setInsIntro(String insIntro) {
        this.insIntro = insIntro;
    }

    public Integer getInsIdCard() {
        return insIdCard;
    }

    public void setInsIdCard(Integer insIdCard) {
        this.insIdCard = insIdCard;
    }

    public Integer getInsBankId() {
        return insBankId;
    }

    public void setInsBankId(Integer insBankId) {
        this.insBankId = insBankId;
    }
}