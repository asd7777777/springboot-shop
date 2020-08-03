package com.feng.address.controller;

import com.feng.address.common.RespEntity;
import com.feng.address.domain.dto.AddressDto;
import com.feng.address.domain.vo.AddressVo;
import com.feng.address.exception.ServiceException;
import com.feng.address.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api("地址管理")
@RestController
@RequestMapping("/address")
@Validated
public class AddressController {
    @Resource
    AddressService addressService;

    @ApiOperation("根据用户id分页查询所有地址")
    @GetMapping("/list")
    public RespEntity<List<AddressVo>> list(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "3") int size, int userId) throws ServiceException {
        List<AddressVo> addressVoList = addressService.findAllAddressByUserId(page, size, userId);
        return RespEntity.success(addressVoList);
    }

    @ApiOperation("根据地址id查询地址信息")
    @GetMapping("/address")
    public RespEntity<AddressVo> address(int addressId) throws ServiceException {
        AddressVo addressVo = addressService.findAddressById(addressId);
        return RespEntity.success(addressVo);
    }

    @ApiOperation("添加用户的地址信息")
    @PostMapping("/address")
    public RespEntity<Integer> address(int userId,@RequestBody AddressDto addressDto) throws ServiceException {
        int i = addressService.addAddress(userId, addressDto);
        return RespEntity.success(i);
    }

    @ApiOperation("更新地址信息")
    @PostMapping("/addressUpdate")
    public RespEntity<Integer> addressUpdate(int addressId, @Valid @RequestBody AddressDto addressDto) throws ServiceException {
        int i = addressService.modifyAddress(addressId, addressDto);
        return RespEntity.success(i);
    }

    @ApiOperation("删除地址")
    @PostMapping("/addressDelete")
    public RespEntity<Integer> addressDelete(int addressId) throws ServiceException {
        int i = addressService.removeAddress(addressId);
        return RespEntity.success(i);
    }
}
