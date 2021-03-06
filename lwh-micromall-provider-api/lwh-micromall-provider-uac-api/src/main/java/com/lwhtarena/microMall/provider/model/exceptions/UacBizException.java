package com.lwhtarena.microMall.provider.model.exceptions;

import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.base.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:37
 **/
@Slf4j
public class UacBizException extends BusinessException {

    /**
     * Instantiates a new Uac rpc exception.
     */
    public UacBizException() {
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public UacBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== UacRpcException, code:" + this.code + ", message:" + super.getMessage());

    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public UacBizException(int code, String msg) {
        super(code, msg);
        log.info("<== UacRpcException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param codeEnum the code enum
     */
    public UacBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== UacRpcException, code:" + this.code + ", message:" + super.getMessage());
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public UacBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== OpcRpcException, code:" + this.code + ", message:" + super.getMessage());
    }
}
