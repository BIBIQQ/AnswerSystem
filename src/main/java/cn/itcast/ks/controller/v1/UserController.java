package cn.itcast.ks.controller.v1;

import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.common.threadlocal.UserThreadLocalUtils;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:11:09
 */

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 显示登录教师的 班级学生 和小组
     *
     * @return
     */
    @GetMapping("/findByClassId")
    public ResponseResult findByClassId() {
        ResponseResult result = iUserService.findByClassId();
        return result;
    }

    /**
     * 增加删减分数
     *
     * @param user
     * @return
     */
    @PostMapping("/addIntegral")
    public ResponseResult addIntegral(@RequestBody User user) {
        ResponseResult result = iUserService.addIntegral(user);
        return result;
    }

    /**
     * 重置分数
     * @param classId
     * @return
     */
    @GetMapping("/resetGScoreByGroupId/{classId}")
    public ResponseResult resetGScoreByGroupId(@PathVariable Integer classId) {
        ResponseResult result = iUserService.resetGScoreByGroupId(classId);
        return result;
    }
}
