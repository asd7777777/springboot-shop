package com.feng.address.exception;

import com.feng.address.common.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@EqualsAndHashCode(callSuper = true)
@Data
public class DaoException extends Exception{
    private String msg;
    private int status;
    private RespCode respCode;

    public DaoException(RespCode respCode) {
        super(respCode.getMsg());
        this.status = respCode.getStatus();
        this.respCode = respCode;
    }
}
