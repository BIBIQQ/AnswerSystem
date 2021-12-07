package cn.itcast.ks.pojo.dtos;

import cn.itcast.ks.pojo.entity.Assignment;
import cn.itcast.ks.pojo.entity.UserStudentAssignment;
import lombok.Data;

import java.util.Date;

/**
 * @author FF
 * @date 2021/12/5
 * @TIME:23:27
 */
@Data
public class AssignmentDto extends UserStudentAssignment {

    private Date time;
    private Integer type;

}
