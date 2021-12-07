package cn.itcast.ks.pojo.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author FF
 * @date 2021/12/6
 * @TIME:9:14
 */
@Data
public class AssignmentVo implements Serializable {

    private Integer uid;
    private String name;
    private List<practiceList> practiceList;
}
