package com.feng.pay.service;

import com.feng.pay.domain.dto.CardDto;
import com.feng.pay.domain.vo.CardVo;
import com.feng.pay.exception.ServiceException;

import java.util.List;

public interface PayService {
    List<CardVo> findAllByUserId(int page, int size, int userId) throws ServiceException;

    int bindCard(int userId, CardDto cardDto) throws ServiceException;
}
