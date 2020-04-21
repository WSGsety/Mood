package com.internet.mind.service.impl;


import com.internet.mind.mapper.UserCounselorInfoMapper;
import com.internet.mind.mapper.UserMapper;
import com.internet.mind.pojo.CounselorInfo;
import com.internet.mind.pojo.User;
import com.internet.mind.pojo.UserCounselorInfo;
import com.internet.mind.service.UserCounselorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCounselorInfoServiceImpl implements UserCounselorInfoService {

    @Autowired
    private UserCounselorInfoMapper userCounselorInfoMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 功能描述:查询心理咨询师信息
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:11
     */
    @Override
    public CounselorInfo findInfo(int userId) {
        UserCounselorInfo userCounselorInfo = userCounselorInfoMapper.selAll(userId);
        User user = userMapper.selAllById(userId);
        CounselorInfo c = new CounselorInfo();
        c.setUser(user); c.setUserCounselorInfo(userCounselorInfo);
        return c;
    }

    /**
     * 功能描述:新增心理咨询师
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:11
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUserCounselorInfo(UserCounselorInfo userCounselorInfo) {
        int flag1 = userCounselorInfoMapper.insUserCounselorInfo(userCounselorInfo);
        int flag2 = 0;
        if (flag1 == 1){
            int userId = userCounselorInfo.getUserId();
            flag2 = userMapper.updUserFlag(userId, 2);
        }
        return (flag1 == 1 && flag2 == 1) ? 1 : 0;
    }
}
