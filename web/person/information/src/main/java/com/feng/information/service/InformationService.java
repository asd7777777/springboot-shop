package com.feng.information.service;

import com.feng.information.domain.dto.UserDto;
import com.feng.information.domain.entity.User;
import com.feng.information.exception.ServiceException;

public interface InformationService {
    UserDto findUserById(int userId) throws ServiceException;

    int updateProfile(UserDto userDto) throws ServiceException;

}
