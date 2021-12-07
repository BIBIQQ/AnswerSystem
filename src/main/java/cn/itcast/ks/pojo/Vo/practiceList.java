package cn.itcast.ks.pojo.Vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * @author FF
 * @date 2021/12/6
 * @TIME:9:16
 */
@Data
public class practiceList implements Serializable {
    private Integer id;
    // 练习名字
    private String workname;
    // 完成状况
    private Integer isComplete;
}
