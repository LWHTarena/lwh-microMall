package com.lwhtarena.microMall.provider.service.impl;

import com.lwhtarena.microMall.common.base.enums.ErrorCodeEnum;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.exceptions.OmcBizException;
import com.lwhtarena.microMall.provider.model.dto.oss.OptGetUrlRequest;
import com.lwhtarena.microMall.provider.model.dto.oss.OptUploadFileReqDto;
import com.lwhtarena.microMall.provider.model.dto.oss.OptUploadFileRespDto;
import com.lwhtarena.microMall.provider.service.OpcOssFeignApi;
import com.lwhtarena.microMall.provider.service.OpcOssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The class Opc oss service.
 *
 * @author paascloud.net@gmail.com
 */
@Slf4j
@Service
public class OpcOssServiceImpl implements OpcOssService {
	@Resource
	private OpcOssFeignApi opcOssFeignApi;

	@Override
	public OptUploadFileRespDto uploadFile(OptUploadFileReqDto optUploadFileReqDto) {
		log.info("uploadFile - 上传附件. optUploadFileReqDto={}", optUploadFileReqDto);
		Wrapper<OptUploadFileRespDto> wrapper = opcOssFeignApi.uploadFile(optUploadFileReqDto);
		if (null == wrapper || wrapper.error()) {
			throw new OmcBizException(ErrorCodeEnum.OMC10031012);
		}
		return wrapper.getResult();
	}

	@Override
	public String getFileUrl(OptGetUrlRequest optGetUrlRequest) {
		log.info("getFileUrl - 获取附件地址. optUploadFileReqDto={}", optGetUrlRequest);
		Wrapper<String> wrapper = opcOssFeignApi.getFileUrl(optGetUrlRequest);
		if (null == wrapper || wrapper.error()) {
			throw new OmcBizException(ErrorCodeEnum.OMC10031013);
		}
		return wrapper.getResult();
	}
}
