package com.internet.mind.mapper;

import com.internet.mind.pojo.UserFlag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.mapper
 * @version: 1.0
 */
public interface UserFlagMapper {

    /**
      * 功能描述:根据用户Id查询兴趣爱好标签
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:55
      */
    @Select("select flag_id, flag_type from user_flag where user_id = #{param1}")
    List<UserFlag> selHobbyFlagById(int userId);

    /**
      * 功能描述:查询某个兴趣标签是否存在
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:58
      */
    @Select("select * from user_flag where user_id = #{param1} and flag_id = #{param2} and flag_type = #{param3}")
    int selHobbyExist(int userId, int flagId, String flagType);

    /**
      * 功能描述:给某用户新增一个兴趣标签
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:59
      */
    @Insert("insert into user_flag values(#{param1}, #{param2}, #{param3})")
    int insHobby(int userId, int flagId, String flagType);

    /**
      * 功能描述:删除某用户的兴趣标签
      * @param:
      * @return:
      * @auther: Wzx
      * @date: 2020/4/12 16:59
      */
    @Delete("delete from user_flag where user_id = #{param1} and flag_id = #{param2}")
    int delHobby(int userId, int flagId);
}
