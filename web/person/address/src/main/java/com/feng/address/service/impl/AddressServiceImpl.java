package com.feng.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.feng.address.common.RespCode;
import com.feng.address.domain.dto.AddressDto;
import com.feng.address.domain.entity.Address;
import com.feng.address.domain.vo.AddressVo;
import com.feng.address.exception.ServiceException;
import com.feng.address.mapper.AddressMapper;
import com.feng.address.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    @Override
    public List<AddressVo> findAllAddressByUserId(int page, int size, int userId) throws ServiceException {
        List<AddressVo> addressVoList = new ArrayList<>();

        //查询该用户存储的地址
        QueryWrapper<Address> queryWrapper = new QueryWrapper<Address>().eq("is_del", 0).eq("user_id", userId);
        IPage<Address> addressPage = addressMapper.selectPage(new Page<>(page, size), queryWrapper);

        //将查询到的地址信息复制到addressVoList中
        if (addressPage != null) {
            List<Address> records = addressPage.getRecords();
            records.forEach(address -> {
                AddressVo addressVo = new AddressVo();
                BeanUtils.copyProperties(address, addressVo);
                addressVoList.add(addressVo);
            });
        } else {
            throw new ServiceException(RespCode.NO_ADDRESS);
        }
        return addressVoList;
    }

    @Override
    public AddressVo findAddressById(int addressId) throws ServiceException {
        AddressVo addressVo = null;

        //根据地址id查询具体的某一个地址信息
        Address address = addressMapper.selectById(addressId);

        //若查询成功，将地址信息赋值到addressVO中
        if (address != null) {
            addressVo = new AddressVo();
            BeanUtils.copyProperties(address, addressVo);
        } else {
            throw new ServiceException(RespCode.NO_THIS_ADDRESS);
        }
        return addressVo;
    }

    @Override
    public int addAddress(int userId, AddressDto addressDto) throws ServiceException {
        Address address = new Address();
        address.setUserId(userId);
        BeanUtils.copyProperties(addressDto, address);
        int i = addressMapper.insert(address);
        if (i == 0) {
            throw new ServiceException(RespCode.BUSINESS_UNKNOW_ERROR);
        }
        return i;
    }

    @Override
    public int modifyAddress(int addressId, AddressDto addressDto) throws ServiceException {
        int i = 0;
        //根据id查询地址信息
        Address address = addressMapper.selectById(addressId);

        //查询到地址信息，则修改地址信息
        if (address != null) {
            BeanUtils.copyProperties(addressDto, address);
            i = addressMapper.updateById(address);
            if (i == 0) {
                throw new ServiceException(RespCode.BUSINESS_UNKNOW_ERROR);
            }
        } else {
            throw new ServiceException(RespCode.NO_THIS_ADDRESS);
        }
        return i;
    }

    @Override
    public int removeAddress(int addressId) throws ServiceException {
        int i = 0;
        //根据id查询地址信息
        Address address = addressMapper.selectById(addressId);

        //查询到地址信息，则修改is_del字段为1
        if (address != null) {
            i = addressMapper.deleteById(addressId);
            if (i == 0) {
                throw new ServiceException(RespCode.BUSINESS_UNKNOW_ERROR);
            }
        } else {
            throw new ServiceException(RespCode.NO_THIS_ADDRESS);
        }
        return i;
    }


}
