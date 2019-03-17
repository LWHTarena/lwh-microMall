package com.lwhtarena.microMall.provider.exceptions;

import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.base.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:51
 **/
@Slf4j
public class TpcBizException extends BusinessException {

    private static final long serialVersionUID = -6552248511084911254L;

    /**
     * Instantiates a new Uac rpc exception.
     */
    public TpcBizException() {
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public TpcBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== TpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public TpcBizException(int code, String msg) {
        super(code, msg);
        log.info("<== TpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Opc rpc exception.
     *
     * @param codeEnum the code enum
     */
    public TpcBizException(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== TpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Opc rpc exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public TpcBizException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== TpcBizException, code:{}, message:{}", this.code, super.getMessage());
    }
}

