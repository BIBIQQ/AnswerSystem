package cn.itcast.ks.service;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
import cn.itcast.ks.pojo.dtos.WorkStatisticsDto;
import cn.itcast.ks.pojo.entity.Assignment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:23:21
 */
public interface AssignmentService  extends IService<Assignment> {

    /**
     * 展示所有的练习题
     * @param assignment
     * @return
     */
    ResponseResult showWorks(AssignmentDto assignment);

    /**
     * 上传练习题 作业题
     * @param assignment
     * @return
     */
    ResponseResult publishWork(Assignment assignment);

    /**
     * 未完成统计
     * @param workStatisticsDto
     * @return
     */
    ResponseResult findNotWorkByTime(WorkStatisticsDto workStatisticsDto);

    /**
     * 搜索 用户的 练习
     * @param assignmentDto
     * @return
     */
    ResponseResult findStudentWork(AssignmentDto assignmentDto);

    /**
     * 练习  作业的 提交
     * @param id
     * @param status
     * @return
     */
    ResponseResult submitWork(Integer id, Integer status);
}
