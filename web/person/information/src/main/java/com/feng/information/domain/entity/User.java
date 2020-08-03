package com.feng.information.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "`user`")
public class User {
    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 性别 1男 2女 3保密
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 版本号
     */
    @TableField(value = "version")
    @Version
    private Integer version;

    /**
     * 逻辑删除 0未删除 1删除
     */
    @TableField(value = "is_del")
    @TableLogic
    private Integer isDel;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_NAME = "name";

    public static final String COL_SEX = "sex";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_PHONE = "phone";

    public static final String COL_EMAIL = "email";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_VERSION = "version";

    public static final String COL_IS_DEL = "is_del";
}