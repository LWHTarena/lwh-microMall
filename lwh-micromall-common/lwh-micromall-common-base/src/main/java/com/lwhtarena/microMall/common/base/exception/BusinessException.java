package com.lwhtarena.microMall.common.base.exception;

import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;

/**
 * <p>
 * <h2>简述：业务异常</h2>
 * <ol></ol>
 * <h2>功能描述：业务异常</h2>
 * <ol></ol>
 * </p>
 *
 * @Author: liwh
 * @Date :
 * @Version: 版本
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    protected int code;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ErrorCodeEnum message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
