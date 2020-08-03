package com.feng.address.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Data
@ApiModel("地址参数")
@Validated
public class AddressDto {
    /**
     * 收件人姓名
     */
    @ApiParam("收件人姓名")
    private String addresseeName;

    @ApiParam("手机号码")
    @Pattern(regexp = "\\d{11}", message = "手机号码输入错误")
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
