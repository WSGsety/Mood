package com.internet.mind.controller;

import com.internet.mind.pojo.CounselorInfo;
import com.internet.mind.pojo.Message;
import com.internet.mind.pojo.UserCounselorInfo;
import com.internet.mind.service.UserCounselorInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "心理咨询师操作")
@RequestMapping("/counselor")
public class UserCounselorInfoController  {

    @Autowired
    private UserCounselorInfoService userCounselorInfoService;

    @GetMapping("/findInfo")
    @ApiOperation("查询心理咨询师信息")
    @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true)
    public CounselorInfo findInfo(int userId) {
        return userCounselorInfoService.findInfo(userId);
    }

    @PostMapping("/insCou")
    @ApiOperation("认证心理咨询师")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "couRealName", value = "真实姓名", paramType = "query", required = true),
            @ApiImplicitParam(name = "couEdu", value = "学历", paramType = "query", required = true),
            @ApiImplicitParam(name = "couIntro", value = "个人简历", paramType = "query", required = true),
            @ApiImplicitParam(name = "couIdCard", value = "身份证号", paramType = "query", required = true),
            @ApiImplicitParam(name = "couBankId", value = "银行卡", paramType = "query", required = true),
            @ApiImplicitParam(name = "couMarry", value = "婚姻状况", paramType = "query", required = true),
            @ApiImplicitParam(name = "couQua", value = "从业资质qualification", paramType = "query", required = true),
            @ApiImplicitParam(name = "couExp", value = "从业年龄experience", paramType = "query", required = true),
            @ApiImplicitParam(name = "couField", value = "从业领域field", paramType = "query", required = true),
            @ApiImplicitParam(name = "couCer", value = "资格证书certificate（图片）", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 201,message = "心理咨询师认证成功"),
            @ApiResponse(code = 202,message = "心理咨询师认证失败")
    })
    public Message registCou(UserCounselorInfo userCounselorInfo) {
        Message m = new Message();
        int flag = userCounselorInfoService.addUserCounselorInfo(userCounselorInfo);
        if(flag == 1){
            m.setCode(201);
            m.setErrorMessage("心理咨询师认证成功");
        }else {
            m.setCode(202);
            m.setErrorMessage("心理咨询师认证失败");
        }
        return m;
    }

}
