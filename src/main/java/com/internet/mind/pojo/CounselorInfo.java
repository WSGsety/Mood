package com.internet.mind.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Auther: Wzx
 * @Date: 2020/4/11
 * @Description: com.internet.mind.pojo
 * @version: 1.0
 */
@Data
@ApiModel("心理咨询师全部信息")
public class CounselorInfo {
    public User user;
    public UserCounselorInfo userCounselorInfo;
}
