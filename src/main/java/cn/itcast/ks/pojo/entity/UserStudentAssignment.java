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
@TableName("user_student_assignment")
public class UserStudentAssignment extends Model<UserStudentAssignment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID（学生）
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 任务ID
     */
    @TableField("assignment_id")
    private Integer assignmentId;

    /**
     * 任务名称
     */
    @TableField("assignment_name")
    private String assignmentName;

    /**
     * 任务类型 1作业  2 练习题
     */
    @TableField("assignment_type")
    private Integer assignmentType;

    /**
     * 任务状态 1 未完成 2 已完成
     */
    private Integer status;

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
