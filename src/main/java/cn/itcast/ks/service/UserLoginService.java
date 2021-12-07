package cn.itcast.ks.service;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.LoginDto;

public interface UserLoginService {

    /**
     * 用户选择成功后    用户登录验证  跳转
     * 如果是学生 就跳转学生界面
     * 如果是教室  就跳转 教师界面
     * @param loginDto
     * @return
     */
    public ResponseResult login(LoginDto loginDto);

    /**
     * 判断登录的手机号  是学生还是教室的，教室的即增加 班级选择框
     * @param mobile
     * @return
     */
    ResponseResult findRoleByName(String mobile);
}
