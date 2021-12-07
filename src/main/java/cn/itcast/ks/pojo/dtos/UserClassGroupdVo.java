package cn.itcast.ks.pojo.dtos;

import cn.itcast.ks.pojo.entity.KsGroup;
import cn.itcast.ks.pojo.entity.User;
import cn.itcast.ks.pojo.entity.UserClassGroup;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:15:31
 */
@Data
public class UserClassGroupdVo extends User{

    private Integer groupsIntegral;



}
