package com.feng.information.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel("用户信息请求参数")
public class UserDto {
    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    @Pattern(regexp = "[a-zA-Z]\\w{7,15}", message = "昵称错误")
    private String nickname;

    /**
     * 姓名
     */
    @ApiModelProperty("用户姓名")
    @Pattern(regexp = "[a-zA-Z]\\w{7,15}", message = "姓名错误")
    private String name;

    /**
     * 性别 1男 2女 3保密
     */
    @ApiModelProperty("性别 1男 2女 3保密")
    @Pattern(regexp = "[1-3]", message = "请选择1-3")
    private Integer sex;

    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    @Pattern(regexp = "\\d{11}", message = "手机号码输入错误")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @Email
    private String email;
}
