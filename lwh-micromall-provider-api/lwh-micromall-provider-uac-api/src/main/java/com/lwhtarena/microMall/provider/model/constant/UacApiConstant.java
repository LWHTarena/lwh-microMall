package com.lwhtarena.microMall.provider.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:24
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UacApiConstant {

    /**
     * token变量
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Valid {
        /**
         * The constant EMAIL.
         */
        public static final String EMAIL = "email";
        /**
         * The constant LOGIN_NAME.
         */
        public static final String LOGIN_NAME = "loginName";
        /**
         * The constant MOBILE_NO.
         */
        public static final String MOBILE_NO = "mobileNo";
    }
}
