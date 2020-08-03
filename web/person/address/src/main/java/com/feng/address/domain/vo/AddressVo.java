package com.feng.address.domain.vo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class AddressVo {
    /**
     * 收件人姓名
     */
    @ApiParam("收件人姓名")
    private String addresseeName;

    @ApiParam("手机号码")
    private String phone;

    /**
     * 省
     */
    @ApiParam("省")
    private String province;

    /**
     * 市
     */
    @ApiParam("市")
    private String city;

    /**
     * 区
     */
    @ApiParam("区")
    private String area;

    /**
     * 详细地址
     */
    @ApiParam("详细地址")
    private String address;
}
