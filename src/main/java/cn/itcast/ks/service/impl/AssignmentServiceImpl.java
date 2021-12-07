package cn.itcast.ks.service.impl;

import cn.itcast.ks.common.AppHttpCodeEnum;
import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.common.threadlocal.UserThreadLocalUtils;
import cn.itcast.ks.mapper.AssignmentMapper;
import cn.itcast.ks.pojo.Vo.AssignmentVo;
import cn.itcast.ks.pojo.Vo.practiceList;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
import cn.itcast.ks.pojo.entity.Assignment;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.pojo.entity.UserStudentAssignment;
import cn.itcast.ks.service.AssignmentService;
import cn.itcast.ks.service.IUserService;
import cn.itcast.ks.service.UserStudentAssignmentService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:23:21
 */
@Service
public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment> implements AssignmentService {

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private UserStudentAssignmentService userStudentAssignmentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserService iUserService;

    @Override
    public ResponseResult showWorks(AssignmentDto assignment) {
        // 获取参数
        int type = assignment.getType();
        Date time = assignment.getTime();
        String creatOn = null;
        if (time != null) {
            // 转换date 为  String
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            creatOn = simpleDateFormat.format(time);
        }

        // 获取线程 中的用户信息
        User user = UserThreadLocalUtils.getUser();
        // 获取登录的 老师  id
        Integer userId = user.getId();
        // 获取缓存中的  信息   Key  =  老师id  + 类型
        List assignmentByRedis = redisTemplate.opsForList().range("v1:work:" + userId + ":list", 0, -1);
        // 判断缓存中的信息  是否是null
        if (assignmentByRedis.size() > 0 && assignmentByRedis != null) {
            return ResponseResult.okResult(assignmentByRedis);
        }


        // 如果为null  从数据库中获取
        // 通过教师id 和 类型 和 时间  获取  该 任务 数据
        LambdaQueryWrapper<UserStudentAssignment> alqw = new LambdaQueryWrapper<>();
        alqw.eq(UserStudentAssignment::getAssignmentType, type).eq(creatOn != null, UserStudentAssignment::getCreatedOn, creatOn);
        // 获取了所有的  任务  信息
        List<UserStudentAssignment> userStudentAssignments = userStudentAssignmentService.list(alqw);
        if (userStudentAssignments.size() < 0) {
            return ResponseResult.okResult(0, creatOn + "没有上传");
        }
        // 获取 user_id
        Set<Integer> set = new HashSet<Integer>();
        for (UserStudentAssignment studentAssignment : userStudentAssignments) {
            set.add(studentAssignment.getUserId());
        }
        // 创建 AssignmentVo集合
        List<AssignmentVo> assignmentVoList = new ArrayList<>();

        // 获取该属任务的 通过 user_id  获取 对应的 List<practiceList>
        for (Integer setuserId : set) {
            // 创建 AssignmentVo 对象
            AssignmentVo assignmentVo = new AssignmentVo();
            // 用户 对应的  包含的任务
            LambdaQueryWrapper<UserStudentAssignment> usqlwq =  new LambdaQueryWrapper<>();
            usqlwq.eq(UserStudentAssignment::getAssignmentType,type).eq(UserStudentAssignment::getUserId, setuserId);
            List<UserStudentAssignment> usalist = userStudentAssignmentService.list(usqlwq);
            // 创建  practiceList集合
            List<practiceList> collect = usalist.stream().map(c -> {
                practiceList practiceList = new practiceList();
                practiceList.setId(c.getAssignmentId());
                practiceList.setIsComplete(c.getStatus());
                practiceList.setWorkname(c.getAssignmentName());
                return practiceList;
            }).collect(Collectors.toList());
            // 搜索该 id的对象
            User byId = iUserService.getById(setuserId);
            // 赋值  id  和名称
            assignmentVo.setName(byId.getName());
            assignmentVo.setUid(setuserId);
            // 赋值该对象的  联系
            assignmentVo.setPracticeList(collect);
            // AssignmentVo集合 添加
            assignmentVoList.add(assignmentVo);

        }

        // 返回值
        return ResponseResult.okResult(assignmentVoList);
    }
}
