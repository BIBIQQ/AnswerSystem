package cn.itcast.ks.service.impl;

import cn.itcast.ks.mapper.KsGroupMapper;
import cn.itcast.ks.pojo.entity.KsGroup;
import cn.itcast.ks.service.KsGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:15:52
 */
@Service
public class KsGroupServiceImpl  extends ServiceImpl<KsGroupMapper, KsGroup> implements KsGroupService {
}
