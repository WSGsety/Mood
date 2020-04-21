package com.internet.mind.controller;

import com.internet.mind.pojo.InstructorInfo;
import com.internet.mind.pojo.Message;
import com.internet.mind.pojo.UserInstructorInfo;
import com.internet.mind.service.UserInstructorInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "朋辈辅导操作")
@RequestMapping("/instructor")
public class UserInstructorInfoController {

    @Autowired
    private UserInstructorInfoService userInstructorInfoService;

    @GetMapping("/findInfo")
    @ApiOperation("查询朋辈辅导信息")
    @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true)
    public InstructorInfo findInfo(int userId) {
        return userInstructorInfoService.findInfo(userId);
    }

    @PostMapping("/insIns")
    @ApiOperation("认证朋辈辅导")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "insRealName", value = "真实姓名", paramType = "query", required = true),
            @ApiImplicitParam(name = "insEdu", value = "学历", paramType = "query", required = true),
            @ApiImplicitParam(name = "insIntro", value = "个人简历", paramType = "query", required = true),
            @ApiImplicitParam(name = "insIdCard", value = "身份证号", paramType = "query", required = true),
            @ApiImplicitParam(name = "insBankId", value = "银行卡", paramType = "query", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "同辈辅导认证成功"),
            @ApiResponse(code = 402,message = "同辈辅导认证失败")
    })
    public Message registGen(UserInstructorInfo userInstructorInfo) {
        Message m = new Message();
        int flag = userInstructorInfoService.addUserInstructorInfo(userInstructorInfo);
        if(flag == 1){
            m.setCode(401);
            m.setErrorMessage("同辈辅导认证成功");
        }else {
            m.setCode(402);
            m.setErrorMessage("同辈辅导认证失败");
        }
        return m;
    }
}
