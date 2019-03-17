package com.lwhtarena.microMall.provider.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:25
 **/

@Data
@ApiModel
public class ForgetCheckAnswerDto implements Serializable {

    private static final long serialVersionUID = -4611532562847293450L;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "问题")
    private String email;
    @ApiModelProperty(value = "答案")
    private String answer;
}
