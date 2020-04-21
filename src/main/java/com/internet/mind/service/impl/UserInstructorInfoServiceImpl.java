package com.internet.mind.service.impl;

import com.internet.mind.mapper.UserInstructorInfoMapper;
import com.internet.mind.mapper.UserMapper;
import com.internet.mind.pojo.InstructorInfo;
import com.internet.mind.pojo.User;
import com.internet.mind.pojo.UserInstructorInfo;
import com.internet.mind.service.UserInstructorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInstructorInfoServiceImpl implements UserInstructorInfoService {

    @Autowired
    private UserInstructorInfoMapper userInstructorInfoMapper;

    @Autowired
    private UserMapper userMapper;

    /**
      * 功能描述:查询朋辈辅导员信息
      * @param: 
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:17
      */
    @Override
    public InstructorInfo findInfo(int userId) {
        UserInstructorInfo userInstructorInfo = userInstructorInfoMapper.selAll(userId);
        User user = userMapper.selAllById(userId);
        InstructorInfo i = new InstructorInfo();
        i.setUser(user); i.setUserInstructorInfo(userInstructorInfo);
        return i;
    }

    /**
      * 功能描述:新增朋辈辅导员
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:17
      */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUserInstructorInfo(UserInstructorInfo userInstructorInfo) {
        int flag1 = userInstructorInfoMapper.insUserInstructorInfo(userInstructorInfo);
        int flag2 = 0;
        if (flag1 == 1){
            int userId = userInstructorInfo.getUserId();
            flag2 = userMapper.updUserFlag(userId, 1);
        }
        return (flag1 == 1 && flag2 == 1) ? 1 : 0;
    }

}
