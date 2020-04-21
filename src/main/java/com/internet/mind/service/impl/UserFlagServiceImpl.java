package com.internet.mind.service.impl;

import com.internet.mind.mapper.CustomizeFlagMapper;
import com.internet.mind.mapper.SystemFlagMapper;
import com.internet.mind.mapper.UserFlagMapper;
import com.internet.mind.pojo.CustomizeFlag;
import com.internet.mind.pojo.SystemFlag;
import com.internet.mind.service.UserFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.service.impl
 * @version: 1.0
 */
@Service
public class UserFlagServiceImpl implements UserFlagService {

    @Autowired
    private UserFlagMapper userFlagMapper;

    @Autowired
    private SystemFlagMapper systemFlagMapper;

    @Autowired
    private CustomizeFlagMapper customizeFlagMapper;

    /**
      * 功能描述:新增兴趣爱好标签
      * @param: 
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:17
      */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addFlag(int userId, String FlagName) {
        //是系统标签吗?
        SystemFlag systemFlag = systemFlagMapper.selExistByName(FlagName);
        if (systemFlag != null) {
            //是系统标签：用flagId、userId和类型（1）去user_flag表中查
            int flag = userFlagMapper.selHobbyExist(userId, systemFlag.getSysFlagId(), "1");
            if (flag == 0) {
                //不存在：插入user_flag表中
                userFlagMapper.insHobby(userId, systemFlag.getSysFlagId(), "1");
                return 1;
            }
            //有：返回已经存在
            return 0;
        } else {
            //不是系统标签：判断是不是存在自定义标签
            CustomizeFlag customizeFlag = customizeFlagMapper.selExistByName(FlagName);
            if (customizeFlag == null) {
                //不存在：同时插入user_flag表和customize_flag表
                customizeFlagMapper.insCusFlag(FlagName);
                userFlagMapper.insHobby(userId, customizeFlag.getCusFalgId(), "0");
                return 1;
            } else {
                //存在：检查user_flag表中是否存在
                int flag = userFlagMapper.selHobbyExist(userId, customizeFlag.getCusFalgId(), "0");
                if (flag == 0) {
                    userFlagMapper.insHobby(userId, customizeFlag.getCusFalgId(), "0");
                    return 1;
                }
                //有：返回已经存在
                return 0;
            }
        }
    }

    /**
      * 功能描述:删除兴趣爱好标签
      * @param:
      * @return: 
      * @auther: Wzx
      * @date: 2020/4/12 17:17
      */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delFlag(int userId, String flagName) {
        SystemFlag systemFlag = systemFlagMapper.selExistByName(flagName);
        if(systemFlag != null){
            return userFlagMapper.delHobby(userId, systemFlag.getSysFlagId());
        }
        CustomizeFlag customizeFlag = customizeFlagMapper.selExistByName(flagName);
        return userFlagMapper.delHobby(userId, customizeFlag.getCusFalgId());
    }
}
