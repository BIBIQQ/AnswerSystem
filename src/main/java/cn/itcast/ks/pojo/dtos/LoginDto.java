package cn.itcast.ks.pojo.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    @ApiModelProperty(value = "登录用户名")
    private String name;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "登录班级")
    private Integer classId;

}
