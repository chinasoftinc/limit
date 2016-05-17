package com.athena.menu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.ResponseResult;
import com.athena.module.menus.model.Menu;
import com.athena.module.menus.model.MenuExample;
import com.athena.module.menus.service.MenuService;

/**
 * 菜单管理
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends AbstractWebController {

	@Autowired
	private MenuService menuService;

	// 主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("/system/menu/main");
	}

	// 数据
	@RequestMapping("/menuJson")
	@ResponseBody
	public List<Menu> menuJson(HttpServletResponse response, HttpSession session) {
		List<Menu> menus = menuService.selectMenuTree();
		return menus == null ? new ArrayList<Menu>() : menus;
	}

	// 添加页面
	@RequestMapping("/addMenuView")
	public ModelAndView addMenuView(Menu form) {
		// 获取一级菜单, 供显示父级菜单下拉列表
		MenuExample example = new MenuExample();
		example.or().andMenuParentIdEqualTo(BigDecimal.ZERO);
		List<Menu> firstMenus = menuService.selectByExample(example);

		ModelAndView mv = new ModelAndView("/system/menu/edit");
		mv.addObject("firstMenus", firstMenus);

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 编辑页面
	@RequestMapping("/editMenuView")
	public ModelAndView editMenuView(Menu form) {
		ModelAndView mv = new ModelAndView("/system/menu/edit");
		Menu menu = menuService.selectByPrimaryKey(form.getId());

		if (menu.getMenuParentId() != BigDecimal.ZERO) {
			MenuExample example = new MenuExample();
			example.or().andMenuParentIdEqualTo(BigDecimal.ZERO);
			mv.addObject("firstMenus", menuService.selectByExample(example));
		}

		mv.addObject("menu", menu);
		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 保存
	@RequestMapping("/saveMenu")
	public ModelAndView saveMenu(Menu form) {
		ModelAndView mv = new ModelAndView();
		if (isAddOperation(form)) {
			setSuccessView(mv);
			menuService.insertMenu(form);
		} else {
			setCompleteView(mv);
			menuService.updateMenu(form);
		}

		setWindowsId(mv, form);
		return mv;
	}

	// 删除
	@RequestMapping(value = "/removeMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object removeMenu(Menu form, HttpServletResponse response) {
		try {
			menuService.removeMenu(form.getId());
			return new ResponseResult(true, "删除成功");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return new ResponseResult(false, "删除失败");
		}
	}

	// 移动位置
	@RequestMapping(value = "/moveMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object moveMenu(Menu menu, String direction, HttpServletResponse response) {
		try {
			menuService.updateMenuPos(menu.getId(), Direction.valueOf(direction));
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseResult(false, "操作失败");
		}
	}

}
