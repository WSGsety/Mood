package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @Auther: Wzx
 * @Date: 2020/4/11
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("心理咨询师全部信息")
public class CounselorInfo {
    public User user;
    public UserCounselorInfo userCounselorInfo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCounselorInfo getUserCounselorInfo() {
        return userCounselorInfo;
    }

    public void setUserCounselorInfo(UserCounselorInfo userCounselorInfo) {
        this.userCounselorInfo = userCounselorInfo;
    }
}
