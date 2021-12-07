package cn.itcast.ks.mapper;


import cn.itcast.ks.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mmff
 * @since 2021-05-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT SUM(integral) FROM  user WHERE group_id=#{id}")
    Integer findlAllGroupIntegral(Integer id);
}
