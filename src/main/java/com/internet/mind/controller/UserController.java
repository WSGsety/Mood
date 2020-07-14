package com.internet.mind.controller;

import com.internet.mind.pojo.Code;
import com.internet.mind.pojo.Message;
import com.internet.mind.pojo.User;
import com.internet.mind.service.UserService;
import com.internet.mind.util.VerificationCode;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@Controller
@Api(tags = "用户操作")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", paramType = "query", required = true),
            @ApiImplicitParam(name = "userPwd", value = "密码", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 101, message = "登录成功"),
            @ApiResponse(code = 102, message = "用户名或密码错误")
    })
    public Message login(String userPhone, String userPwd) {
        Message e = new Message();
        User user = userService.login(userPhone, userPwd);
        if (user == null) {
            e.setCode(102);
            e.setErrorMessage("用户名或密码错误");
        } else {
            e.setCode(101);
            e.setErrorMessage("登录成功");
        }
        return e;
    }

    @PostMapping("/register")
    @ResponseBody
    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", paramType = "query", required = true),
            @ApiImplicitParam(name = "userPwd", value = "密码", paramType = "query", required = true),
            @ApiImplicitParam(name = "userNickName", value = "昵称", paramType = "query", required = true),
            @ApiImplicitParam(name = "userSex", value = "性别", paramType = "query", required = true),
            @ApiImplicitParam(name = "userBri", value = "出生年月", paramType = "query", required = true),
            @ApiImplicitParam(name = "userAge", value = "年龄", paramType = "query", required = true),
            @ApiImplicitParam(name = "userCon", value = "星座", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 103, message = "注册成功"),
            @ApiResponse(code = 104, message = "注册失败")
    })
    public Message register(User user) {
        Message m = new Message();
        int flag = userService.addUser(user);
        if (flag == 0) {
            m.setCode(104);
            m.setErrorMessage("注册失败");
        } else {
            User user2 = new User();
            user2.setUserId(user.getUserId());
            m.setCode(103);
            m.setErrorMessage("注册成功");
            m.setObject(user2);
        }
        return m;
    }

    @ResponseBody
    @GetMapping("/findInfo")
    @ApiOperation("查询用户信息（包含兴趣爱好）")
    @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true)
    public User findInfo(int userId) {
        log.info("调用接口 = {} 成功，message = {}", this.getClass().getName(), userId);
        return userService.findAllInfo(userId);
    }

    @GetMapping("/getCode")
    @ResponseBody
    @ApiOperation("获取验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", paramType = "query", required = true),
            @ApiImplicitParam(name = "flag", value = "1：注册，0：登录", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 105, message = "获取验证码成功"),
            @ApiResponse(code = 106, message = "获取验证码失败"),
            @ApiResponse(code = 107, message = "获取验证码失败")
    })
    public Message getCode(String userPhone, int flag) {
        Message m = new Message();
        //注册的情况
        if (flag == 1) {
            User user = userService.findUserByPhone(userPhone);
            if (user != null) {
                m.setCode(107);
                m.setErrorMessage("手机号已注册");
                return m;
            }
        }
        //登录的情况
        VerificationCode vc = new VerificationCode();
        String code = vc.getCode();
        System.out.println(code);
        if (code.length() != 0) {
            m.setCode(105);
            m.setErrorMessage("获取验证码成功");
            m.setObject(new Code(code, 6));
        } else {
            m.setCode(106);
            m.setErrorMessage("获取验证码失败");
        }
        return m;
    }

    @PutMapping("/addInfo")
    @ResponseBody
    @ApiOperation("完善信息、修改信息、修改密码。给什么参数改什么")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", paramType = "query", required = false),
            @ApiImplicitParam(name = "userNickName", value = "昵称", paramType = "query", required = false),
            @ApiImplicitParam(name = "userPwd", value = "密码", paramType = "query", required = false),
            @ApiImplicitParam(name = "userSex", value = "性别", paramType = "query", required = false),
            @ApiImplicitParam(name = "userBri", value = "出生年月", paramType = "query", required = false),
            @ApiImplicitParam(name = "userAge", value = "年龄", paramType = "query", required = false),
            @ApiImplicitParam(name = "userCon", value = "星座", paramType = "query", required = false),
            @ApiImplicitParam(name = "userArea", value = "星座", paramType = "query", required = false)
    })
    @ApiResponses({
            @ApiResponse(code = 110, message = "修改成功"),
            @ApiResponse(code = 111, message = "修改失败")
    })
    public Message addInfo(User user) {
        Message m = new Message();
        int flag = userService.addUserInfo(user);
        if (flag == 1) {
            m.setCode(110);
            m.setErrorMessage("修改成功");
        } else {
            m.setCode(111);
            m.setErrorMessage("修改失败");
        }
        return m;
    }

    @GetMapping("/addFollow")
    @ResponseBody
    @ApiOperation("新增关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "followId", value = "关注人Id", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 112, message = "新增关注成功"),
            @ApiResponse(code = 113, message = "新增关注失败")
    })
    public Message addFollow(int userId, int followId) {
        Message e = new Message();
        int flag = userService.addFollow(userId, followId);
        if (flag == 1) {
            e.setCode(112);
            e.setErrorMessage("新增关注成功");
        } else {
            e.setCode(113);
            e.setErrorMessage("新增关注失败");
        }
        return e;
    }

    @DeleteMapping("/delFollow")
    @ResponseBody
    @ApiOperation("取消关注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
            @ApiImplicitParam(name = "followId", value = "关注人Id", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 114, message = "取消关注成功"),
            @ApiResponse(code = 115, message = "取消关注失败")
    })
    public Message delFollow(int userId, int followId) {
        Message e = new Message();
        int flag = userService.delFollow(userId, followId);
        if (flag == 1) {
            e.setCode(114);
            e.setErrorMessage("取消关注成功");
        } else {
            e.setCode(115);
            e.setErrorMessage("取消关注失败");
        }
        return e;
    }

    @GetMapping("/findFollow")
    @ResponseBody
    @ApiOperation("查看关注列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
    })
    public List<User> findFollow(int userId) {
        List<User> follow = userService.findFollow(userId);
        return follow;
    }

    @GetMapping("/findFollower")
    @ResponseBody
    @ApiOperation("查看粉丝列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true),
    })
    public List<User> findFollower(int userId) {
        List<User> follower = userService.findFollower(userId);
        return follower;
    }

    @ResponseBody
    @GetMapping("/findUserByPhone")
    @ApiOperation("根据手机号查询用户(返回用户Id)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "手机号", paramType = "query", required = true),
    })
    public User findUserByPhone(String userPhone) {
        return userService.findUserByPhone(userPhone);
    }


       /*@GetMapping("/flag")
    @ApiOperation("查询用户类别，跳转至对应的页面")
    @ApiImplicitParam(name = "userId", value = "用户Id", paramType = "query", required = true)
    @ApiResponses({
            @ApiResponse(code = 108,message = "查询用户类别成功"),
            @ApiResponse(code = 109,message = "查询用户类别失败")
    })
    public Message findFalg(int userId) {
        Message m = new Message();
        User user = new User();
        int flag = userService.findFlag(userId);
        user.setUserFlag(flag);
        if (flag == 1) {
            m.setCode(108);
            m.setErrorMessage("查询用户类别成功");
            m.setObject(user);
        } else if (flag == 2) {
            m.setCode(108);
            m.setErrorMessage("查询用户类别成功");
            m.setObject(user);
        } else if (flag == 3){
            m.setCode(108);
            m.setErrorMessage("查询用户类别成功");
            m.setObject(user);
        }else if(flag == 0){
            m.setCode(108);
            m.setErrorMessage("查询用户类别成功");
            m.setObject(user);
        }else {
            m.setCode(109);
            m.setErrorMessage("查询用户类别失败");
        }
        return m;
    }*/
//        if (flag == 1) {
//            return "redirect:/general/findInfo?userId=" + userId;
//        } else if (flag == 2) {
//            return "redirect:/instructor/findInfo?userId=" + userId;
//        } else{
//            return "redirect:/counselor/findInfo?userId=" + userId;
//        }
}
