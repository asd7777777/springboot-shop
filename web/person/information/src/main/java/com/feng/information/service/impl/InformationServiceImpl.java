package com.feng.information.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.feng.information.common.RespCode;
import com.feng.information.domain.dto.UserDto;
import com.feng.information.domain.entity.User;
import com.feng.information.exception.ServiceException;
import com.feng.information.mapper.UserMapper;
import com.feng.information.service.InformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;

@Service
public class InformationServiceImpl implements InformationService {
    @Resource
    UserMapper userMapper;

    @Override
    @DS("slave")
    public UserDto findUserById(int userId) throws ServiceException {
        UserDto userDto = null;
        User user = userMapper.selectById(userId);

        //若user不为空，则填充数据到userDto中
        if (user != null) {
            userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
        } else {
            throw new ServiceException(RespCode.ACCOUNT_NOT_EXIST);
        }
        return userDto;
    }

    @Override
    public int updateProfile(UserDto userDto) throws ServiceException {
        int i = 0;
        //根据用户ID查询用户
        User user = userMapper.selectById(userDto.getUserId());

        //若不为空，则更新值到用户中
        if (user != null ) {
            if (user.getIsDel() == 0) {
                User newUser = new User();
                BeanUtils.copyProperties(userDto, newUser);
                i = userMapper.updateById(newUser);
            } else {
                throw new ServiceException(RespCode.ACCOUNT_NOT_EXIST);
            }
        } else {
            throw new ServiceException(RespCode.ACCOUNT_NOT_EXIST);
        }
        return i;
    }
}
