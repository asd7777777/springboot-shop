package com.feng.pay.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class CardVo {
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
     * 是否开通快捷支付 0未开通 1已开通
     */
    @TableField(value = "quick_pay")
    private Integer quickPay;

    /**
     * 银行卡类型 1储蓄卡 2信用卡
     */
    @TableField(value = "card_type")
    private Integer cardType;
}
