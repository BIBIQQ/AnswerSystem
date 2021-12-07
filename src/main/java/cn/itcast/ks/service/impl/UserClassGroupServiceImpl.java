package cn.itcast.ks.service.impl;

import cn.itcast.ks.mapper.UserClassGroupMapper;
import cn.itcast.ks.pojo.entity.UserClassGroup;
import cn.itcast.ks.service.UserClassGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:15:56
 */
@Service
public class UserClassGroupServiceImpl  extends ServiceImpl<UserClassGroupMapper, UserClassGroup> implements UserClassGroupService {
}
