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
@TableName("ks_config")
public class KsConfig extends Model<KsConfig> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID （老师）
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 1.未开始 2.开始 3.抢答结束
     */
    @TableField("begin_question")
    private Integer beginQuestion;

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


    @TableField("class_id")
    private Integer classId;

    @TableField("student_name")
    private String studentName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
