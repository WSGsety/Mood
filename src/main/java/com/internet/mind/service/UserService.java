package com.internet.mind.service;


import com.internet.mind.pojo.User;

import java.util.List;

public interface UserService {

    /**
      * 功能描述:登录
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:12
      */
    User login(String userPhone, String userPwd);

    /**
     * 功能描述:根据手机号查询用户是否存在
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:12
     */
    User findUserByPhone(String userPhone);

    /**
     * 功能描述:查询用户基本信息（包含兴趣爱好）
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:12
     */
    User findAllInfo(int userId);

    /**
     * 功能描述:查询用户类别（0：普通用户，1：朋辈辅导员，2：心理咨询师）
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:12
     */
    int findFlag(int userId);

    /**
     * 功能描述:新增用户，注册
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:12
     */
    int addUser(User user);

    /**
     * 功能描述:完善用户信息
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:12
     */
    int addUserInfo(User user);

    /**
      * 功能描述:新增关注
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:41
      */
    int addFollow(int userId, int followId);

    /**
     * 功能描述:取消关注
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:41
     */
    int delFollow(int userId, int followId);

    /**
      * 功能描述:查看关注
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:44
      */
    List<User> findFollow(int userId);

    /**
      * 功能描述:查看粉丝
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:44
      */
    List<User> findFollower(int userId);
}
