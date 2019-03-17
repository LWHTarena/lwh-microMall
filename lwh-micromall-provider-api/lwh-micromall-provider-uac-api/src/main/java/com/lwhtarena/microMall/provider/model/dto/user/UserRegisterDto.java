package com.lwhtarena.microMall.provider.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:35
 **/

@Data
@ApiModel(value = "用户注册Dto")
public class UserRegisterDto implements Serializable {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "登录名")
    private String loginName;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobileNo;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String loginPwd;

    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    private String confirmPwd;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 注册token
     */
    @ApiModelProperty(value = "注册渠道")
    private String registerSource;
}
