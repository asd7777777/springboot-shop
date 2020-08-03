package com.feng.information.handler;

import com.feng.information.common.RespEntity;
import com.feng.information.exception.DaoException;
import com.feng.information.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionGlobalHandler {
    @ExceptionHandler(DaoException.class)
    public RespEntity<Object> handler(DaoException e) {
        log.error(e.getMessage());
        return RespEntity.error(e.getRespCode());
    }

    @ExceptionHandler(ServiceException.class)
    public RespEntity<Object> handler(ServiceException e) {
        log.error(e.getMessage());
        return RespEntity.error(e.getRespCode());
    }

    @ExceptionHandler(Exception.class)
    public RespEntity<Object> handler(Exception e) {
        log.error(e.getMessage());
        return RespEntity.error();
    }
}
