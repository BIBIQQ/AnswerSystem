package cn.itcast.ks.service.impl;

import cn.itcast.ks.common.AppHttpCodeEnum;
import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.common.threadlocal.UserThreadLocalUtils;
import cn.itcast.ks.mapper.UserMapper;
import cn.itcast.ks.pojo.dtos.UserClassGroupdVo;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.pojo.entity.UserClassGroup;
import cn.itcast.ks.service.IUserService;
import cn.itcast.ks.service.UserClassGroupService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mmff
 * @since 2021-05-03
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过班级信息，搜索  所有学生
     *
     * @return
     */
    @Override
    public ResponseResult findByClassId() {
        // 获取  线程中 登录的 用户信息
        User user = UserThreadLocalUtils.getUser();
        // 获取登录班级id
        Integer classId = user.getClassId();
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        // 搜索缓存中存储的 信息
        List findByClassId = redisTemplate.opsForList().range("v1:user:"+classId+":list", 0, -1);
        // 判断存储的是否为  null  不为null 就  取出  为null 就从 数据库搜索
        if (findByClassId.size() > 0 && findByClassId != null) {
            log.info("从Redis获取数据");
            return ResponseResult.okResult(findByClassId);
        }
        //  搜索 该班级   并且  是学生的信息的集合信息
        List<User> listByClassId = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getClassId, classId).eq(User::getRoleId, "2"));
        //  存储总分和学生信息的  深克隆
        List<UserClassGroupdVo> usgList = JSON.parseArray(JSON.toJSONString(listByClassId), UserClassGroupdVo.class);
        // 搜索 小组 id  并存储
        // 根据小组id  获取学生
        // 赋值
        for (UserClassGroupdVo userClassGroupdVo : usgList) {
            Integer groupId = userClassGroupdVo.getGroupId();
            Integer integral = userMapper.findlAllGroupIntegral(groupId);
            userClassGroupdVo.setGroupsIntegral(integral);
        }
        // 设置 总分
        for (UserClassGroupdVo user1 : usgList) {
            // 存储到  Redis中
            redisTemplate.opsForList().leftPush("v1:user:"+classId+":list", user1);
        }
        log.info("从Mysql获取数据");
        //返回
        return ResponseResult.okResult(usgList);
    }

    /**
     * 增加  学生积分
     *
     * @param user
     * @return
     */
    @Override
    public ResponseResult addIntegral(User user) {
        // 获取  线程中 登录的 用户信息
        User userT = UserThreadLocalUtils.getUser();
        // 获取登录班级id
        Integer classId = userT.getClassId();
        // 清空   Redis 缓存    保持同步
        redisTemplate.delete("v1:user:"+classId+":list");
        //  获取 用户信息
        Integer id = user.getId();
        Integer integral = user.getIntegral();
        // 搜索该学生的信息
        User userbyId = userMapper.selectById(id);
        // 配置分数
        userbyId.setIntegral(userbyId.getIntegral() + integral);
        // 修改分数
        userMapper.updateById(userbyId);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult resetGScoreByGroupId(Integer classId) {
        // 清空缓存
        redisTemplate.delete("v1:user:"+classId+":list");
        // 清空分数
        // 获取学生对象
        List<User> listByClassId = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getClassId, classId).eq(User::getRoleId, "2"));
        // 修改分数
        for (User user : listByClassId) {
            user.setIntegral(0);
            userMapper.updateById(user);
        }

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
