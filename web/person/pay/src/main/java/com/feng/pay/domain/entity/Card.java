package com.feng.pay.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "card")
public class Card {
    /**
     * 银行卡表主键
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 身份证号码
     */
    @TableField(value = "identity_id")
    private Long identityId;

    /**
     * 银行卡号码
     */
    @TableField(value = "bank_card_id")
    private Long bankCardId;

    /**
     * 银行名字
     */
    @TableField(value = "bank_name")
    private String bankName;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 是否开通快捷支付 0未开通 1已开通
     */
    @TableField(value = "quick_pay")
    private Integer quickPay;

    /**
     * 银行卡类型 1储蓄卡 2信用卡
     */
    @TableField(value = "card_type")
    private Integer cardType;

    /**
     * 是否删除 0未删除 1删除
     */
    @TableField(value = "id_del")
    private Integer idDel;

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

    public static final String COL_CID = "cid";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_REAL_NAME = "real_name";

    public static final String COL_IDENTITY_ID = "identity_id";

    public static final String COL_BANK_CARD_ID = "bank_card_id";

    public static final String COL_BANK_NAME = "bank_name";

    public static final String COL_PHONE = "phone";

    public static final String COL_QUICK_PAY = "quick_pay";

    public static final String COL_CARD_TYPE = "card_type";

    public static final String COL_ID_DEL = "id_del";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}