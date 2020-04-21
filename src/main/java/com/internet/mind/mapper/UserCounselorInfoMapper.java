package com.internet.mind.mapper;

import com.internet.mind.pojo.UserCounselorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserCounselorInfoMapper {

     /**
       * 功能描述:根据用户Id查询心理咨询师信息
       * @param:
       * @return: 
       * @auther: Wzx
       * @date: 2020/4/12 16:54
       */
    @Select("select * from user_counselor_info where user_id = #{userId}")
    UserCounselorInfo selAll(int userId);

    /**
      * 功能描述:新增心理咨询师
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:55
      */
    @Insert("insert into user_counselor_info(user_id, cou_real_name, cou_edu, cou_intro, " +
            "cou_id_card, cou_bank_id, cou_marry, cou_qua, cou_exp, cou_field, cou_cer) " +
            "values(#{userId}, #{couRealName}, #{couEdu}, #{couIntro}, #{couIdCard}, " +
            "#{couBankId}, #{couMarry}, #{couQua}, #{couExp}, #{couField}, #{couCer})")
    int insUserCounselorInfo(UserCounselorInfo userCounselorInfo);
}