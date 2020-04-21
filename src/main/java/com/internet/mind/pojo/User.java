package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: Wzx
 * @Date: 2020/4/9
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("用户基础信息")
public class User {

    @ApiModelProperty(value = "用户Id",example = "000001")
    public Integer userId;
    @ApiModelProperty(value = "用户手机号（登录名）",example = "16666666666")
    public String userPhone;
    @ApiModelProperty(value = "用户密码",example = "123456")
    public String userPwd;
    @ApiModelProperty(value = "性别",example = "女")
    public String userSex;
    @ApiModelProperty(value = "年龄",example = "23")
    public Integer userAge;
    @ApiModelProperty(value = "出生年月",example = "2020-02-02")
    public String userBri;
    @ApiModelProperty(value = "星座",example = "射手座")
    public String userCon;
    @ApiModelProperty(value = "昵称",example = "aaaa")
    public String userNickName;
    @ApiModelProperty(value = "所在地区（省市）",example = "河南省洛阳市")
    public String userArea;
    @ApiModelProperty(value = "用户标志（0：普通用户，1：同辈辅导员，2：心理咨询师）",example = "0")
    public Integer userFlag;
    @ApiModelProperty(value = "用户头像",example = "http://xxxxx/xxxx.jpg")
    public String userImg;
    @ApiModelProperty(value = "个性签名",example = "这个人很懒，什么都没有留下")
    public String userIntro;
    @ApiModelProperty(value = "关注数",example = "200")
    public Integer userFollow;
    @ApiModelProperty(value = "粉丝数",example = "3000")
    public Integer userFollower;
    @ApiModelProperty(value = "用户余额（元）",example = "23.62")
    public BigDecimal userCoin;
    @ApiModelProperty(value = "VIP（0：不是VIP，1：是VIP）",example = "0")
    public Integer userVip;
    @ApiModelProperty(value = "自定义兴趣爱好信息",example = "仙气十足")
    public List<CustomizeFlag> customizeFlagList;
    @ApiModelProperty(value = "系统兴趣爱好信息",example = "内向")
    public List<SystemFlag> systemFlagList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserBri() {
        return userBri;
    }

    public void setUserBri(String userBri) {
        this.userBri = userBri;
    }

    public String getUserCon() {
        return userCon;
    }

    public void setUserCon(String userCon) {
        this.userCon = userCon;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public Integer getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(Integer userFollow) {
        this.userFollow = userFollow;
    }

    public Integer getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(Integer userFollower) {
        this.userFollower = userFollower;
    }

    public BigDecimal getUserCoin() {
        return userCoin;
    }

    public void setUserCoin(BigDecimal userCoin) {
        this.userCoin = userCoin;
    }

    public Integer getUserVip() {
        return userVip;
    }

    public void setUserVip(Integer userVip) {
        this.userVip = userVip;
    }

    public List<CustomizeFlag> getCustomizeFlagList() {
        return customizeFlagList;
    }

    public void setCustomizeFlagList(List<CustomizeFlag> customizeFlagList) {
        this.customizeFlagList = customizeFlagList;
    }

    public List<SystemFlag> getSystemFlagList() {
        return systemFlagList;
    }

    public void setSystemFlagList(List<SystemFlag> systemFlagList) {
        this.systemFlagList = systemFlagList;
    }
}