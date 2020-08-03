package com.feng.address.service;

import com.feng.address.domain.dto.AddressDto;
import com.feng.address.domain.vo.AddressVo;
import com.feng.address.exception.ServiceException;

import java.util.List;

public interface AddressService {
    List<AddressVo> findAllAddressByUserId(int page, int size, int userId) throws ServiceException;

    AddressVo findAddressById(int userId) throws ServiceException;

    int addAddress(int userId, AddressDto addressDto) throws ServiceException;

    int modifyAddress(int addressId, AddressDto addressDto) throws ServiceException;

    int removeAddress(int addressId) throws ServiceException;
}
