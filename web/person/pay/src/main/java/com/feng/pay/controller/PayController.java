package com.feng.pay.controller;

import com.feng.pay.common.RespEntity;
import com.feng.pay.domain.dto.CardDto;
import com.feng.pay.domain.vo.CardVo;
import com.feng.pay.exception.ServiceException;
import com.feng.pay.service.PayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    PayService payService;

    @GetMapping("/list")
    public RespEntity<List<CardVo>> list(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size, int userId) throws ServiceException {
        List<CardVo> cardVoList = payService.findAllByUserId(page, size, userId);
        return RespEntity.success(cardVoList);
    }

    @PostMapping("/cardBind")
    public RespEntity<Integer> bindCard(int userId, @RequestBody CardDto cardDto) throws ServiceException {
        int i = payService.bindCard(userId, cardDto);
        return RespEntity.success(i);
    }
}