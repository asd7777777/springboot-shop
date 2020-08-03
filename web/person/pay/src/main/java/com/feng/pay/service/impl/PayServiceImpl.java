package com.feng.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.pay.common.RespCode;
import com.feng.pay.common.RespEntity;
import com.feng.pay.domain.dto.CardDto;
import com.feng.pay.domain.entity.Card;
import com.feng.pay.domain.vo.CardVo;
import com.feng.pay.exception.ServiceException;
import com.feng.pay.mapper.CardMapper;
import com.feng.pay.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    CardMapper cardMapper;


    @Override
    public List<CardVo> findAllByUserId(int page, int size, int userId) throws ServiceException {
        List<CardVo> cardVoList = new ArrayList<>();

        //根据用户id查询该用户拥有的银行卡
        QueryWrapper<Card> queryWrapper = new QueryWrapper<Card>().eq(Card.COL_USER_ID, userId);
        IPage<Card> cardIPage = cardMapper.selectPage(new Page<>(page, size), queryWrapper);

        if (cardIPage != null) {
            List<Card> records = cardIPage.getRecords();
            //遍历查询到的银行卡，存储到cardVoList中
            records.forEach(card -> {
                CardVo cardVo = new CardVo();
                BeanUtils.copyProperties(card, cardVo);
                cardVoList.add(cardVo);
            });
        } else {
            throw new ServiceException(RespCode.EMPTY_CARDS);
        }
        return cardVoList;
    }

    @Override
    public int bindCard(int userId, CardDto cardDto) throws ServiceException {
        int i = 0;

        //查询该卡是否已被绑定
        QueryWrapper<Card> queryWrapper = new QueryWrapper<Card>().eq(Card.COL_BANK_CARD_ID,cardDto.getBankCardId());
        Card card = cardMapper.selectOne(queryWrapper);
        //若该卡没有被绑定，则添加该卡
        if (card == null) {
            card = new Card();
            card.setUserId(userId);
            //所属银行暂时写死
            card.setBankName("工商银行");
            BeanUtils.copyProperties(cardDto, card);
            i = cardMapper.insert(card);
        } else {
            throw new ServiceException(RespCode.EXIST_CARD);
        }

        return i;
    }
}
