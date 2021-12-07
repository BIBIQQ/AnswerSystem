package cn.itcast.ks.common.threadlocal;


import cn.itcast.ks.pojo.entity.User;

/**
 * 用户线程绑定对象
 */
public class UserThreadLocalUtils {

    private final  static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(User user){
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static User getUser( ){
        return userThreadLocal.get();
    }

}
