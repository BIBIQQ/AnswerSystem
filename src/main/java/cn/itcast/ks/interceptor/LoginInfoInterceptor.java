package cn.itcast.ks.interceptor;

import cn.itcast.ks.common.threadlocal.UserThreadLocalUtils;
import cn.itcast.ks.common.utils.AppJwtUtil;
import cn.itcast.ks.pojo.entity.User;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 登录拦截器 此类用于拦截登录请求  无需更改
 */
@Component
public class LoginInfoInterceptor implements HandlerInterceptor {
    //线程绑定对象，用于获取用户信息
    private UserThreadLocalUtils userThreadLocalUtils = new UserThreadLocalUtils();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //3.获取当前用户的请求头jwt信息
        String jwtToken = request.getHeader("token");

        //4.判断当前令牌是否存在
        if(StringUtils.isEmpty(jwtToken)){
            return true;
        }
        try {
            //5.如果令牌存在，解析jwt令牌，判断该令牌是否合法，如果不合法，则向客户端返回错误信息
            Claims claims = AppJwtUtil.getClaimsBody(jwtToken);
            int result = AppJwtUtil.verifyToken(claims);
            if(result == 0 || result == -1){
                //如果用户令牌合法代表已经登录成功，把用户登录信息存储到线程绑定对象中
                String json = (String) claims.get("userinfo");
                User user = JSON.parseObject(json, User.class);
                userThreadLocalUtils.setUser(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            //想客户端返回错误提示信息
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
