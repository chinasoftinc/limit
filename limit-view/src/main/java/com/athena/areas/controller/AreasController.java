package com.athena.areas.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.dto.ResponseResult;
import com.athena.common.dto.TreeNode;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.service.AreaService;

/**
 * 地区
 * @author Binxiao
 */
@Controller
@RequestMapping(value = "/system/area")
public class AreasController extends AbstractWebController {

	@Inject
	private AreaService areaService;

	// 地区主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletResponse response) {
		return new ModelAndView("/system/area/main");
	}

	// 地区数据
	@RequestMapping(value = "/areaJson", method = RequestMethod.POST)
	@ResponseBody
	public Object areaJson(BigDecimal areasParentId, HttpServletResponse response) {
		List<TreeNode> treeNodes = areaService.selectAreasTree(areasParentId);
		return treeNodes == null ? new ArrayList<TreeNode>() : treeNodes;
	}

	// 保存地区
	@RequestMapping(value = "/saveArea", method = RequestMethod.POST)
	@ResponseBody
	public Object saveArea(Area form, HttpServletResponse response) {
		try {
			if (isAddOperation(form)) {
				areaService.insert(form);
				return new ResponseResult(true, "添加成功");
			} else {
				areaService.update(form);
				return new ResponseResult(true, "更新成功");
			}
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false); // 通知客户端树操作失败
		}
	}

	// 删除地区
	@RequestMapping(value = "/removeArea", method = RequestMethod.POST)
	@ResponseBody
	public Object removeArea(BigDecimal id, HttpServletResponse response) {
		try {
			areaService.remove(id);
			return new ResponseResult(true, "删除成功");
		} catch (Exception e) {
			return new ResponseResult(false, "操作失败");
		}
	}

}
