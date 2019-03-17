package com.lwhtarena.microMall.provider.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:49
 **/
@Data
public class PcMessageJobTask implements Serializable {

    /**
     * 自增ID
     */
    private String id;

    /**
     * 版本号
     */
    private String version;

    /**
     * 消息key
     */
    private Long messageKey;

    /**
     * topic
     */
    private String messageTopic;

    /**
     * tag
     */
    private String messageTag;
}
