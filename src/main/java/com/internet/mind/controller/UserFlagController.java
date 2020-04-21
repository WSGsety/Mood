package com.internet.mind.controller;

import com.internet.mind.pojo.Message;
import com.internet.mind.service.UserFlagService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Wzx
 * @Date: 2020/4/12
 * @Description: com.internet.mind.controller
 * @version: 1.0
 */
@CrossOrigin(origins = "*")
@Controller
@Api(tags = "兴趣爱好标签操作")
@RequestMapping("/hobby")
public class UserFlagController {

    @Autowired
    private UserFlagService userFlagService;

    @PostMapping("/addFlag")
    @ResponseBody
    @ApiOperation("新增兴趣爱好标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "flagName", value = "标签名", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 501, message = "标签添加成功"),
            @ApiResponse(code = 502, message = "添加标签失败"),
            @ApiResponse(code = 503, message = "标签已存在")
    })
    public Message addFlag(int userId, String flagName) {
        Message m = new Message();
        int flag = 0;
        //其中任何一条语句抛出异常均捕获并且处理
        try {
            flag = userFlagService.addFlag(userId, flagName);
        } catch (Exception ex) {
            ex.printStackTrace();
            m.setCode(502);
            m.setErrorMessage("添加标签失败");
        }
        if (flag == 1) {
            m.setCode(501);
            m.setErrorMessage("标签添加成功");
        } else {
            m.setCode(503);
            m.setErrorMessage("标签已存在");
        }
        return m;
    }

    @DeleteMapping("/delFlag")
    @ResponseBody
    @ApiOperation("删除兴趣爱好标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "flagName", value = "标签名", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 504, message = "删除成功"),
            @ApiResponse(code = 505, message = "删除失败")
    })
    public Message delFlag(int userId, String flagName) {
        Message m = new Message();
        int flag = 0;
        //其中任何一条语句抛出异常均捕获并且处理
        try {
            flag = userFlagService.delFlag(userId, flagName);
        } catch (Exception ex) {
            ex.printStackTrace();
            m.setCode(506);
            m.setErrorMessage("删除异常");
        }
        if (flag == 1) {
            m.setCode(504);
            m.setErrorMessage("删除成功");
        } else {
            m.setCode(505);
            m.setErrorMessage("删除失败");
        }
        return m;
    }

}
