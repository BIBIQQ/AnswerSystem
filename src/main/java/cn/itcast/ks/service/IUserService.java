package cn.itcast.ks.service;



import cn.itcast.ks.common.ResponseResult;
import cn.itcast.ks.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mmff
 * @since 2021-05-03
 */
public interface IUserService extends IService<User> {

    /**
     * 通过  班级Id  查询所有的学生
     * @return
     */
    ResponseResult findByClassId();

    /**
     * 增加学生  积分
     * @param user
     * @return
     */
    ResponseResult addIntegral(User user);

    /**
     * 重置分数
     * @param classId
     * @return
     */
    ResponseResult resetGScoreByGroupId(Integer classId);
}
