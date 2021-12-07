package cn.itcast.ks.controller.v1;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.dtos.AssignmentDto;
import cn.itcast.ks.pojo.entity.Assignment;
import cn.itcast.ks.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param assignment
     * @return
     */
    @PostMapping("/showWorks")
    public ResponseResult showWorks(@RequestBody AssignmentDto assignment){
        ResponseResult result  =  assignmentService.showWorks(assignment);
        return result;
    }
}
