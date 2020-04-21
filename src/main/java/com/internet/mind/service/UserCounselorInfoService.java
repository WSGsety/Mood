package com.internet.mind.service;


import com.internet.mind.pojo.CounselorInfo;
import com.internet.mind.pojo.UserCounselorInfo;

public interface UserCounselorInfoService {

    /**
      * 功能描述:查询心理咨询师信息
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:11
      */
    CounselorInfo findInfo(int userId);

    /**
      * 功能描述:新增心理咨询师
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:11
      */
    int addUserCounselorInfo(UserCounselorInfo userCounselorInfo);
}
