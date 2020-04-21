package com.internet.mind.mapper;

import com.internet.mind.pojo.SystemFlag;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.mapper
 * @version: 1.0
 */
public interface SystemFlagMapper {

    /**
     * 功能描述:根据Id查找标签名
     * @param:
     * @return:
     * @auther: Wzx
     * @date: 2020/4/12 15:06
     */
    @Select("select * from system_flag where sys_flag_id = #{param1}")
    SystemFlag selSysFlagByFlagId(int flagId);

    /**
     * 功能描述:查询该标签是否存在
     * @param:
     * @return: 
     * @auther: Wzx
     * @date: 2020/4/12 15:09
     */
    @Select("select sys_flag_id, sys_flag_name from system_flag where sys_flag_name = #{param1}")
    SystemFlag selExistByName(String sysFlagName);
}
