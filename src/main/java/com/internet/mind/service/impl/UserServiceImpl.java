package com.internet.mind.service.impl;


import com.internet.mind.mapper.CustomizeFlagMapper;
import com.internet.mind.mapper.SystemFlagMapper;
import com.internet.mind.mapper.UserFlagMapper;
import com.internet.mind.mapper.UserMapper;
import com.internet.mind.pojo.CustomizeFlag;
import com.internet.mind.pojo.SystemFlag;
import com.internet.mind.pojo.User;
import com.internet.mind.pojo.UserFlag;
import com.internet.mind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomizeFlagMapper customizeFlagMapper;

    @Autowired
    private SystemFlagMapper systemFlagMapper;

    @Autowired
    private UserFlagMapper userFlagMapper;

    /**
     * 功能描述:登录
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:18
     */
    @Override
    public User login(String userPhone, String userPwd) {
        User user = userMapper.selByPhonePwd(userPhone, userPwd);
        return user;
    }

    /**
     * 功能描述:根据手机号查询用户是否存在
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:18
     */
    @Override
    public User findUserByPhone(String userPhone) {
        return userMapper.selUserByPhone(userPhone);
    }

    /**
     * 功能描述:查询用户基本信息（包含兴趣爱好）
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:19
     */
    @Override
    public User findAllInfo(int userId) {
        //根据userId取出用户的所有标签和标签类型
        List<UserFlag> hobbyFlags = userFlagMapper.selHobbyFlagById(userId);
        List<CustomizeFlag> customizeFlagList = new ArrayList<>();
        List<SystemFlag> systemFlagList = new ArrayList<>();
        //根据标签的类型去不同的表中查找
        for (UserFlag userFlag : hobbyFlags) {
            if ("1".equals(userFlag.getFlagType())) {
                CustomizeFlag customizeFlag = customizeFlagMapper.selCusFlagByFlagId(userId);
                customizeFlagList.add(customizeFlag);
            } else {
                SystemFlag systemFlag = systemFlagMapper.selSysFlagByFlagId(userId);
                systemFlagList.add(systemFlag);
            }
        }
        //将标签信息列表随用户信息一同返回
        User user = userMapper.selAllById(userId);
        user.setCustomizeFlagList(customizeFlagList);
        user.setSystemFlagList(systemFlagList);
        return user;
    }

    /**
     * 功能描述:查询用户类别（0：普通用户，1：朋辈辅导员，2：心理咨询师）
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:19
     */
    @Override
    public int findFlag(int userId) {
        return userMapper.selFlagById(userId);
    }

    /**
     * 功能描述:新增用户，注册
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:19
     */
    @Override
    public int addUser(User user) {
        return userMapper.insUser(user);
    }

    /**
     * 功能描述:完善用户信息
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:20
     */
    @Override
    public int addUserInfo(User user) {
        return userMapper.updUserInfo(user);
    }

    /**
     * 功能描述:新增关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:41
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addFollow(int userId, int followId) {
        //给userId表的关注数+1
        int flag1 = userMapper.updFollowById(userId, 1);
        //给followId的粉丝数+1
        int flag2 = userMapper.updFollowerById(userId, 1);
        return (flag1 == 1 && flag2 == 1) ? userMapper.insFollow(userId, followId) : 0;
    }

    /**
     * 功能描述:取消关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:41
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delFollow(int userId, int followId) {
        //给userId表的关注数-1
        int flag1 = userMapper.updFollowById(userId,-1);
        //给followId的粉丝数-1
        int flag2 = userMapper.updFollowerById(userId,-1);
        return (flag1 == 1 && flag2 == 1) ? userMapper.delFollow(userId, followId) : 0;
    }

    /**
     * 功能描述:查看关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:44
     */
    @Override
    public List<User> findFollow(int userId) {
        List<User> userList = new ArrayList<>();
        List<Integer> ids = userMapper.selFollow(userId);
        for (Integer i : ids) {
            User user = userMapper.selAllById(i);
            userList.add(user);
        }
        return userList;
    }

    /**
     * 功能描述:查看粉丝
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:44
     */
    @Override
    public List<User> findFollower(int userId) {
        List<User> userList = new ArrayList<>();
        List<Integer> ids = userMapper.selFollower(userId);
        for (Integer i : ids) {
            User user = userMapper.selAllById(i);
            userList.add(user);
        }
        return userList;
    }


}
