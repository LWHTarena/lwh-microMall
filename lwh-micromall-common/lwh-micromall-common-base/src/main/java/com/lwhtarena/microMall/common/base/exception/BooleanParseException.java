package com.lwhtarena.microMall.common.base.exception;

/**
 * <p>
 * <h2>简述：</h2>
 * <ol></ol>
 * <h2>功能描述：</h2>
 * <ol></ol>
 * </p>
 *
 * @Author: liwh
 * @Date :
 * @Version: 版本
 */
public class BooleanParseException extends RuntimeException {
    /**
     * Instantiates a new Boolean parse exception.
     */
    public BooleanParseException() {
        super();
    }

    /**
     * Instantiates a new Boolean parse exception.
     *
     * @param message the message
     */
    public BooleanParseException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Boolean parse exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BooleanParseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Boolean parse exception.
     *
     * @param cause the cause
     */
    public BooleanParseException(Throwable cause) {
        super(cause);
    }
}
