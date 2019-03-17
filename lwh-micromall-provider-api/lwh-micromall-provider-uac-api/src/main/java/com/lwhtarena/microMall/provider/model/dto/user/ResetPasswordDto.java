package com.lwhtarena.microMall.provider.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:31
 * 重置密码
 * */

@Data
@ApiModel
public class ResetPasswordDto implements Serializable {

    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty(value = "旧密码")
    private String passwordOld;
    @ApiModelProperty(value = "新密码")
    private String passwordNew;
}
