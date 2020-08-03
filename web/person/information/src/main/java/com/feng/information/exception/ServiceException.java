package com.feng.information.exception;

import com.feng.information.common.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends Exception {
    private String msg;
    private int status;
    private RespCode respCode;

    public ServiceException(RespCode respCode) {
        super(respCode.getMsg());
        this.status = respCode.getStatus();
        this.respCode = respCode;
    }
}
