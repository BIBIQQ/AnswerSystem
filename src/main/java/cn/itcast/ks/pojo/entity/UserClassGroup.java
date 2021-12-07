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

/**
 * <p>
 * 
 * </p>
 *
 * @author mmff
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_class_group")
public class UserClassGroup extends Model<UserClassGroup> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID（学生）
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 班级ID
     */
    @TableField("class_id")
    private Integer classId;

    /**
     * 小组ID
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * 小组名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 创建时间
     */
    @TableField("created_on")
    private Date createdOn;

    /**
     * 删除标识
     */
    @TableField("is_deleted")
    private String isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
