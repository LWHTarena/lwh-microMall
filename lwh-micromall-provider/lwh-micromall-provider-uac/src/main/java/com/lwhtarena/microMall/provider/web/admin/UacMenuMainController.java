package com.lwhtarena.microMall.provider.web.admin;

import com.google.common.base.Preconditions;
import com.lwhtarena.microMall.common.base.dto.LoginAuthDto;
import com.lwhtarena.microMall.common.core.annotation.LogAnnotation;
import com.lwhtarena.microMall.common.core.support.BaseController;
import com.lwhtarena.microMall.common.util.wrapper.WrapMapper;
import com.lwhtarena.microMall.common.util.wrapper.Wrapper;
import com.lwhtarena.microMall.provider.model.domain.UacMenu;
import com.lwhtarena.microMall.provider.model.dto.menu.UacEditMenuDto;
import com.lwhtarena.microMall.provider.model.dto.menu.UacMenuStatusDto;
import com.lwhtarena.microMall.provider.model.vo.MenuVo;
import com.lwhtarena.microMall.provider.model.vo.ViewMenuVo;
import com.lwhtarena.microMall.provider.service.UacMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单主页面.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacMenuMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacMenuMainController extends BaseController {

	@Resource
	private UacMenuService uacMenuService;

	/**
	 * 获取菜单列表数据
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/getTree")
	@ApiOperation(httpMethod = "POST", value = "获取菜单树")
	public Wrapper<List<MenuVo>> queryMenuTreeList() {
		List<MenuVo> menuVoList = uacMenuService.getMenuVoList(getLoginAuthDto().getUserId(), null);
		return WrapMapper.ok(menuVoList);
	}

	/**
	 * 编辑菜单.
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryById/{id}")
	@ApiOperation(httpMethod = "POST", value = "编辑菜单")
	public Wrapper<ViewMenuVo> queryMenuVoById(@ApiParam(name = "id", value = "菜单id") @PathVariable Long id) {
		ViewMenuVo menuVo = uacMenuService.getViewVoById(id);
		return WrapMapper.ok(menuVo);
	}


	/**
	 * 根据id修改菜单的禁用状态
	 *
	 * @param uacMenuStatusDto the uac menu status dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/modifyStatus")
	@ApiOperation(httpMethod = "POST", value = "修改菜单状态")
	@LogAnnotation
	public Wrapper updateUacMenuStatusById(@ApiParam(name = "uacMenuStatusDto", value = "修改菜单状态Dto") @RequestBody UacMenuStatusDto uacMenuStatusDto) {
		logger.info("根据id修改菜单的禁用状态 uacMenuStatusDto={}", uacMenuStatusDto);
		LoginAuthDto loginAuthDto = getLoginAuthDto();
		uacMenuService.updateUacMenuStatusById(uacMenuStatusDto, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 新增菜单.
	 *
	 * @param uacMenuAddDto the uac menu add dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/save")
	@ApiOperation(httpMethod = "POST", value = "新增菜单")
	@LogAnnotation
	public Wrapper saveMenu(@ApiParam(name = "saveMenu", value = "保存菜单") @RequestBody UacEditMenuDto uacMenuAddDto) {
		UacMenu uacMenu = new UacMenu();
		LoginAuthDto loginAuthDto = getLoginAuthDto();
		BeanUtils.copyProperties(uacMenuAddDto, uacMenu);
		uacMenuService.saveUacMenu(uacMenu, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 根据id删除菜单
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/deleteById/{id}")
	@ApiOperation(httpMethod = "POST", value = "删除菜单")
	@LogAnnotation
	public Wrapper<Integer> deleteUacMenuById(@ApiParam(name = "id", value = "菜单id") @PathVariable Long id) {
		logger.info(" 根据id删除菜单 id={}", id);
		LoginAuthDto loginAuthDto = getLoginAuthDto();

		Preconditions.checkArgument(id != null, "菜单ID不能为空");

		// 判断此菜单是否有子节点
		boolean hasChild = uacMenuService.checkMenuHasChildMenu(id);
		if (hasChild) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "此菜单含有子菜单, 请先删除子菜单");
		}

		int result = uacMenuService.deleteUacMenuById(id, loginAuthDto);
		return super.handleResult(result);
	}
}