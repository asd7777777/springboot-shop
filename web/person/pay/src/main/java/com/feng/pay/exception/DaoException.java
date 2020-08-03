package com.feng.pay.exception;

import com.feng.pay.common.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
