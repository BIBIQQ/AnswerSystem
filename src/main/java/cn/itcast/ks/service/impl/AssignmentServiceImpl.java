package cn.itcast.ks.service.impl;

import cn.itcast.ks.common.AppHttpCodeEnum;
import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.common.threadlocal.UserThreadLocalUtils;
import cn.itcast.ks.mapper.AssignmentMapper;
import cn.itcast.ks.pojo.Vo.AssignmentVo;
import cn.itcast.ks.pojo.Vo.WorkStatisticsVo;
import cn.itcast.ks.pojo.Vo.practiceList;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
import cn.itcast.ks.pojo.dtos.WorkStatisticsDto;
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

    /**
     * 展示练习 和 作业
     *
     * @param assignment
     * @return
     */
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
            LambdaQueryWrapper<UserStudentAssignment> usqlwq = new LambdaQueryWrapper<>();
            usqlwq.eq(UserStudentAssignment::getAssignmentType, type).eq(UserStudentAssignment::getUserId, setuserId).eq(creatOn != null, UserStudentAssignment::getCreatedOn, creatOn);
            ;
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

    /**
     * 上传 练习题 和 作业
     *
     * @param assignment
     * @return
     */
    @Override
    public ResponseResult publishWork(Assignment assignment) {
        //获取线程里  登录的用户user
        User user = UserThreadLocalUtils.getUser();
        // 获取 用户Id
        Integer userId = user.getId();
        // 赋值
        assignment.setUserId(userId);
        // 存储 老师发布的 任务
        this.save(assignment);
        //  获得改 老师登录的班级
        Integer classId = user.getClassId();
        // 通过班级id获取 班级学生id
        List<User> list = iUserService.list(Wrappers.<User>lambdaQuery().eq(User::getClassId, classId).eq(User::getRoleId, 2));
        // 赋值 id
        for (User user1 : list) {
            // 创建 UserStudentAssignment 对象
            UserStudentAssignment studentAssignment = new UserStudentAssignment();
            // 赋值
            studentAssignment.setAssignmentId(assignment.getId());
            studentAssignment.setAssignmentName(assignment.getName());
            studentAssignment.setAssignmentType(assignment.getType());
            studentAssignment.setCreatedOn(assignment.getCreatedOn());
            studentAssignment.setStatus(1);
            studentAssignment.setUserId(user1.getId());
            // 存储  学生 和 任务题
            userStudentAssignmentService.save(studentAssignment);
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 搜索时间内完成的数量
     * @param workStatisticsDto
     * @return
     */
    @Override
    public ResponseResult findNotWorkByTime(WorkStatisticsDto workStatisticsDto) {
        // 转换 Date类型 String
        Date sTime = workStatisticsDto.getStartTime();
        Date eTime = workStatisticsDto.getEndTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = simpleDateFormat.format(sTime);
        String endTime = simpleDateFormat.format(eTime);
        // 通过班级id 获取 班级学生
        List<User> userList = iUserService.list(Wrappers.<User>lambdaQuery().eq(User::getClassId, workStatisticsDto.getClassId()).eq(User::getRoleId,2));
        if(userList.size()<0){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        // 通过用户id  搜索任务的未完成度
        List<WorkStatisticsVo> collect = userList.stream().map(user -> {
            // 创建 WorkStatisticsVo 对象
            WorkStatisticsVo workStatisticsVo = new WorkStatisticsVo();
            // 赋值
            workStatisticsVo.setName(user.getName());
            workStatisticsVo.setUserId(user.getId());
            // 获得 未完成任务列表
            LambdaQueryWrapper<UserStudentAssignment> usalqw = new LambdaQueryWrapper<>();
            usalqw.eq(UserStudentAssignment::getUserId, user.getId());
            usalqw.eq(UserStudentAssignment::getAssignmentType, workStatisticsDto.getType());
            // 未完成筛选
            usalqw.eq(UserStudentAssignment::getStatus, 1);
            usalqw.between(UserStudentAssignment::getCreatedOn, startTime, endTime);
            // 用户未完成的数量
            int count = userStudentAssignmentService.count(usalqw);
            // 赋值 数量
            workStatisticsVo.setCount(count);
            return workStatisticsVo;
        }).collect(Collectors.toList());
        // 返回
        return ResponseResult.okResult(collect);
    }

    /**
     * 搜索 该用户的未完成作业
     * @param assignmentDto
     * @return
     */
    @Override
    public ResponseResult findStudentWork(AssignmentDto assignmentDto) {
        //  获取登录学生的对象
        User user = UserThreadLocalUtils.getUser();
        // 获取id
        Integer userId = user.getId();
        // 转换时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(assignmentDto.getTime());
        // 通过时间  类型  id  条件搜索
        LambdaQueryWrapper<UserStudentAssignment> usalwq = new LambdaQueryWrapper<>();
        usalwq.eq(UserStudentAssignment::getCreatedOn,time);
        usalwq.eq(UserStudentAssignment::getUserId,userId);
        usalwq.eq(UserStudentAssignment::getAssignmentType,assignmentDto.getType());
        // 获取
        List<UserStudentAssignment> list = userStudentAssignmentService.list(usalwq);
        // 转成 practiceList
        List<practiceList> collect = list.stream().map(c -> {
            practiceList practiceList = new practiceList();
            practiceList.setId(c.getId());
            practiceList.setWorkname(c.getAssignmentName());
            practiceList.setIsComplete(c.getStatus());
            return practiceList;
        }).collect(Collectors.toList());
        // 创建 AssignmentVo 对象
        AssignmentVo assignmentVo = new AssignmentVo();
        assignmentVo.setUid(userId);
        assignmentVo.setName(user.getName());
        assignmentVo.setPracticeList(collect);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(assignmentVo);
        // 返回
        return ResponseResult.okResult(objects);
    }

    /**
     * 练习  作业的 提交
     * @param id
     * @param status
     * @return
     */
    @Override
    public ResponseResult submitWork(Integer id, Integer status) {
        if(id == null || status== null ){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        UserStudentAssignment studentAssignment = new UserStudentAssignment();
        studentAssignment.setId(id);
        studentAssignment.setStatus(status);
        // 修改 作业  状态
        userStudentAssignmentService.updateById(studentAssignment);
        // 反馈结果
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
