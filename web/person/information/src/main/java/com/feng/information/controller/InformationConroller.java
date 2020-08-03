package com.feng.information.controller;

import com.feng.information.common.RespEntity;
import com.feng.information.domain.dto.UserDto;
import com.feng.information.exception.ServiceException;
import com.feng.information.service.InformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api("个人信息")
@RestController
@RequestMapping("/information")
@Validated
public class InformationConroller {
    @Resource
    InformationService informationService;

    @ApiOperation("用户信息查询")
    @GetMapping("/profile")
    public RespEntity<UserDto> profile(@ApiParam("用户id") int userId) throws ServiceException {
        UserDto userDto = informationService.findUserById(userId);
        return RespEntity.success(userDto);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/profile")
    public RespEntity<Integer> profileUpdate(@ApiParam("用户信息") @Valid @RequestBody UserDto userDto) throws ServiceException {
        int i = informationService.updateProfile(userDto);
        return RespEntity.success(i);
    }

}
