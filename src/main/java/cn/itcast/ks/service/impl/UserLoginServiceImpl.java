package cn.itcast.ks.service.impl;

import cn.itcast.ks.common.AppHttpCodeEnum;
import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.common.utils.AppJwtUtil;
import cn.itcast.ks.mapper.UserMapper;
import cn.itcast.ks.pojo.entity.KsClass;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.service.IClassService;
import cn.itcast.ks.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.itcast.ks.pojo.dtos.LoginDto;
import cn.itcast.ks.service.UserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletResponse httpServletResponse;


    @Autowired
    private IClassService classService;

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(LoginDto dto) {
        //1.检查参数
        if (StringUtils.isEmpty(dto.getName()) || StringUtils.isEmpty(dto.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户名或密码错误");
        }

        //2.查询数据库中的用户信息 根据用户名查询用户集合信息
        List<User> list = userService.list(Wrappers.<User>lambdaQuery().eq(User::getMobile, dto.getName()));
        //参数校验，用户是否存在
        if(list != null && list.size() ==1){
            //获取用户
            User adUser = list.get(0);
            //3.比对密码  密码校验  密码采用MD5加密
            String pswd = DigestUtils.md5DigestAsHex((dto.getPassword()+adUser.getSalt()).getBytes());
            if(adUser.getPassword().equals(pswd)){//进行密码对比
                //如果用户请求参数中存在班级ID，代表该用户是老师。
                if(dto.getClassId() != null){
                    //如果是老师 动态修改老师所在的班级
                    log.info(adUser.getName() + "登录"+dto.getClassId() +"班级");
                    adUser.setClassId(dto.getClassId());
                    //动态修改老师班级
                    userService.updateById(adUser);
                }
                //返回值清空密码
                adUser.setPassword("");
                adUser.setSalt("");
                //生成令牌， 代码无需查看 。
                String token = AppJwtUtil.getToken(JSON.toJSONString(adUser));
                //存储用户的header中
                httpServletResponse.setHeader("token",token);
                return ResponseResult.okResult(token);
            }else {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在");
        }
    }

    /**
     * 搜索 用户的 权限
     * @param mobile
     * @return
     */
    @Override
    public ResponseResult findRoleByName(String mobile) {
        //1.检查参数
        if (mobile ==null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户名或密码错误");
        }
        //2.查询数据库中的用户信息
        List<User> list = userService.list(Wrappers.<User>lambdaQuery().eq(User::getMobile, mobile));
        if(list != null && list.size() ==1){
            //  获取 用户
            User adUser = list.get(0);
            // 判断 登录的 用户的权限  是  学生还是  老师
            if(adUser.getRoleId() == 1){
                // 如果是  教师  ， 搜索班级信息   返回  班级的 信息
                List<KsClass> list1 = classService.list();
                return ResponseResult.okResult(list1);
            }else {
                //  如果 是  学生   返回  “学生账户”  的标识
                return ResponseResult.okResult("学生账户");
            }
        }else {
            //  未搜索到  用户信息
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户不存在");
        }
    }

}
