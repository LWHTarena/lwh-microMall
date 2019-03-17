package com.lwhtarena.microMall.provider.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/17 09:28
 **/

@Data
@ApiModel
public class IdStatusDto implements Serializable {

    @ApiModelProperty(value = "用户ID", required = true)
    private Long id;
    @ApiModelProperty(value = "推送状态", required = true)
    private Integer status;
}
