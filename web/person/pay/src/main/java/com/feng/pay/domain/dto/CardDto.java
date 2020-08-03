package com.feng.pay.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class CardDto {
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
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;
}
