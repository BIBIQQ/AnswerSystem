package cn.itcast.ks.pojo.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    @ExcelProperty("姓名")
    private String name;

    /**
     * 手机号（账户）
     */
    @ExcelProperty("学号")//读取excel需要，把学号作为学生的手机号
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 状态（有效，无效，休学）
     */
    private String status;

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

    /**
     * 1.老师 2.学生
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Integer classId;

    /**
     * 小组id
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * 小组名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 学生积分
     */
    private Integer integral;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }



}
