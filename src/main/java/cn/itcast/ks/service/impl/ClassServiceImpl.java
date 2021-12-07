package cn.itcast.ks.service.impl;

import cn.itcast.ks.mapper.ClassMapper;
import cn.itcast.ks.pojo.entity.KsClass;
import cn.itcast.ks.service.IClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mmff
 * @since 2021-05-03
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, KsClass> implements IClassService {

}
