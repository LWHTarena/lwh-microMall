package com.lwhtarena.microMall.provider.model.dto.gaode;

import com.lwhtarena.microMall.common.base.dto.GaodeBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Gaode location.
 *
 * @author paascloud.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GaodeLocation extends GaodeBaseDto {
	private String province;
	private String city;
	private String adcode;
	private String rectangle;
}
