package com.internet.mind.service;

import com.internet.mind.pojo.InstructorInfo;
import com.internet.mind.pojo.UserInstructorInfo;


public interface UserInstructorInfoService {

    /**
      * 功能描述:查询朋辈辅导员信息
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:12
      */
    InstructorInfo findInfo(int userId);

    /**
      * 功能描述:新增朋辈辅导员
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:12
      */
    int addUserInstructorInfo(UserInstructorInfo userInstructorInfo);

}
