package cn.itcast.ks.controller.v1;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.LoginDto;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginController {
    @Autowired
    private UserLoginService userLoginService;

    //登录请求
    @RequestMapping(value = "/in" ,method = RequestMethod.POST)
    public ResponseResult login(@RequestBody LoginDto loginDto){
        return userLoginService.login(loginDto);
    }


    /**
     * 用户登录账户判断，如果是学生账号，返回任意值
     * 如果是老师账号，返回班级列表
     * @param mobile
     * @return
     */
    @GetMapping("/{mobile}")
    public ResponseResult findRoleByName(@PathVariable("mobile") String mobile) {
        return userLoginService.findRoleByName(mobile);
    }

}
