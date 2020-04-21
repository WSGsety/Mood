package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @Auther: Wzx
 * @Date: 2020/4/11
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@ApiModel("朋辈辅导全部信息")
public class InstructorInfo {
    public User user;
    public UserInstructorInfo userInstructorInfo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInstructorInfo getUserInstructorInfo() {
        return userInstructorInfo;
    }

    public void setUserInstructorInfo(UserInstructorInfo userInstructorInfo) {
        this.userInstructorInfo = userInstructorInfo;
    }
}
