package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Wzx
 * @Date: 2020/4/9
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("心理咨询师额外信息")
public class UserCounselorInfo {

    @ApiModelProperty(value = "用户Id",example = "000001")
    public Integer userId;
    @ApiModelProperty(value = "真实姓名",example = "张三")
    public String couRealName;
    @ApiModelProperty(value = "学历",example = "大学")
    public String couEdu;
    @ApiModelProperty(value = "个人简历",example = "我是xxx，毕业于xxxx大学")
    public String couIntro;
    @ApiModelProperty(value = "身份证号",example = "410504200002021256")
    public Integer couIdCard;
    @ApiModelProperty(value = "银行卡",example = "6217002450011596572")
    public Integer couBankId;
    @ApiModelProperty(value = "婚姻状况",example = "已婚")
    public String couMarry;
    @ApiModelProperty(value = "从业资质qualification",example = "心理咨询师三级")
    public String couQua;
    @ApiModelProperty(value = "从业年龄experience",example = "7年")
    public String couExp;
    @ApiModelProperty(value = "从业领域field",example = "生活")
    public String couField;
    @ApiModelProperty(value = "资格证书certificate（图片）",example = "http://xxxxx/xxxx.jpg")
    public String couCer;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCouRealName() {
        return couRealName;
    }

    public void setCouRealName(String couRealName) {
        this.couRealName = couRealName;
    }

    public String getCouEdu() {
        return couEdu;
    }

    public void setCouEdu(String couEdu) {
        this.couEdu = couEdu;
    }

    public String getCouIntro() {
        return couIntro;
    }

    public void setCouIntro(String couIntro) {
        this.couIntro = couIntro;
    }

    public Integer getCouIdCard() {
        return couIdCard;
    }

    public void setCouIdCard(Integer couIdCard) {
        this.couIdCard = couIdCard;
    }

    public Integer getCouBankId() {
        return couBankId;
    }

    public void setCouBankId(Integer couBankId) {
        this.couBankId = couBankId;
    }

    public String getCouMarry() {
        return couMarry;
    }

    public void setCouMarry(String couMarry) {
        this.couMarry = couMarry;
    }

    public String getCouQua() {
        return couQua;
    }

    public void setCouQua(String couQua) {
        this.couQua = couQua;
    }

    public String getCouExp() {
        return couExp;
    }

    public void setCouExp(String couExp) {
        this.couExp = couExp;
    }

    public String getCouField() {
        return couField;
    }

    public void setCouField(String couField) {
        this.couField = couField;
    }

    public String getCouCer() {
        return couCer;
    }

    public void setCouCer(String couCer) {
        this.couCer = couCer;
    }
}