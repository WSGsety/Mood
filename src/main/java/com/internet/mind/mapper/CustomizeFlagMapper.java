package com.internet.mind.mapper;

import com.internet.mind.pojo.CustomizeFlag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.mapper
 * @version: 1.0
 */
public interface CustomizeFlagMapper {

    /**
     * 功能描述:根据Id查找标签名
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 15:06
     */
    @Select("select * from customize_flag where cus_flag_id = #{param1}")
    CustomizeFlag selCusFlagByFlagId(int flagId);

    /**
     * 功能描述:判断该标签是否存在
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 15:06
     */
    @Select("select cus_flag_id, cus_flag_name from customize_flag where cus_flag_name = #{param1}")
    CustomizeFlag selExistByName(String cusFlagName);

    /**
     * 功能描述:新增自定义标签
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 16:47
     */
    @Insert("insert into customize_flag(cus_flag_name) values(#{param1})")
    int insCusFlag(String cusFlagName);

}
