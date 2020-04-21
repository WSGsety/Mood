package com.internet.mind.service;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.service
 * @version: 1.0
 */
public interface UserFlagService {

    /**
      * 功能描述:新增兴趣爱好标签
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:11
      */
    int addFlag(int userId, String FlagName);

    /**
     * 功能描述:删除兴趣爱好标签
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:11
     */
    int delFlag(int userId, String flagName);
}
