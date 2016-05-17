package com.athena.parameter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.dto.ResponseResult;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;
import com.athena.module.dictionaries.service.DictionaryService;

/**
 * 参数配置
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/parameter")
public class ParameterController extends AbstractWebController {

	@Autowired
	private DictionaryService dictionaryService;

	// 参数管理页面
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("/system/parameter/main");
	}

	// 参数数据
	@RequestMapping(value = "/parameterJson", method = RequestMethod.POST)
	@ResponseBody
	public Object parameterJson(HttpServletResponse response) {
		List<Dictionary> parameters = dictionaryService.selectParametersTree();
		return parameters == null ? new ArrayList<>() : parameters;
	}

	// 参数添加页面
	@RequestMapping(value = "/addParameterView", method = RequestMethod.GET)
	public ModelAndView addParameterView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/parameter/edit");

		DictionaryExample example = new DictionaryExample();
		example.or().andIdEqualTo(form.getOptParentId());
		List<Dictionary> params = dictionaryService.selectByExample(example);

		// 获取上级及插入信息
		Dictionary parent = CollectionUtils.isNotEmpty(params) ? params.get(0) : new Dictionary();
		form.setOptDeep(parent.getOptDeep() == null ? 0 : (short) (parent.getOptDeep() + 1));
		mv.addObject("parent", parent);
		mv.addObject("parameter", form);

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 选项字典编辑页面
	@RequestMapping(value = "/editParameterView", method = RequestMethod.GET)
	public ModelAndView editParameterView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/parameter/edit");

		// 获取上级及插入信息
		Dictionary parameter = dictionaryService.selectByPrimaryKey(form.getId());
		Dictionary parent = dictionaryService.selectByPrimaryKey(parameter.getOptParentId());
		mv.addObject("parameter", parameter);
		mv.addObject("parent", parent);

		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}
	
	// 保存参数
	@RequestMapping(value = "/saveParameter", method = RequestMethod.POST)
	public ModelAndView saveParameter(Dictionary form) {
		ModelAndView mv = new ModelAndView();
		if (isAddOperation(form)) {
			setSuccessView(mv);
			dictionaryService.insert(form);
		} else {
			setCompleteView(mv);
			dictionaryService.update(form);
		}

		setWindowsId(mv, form);
		return mv;
	}

	// 删除参数
	@RequestMapping(value = "/removeParameter", method = RequestMethod.POST)
	@ResponseBody
	public Object removeParameter(Dictionary form, HttpServletResponse response) {
		try {
			// 删除所有下级目录及参数
			dictionaryService.remove(form.getId());
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}

	// 检测参数名称是否存在
	@RequestMapping(value = "/isExitsOptName", method = RequestMethod.POST)
	public void isExitsOptName(Dictionary form, HttpServletResponse response) throws Exception {
		boolean isNotexist = dictionaryService.isNotExistParameterName(form);
		response.getWriter().write(String.valueOf(isNotexist));
	}

}
