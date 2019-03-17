package com.lwhtarena.microMall.common.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The class Date util.
 *
 * @author paascloud.net @gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

	/**
	 * 获取系统前时间.
	 *
	 * @param minute the minute
	 *
	 * @return the before time[yyyy-MM-dd HH:mm:ss]
	 */
	public static String getBeforeTime(int minute) {
		Date newDate = cn.hutool.core.date.DateUtil.offset(new Date(), cn.hutool.core.date.DateField.MINUTE, -minute);
		return cn.hutool.core.date.DateUtil.formatDateTime(newDate);
	}
}
