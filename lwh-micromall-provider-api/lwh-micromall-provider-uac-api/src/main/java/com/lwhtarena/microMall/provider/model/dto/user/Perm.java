package com.lwhtarena.microMall.provider.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:30
 **/

@Data
public class Perm implements Serializable {

    private String resource;
    private String perm;
}
