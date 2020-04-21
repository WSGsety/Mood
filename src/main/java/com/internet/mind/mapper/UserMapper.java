package com.internet.mind.mapper;

import com.internet.mind.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     * 功能描述:登录
     *
     * @param:登录名（手机号），密码
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Select("select * from user where user_phone = #{param1} and user_pwd = #{param2}")
    User selByPhonePwd(String userPhone, String userPwd);

    /**
     * 功能描述:查询用户类型
     *
     * @param:用户Id
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Select("select user_flag from user where user_id = #{userId}")
    int selFlagById(int userId);

    /**
     * 功能描述:注册
     *
     * @param:用户对象
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Insert("insert into user(user_phone, user_pwd, user_sex, user_age, user_bri, user_con, user_nick_name) values(#{userPhone}, #{userPwd}, #{userSex}, #{userAge}, #{userBri}, #{userCon}, #{userNickName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insUser(User user);

    /**
     * 功能描述:根据手机号查询用户是否存在
     *
     * @param:手机号
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Select("select user_id from user where user_phone = #{param1}")
    User selUserByPhone(String userPhone);

    /**
     * 功能描述:根据用户Id查询手机号
     *
     * @param:用户Id
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Select("select user_phone from user where user_id = #{param1}")
    String selPhoneById(int userId);

    /**
     * 功能描述:查询用户信息
     *
     * @param:用户Id
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    @Select("select * from user where user_id = #{param1}")
    User selAllById(int userId);

    /**
     * 功能描述:更改用户信息
     *
     * @param:用户对象
     * @return:
     * @auther: Wzx
     * @date: 2020/4/11 15:41
     */
    int updUserInfo(User user);

    /**
     * 功能描述:更改用户的标识（0：普通用户，1：朋辈，2：咨询师）
     *
     * @param:用户标识，用户Id
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 12:18
     */
    @Select("update user set user_flag = #{param1} where user_id = #{param2}")
    int updUserFlag(int userFlag, int userId);

    /**
     * 功能描述:新增关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:37
     */
    @Insert("insert into user_follow values(#{param1}, #{param2})")
    int insFollow(int userId, int followId);

    /**
     * 功能描述:取消关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:37
     */
    @Delete("delete from user_follow where user_id = #{param1} and follow_id = #{param2})")
    int delFollow(int userId, int followId);

    /**
     * 功能描述:查看关注
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:37
     */
    @Select("select follow_id from user_follow where user_id = #{param1})")
    List<Integer> selFollow(int userId);

    /**
     * 功能描述:查看粉丝
     *
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 17:37
     */
    @Select("select follower_id from user_follower where user_id = #{param1})")
    List<Integer> selFollower(int userId);

    @Update("update user set user_follow = user_follow + #{param2} where user_id = #{param1}")
    int updFollowById(int userId, int count);

    @Update("update user set user_follower = user_follower + #{param2} where user_id = #{param1}")
    int updFollowerById(int userId, int count);

}