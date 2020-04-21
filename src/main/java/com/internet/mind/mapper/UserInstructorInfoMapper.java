package com.internet.mind.mapper;

import com.internet.mind.pojo.UserInstructorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserInstructorInfoMapper {

    /**
      * 功能描述:根据用户Id查询朋辈辅导员信息
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:59
      */
    @Select("select * from user_instructor_info where user_id = #{userId}")
    UserInstructorInfo selAll(int userId);

    /**
      * 功能描述:新增朋辈辅导员
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 17:00
      */
    @Insert("insert into user_instructor_info(user_id, ins_real_name, ins_edu, ins_intro, " +
            "ins_id_card, ins_bank_id) values(#{userId}, #{insRealName}, #{insEdu}, " +
            "#{insIntro}, #{insIdCard}, #{insBankId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insUserInstructorInfo(UserInstructorInfo userInstructorInfo);
}