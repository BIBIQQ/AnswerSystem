package cn.itcast.ks.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ks_group")
public class KsGroup extends Model<KsClass> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("group_name")
    private String groupName;

    @TableField("class_id")
    private Integer classId;

    @TableField("created_on")
    private Date createdOn;

    @TableField("is_deleted")
    private String isDeleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
