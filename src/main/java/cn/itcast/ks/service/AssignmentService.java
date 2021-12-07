package cn.itcast.ks.service;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
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
}
