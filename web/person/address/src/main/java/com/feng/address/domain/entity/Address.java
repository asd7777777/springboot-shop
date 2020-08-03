package com.feng.address.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "address")
public class Address {
    /**
     * 地址主键
     */
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 收件人姓名
     */
    @TableField(value = "addressee_name")
    private String addresseeName;

    @TableField(value = "phone")
    private String phone;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @TableField(value = "area")
    private String area;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 是否删除 0未删除 1删除
     */
    @TableField(value = "is_del")
    @TableLogic
    private Integer isDel;

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

    public static final String COL_ADDRESS_ID = "address_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ADDRESSEE_NAME = "addressee_name";

    public static final String COL_PHONE = "phone";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY = "city";

    public static final String COL_AREA = "area";

    public static final String COL_ADDRESS = "address";

    public static final String COL_IS_DEL = "is_del";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}