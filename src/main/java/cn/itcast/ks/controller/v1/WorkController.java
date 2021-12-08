package cn.itcast.ks.controller.v1;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
import cn.itcast.ks.pojo.dtos.WorkStatisticsDto;
import cn.itcast.ks.pojo.entity.Assignment;
import cn.itcast.ks.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:23:17
 */

@RestController
@RequestMapping("/v1/work")
public class WorkController {

    @Autowired
    private AssignmentService assignmentService;


    /**
     * 展示 所有的练习题
     *
     * @param assignment
     * @return
     */
    @PostMapping("/showWorks")
    public ResponseResult showWorks(@RequestBody AssignmentDto assignment) {
        ResponseResult result = assignmentService.showWorks(assignment);
        return result;
    }

    /**
     * 发布联系 作业
     *
     * @param assignment
     * @return
     */
    @PostMapping("/publishWork")
    public ResponseResult publishWork(@RequestBody Assignment assignment) {
        ResponseResult result = assignmentService.publishWork(assignment);
        return result;
    }

    /**
     * 未完成统计
     *
     * @param workStatisticsDto
     * @return
     */
    @PostMapping("/findNotWorkByTime")
    public ResponseResult findNotWorkByTime(@RequestBody WorkStatisticsDto workStatisticsDto) {
        ResponseResult result = assignmentService.findNotWorkByTime(workStatisticsDto);
        return result;
    }

    /**
     * 查询学生的 完成作业
     *
     * @param assignmentDto
     * @return
     */
    @PostMapping("/findStudentWork")
    public ResponseResult findStudentWork(@RequestBody AssignmentDto assignmentDto) {
        ResponseResult result = assignmentService.findStudentWork(assignmentDto);
        return result;
    }

    /**
     * 练习  作业的提交
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/submitWork/{id}/{status}")
    public ResponseResult submitWork(@PathVariable Integer id,@PathVariable Integer status){
       ResponseResult result  = assignmentService.submitWork(id,status);
        return result;
    }
}
