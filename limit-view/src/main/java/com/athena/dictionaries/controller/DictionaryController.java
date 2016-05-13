package com.athena.dictionaries.controller;

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
import com.athena.common.context.Constants.Direction;
import com.athena.common.dto.ResponseResult;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;
import com.athena.module.dictionaries.service.DictionaryService;

/**
 * 数据字典
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends AbstractWebController {

	@Autowired
	private DictionaryService dictionaryService;

	// 主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("/system/dictionary/main");
	}

	// 数据
	@RequestMapping(value = "/dictionaryJson", method = RequestMethod.POST)
	@ResponseBody
	public Object dictionaryJson(HttpServletResponse response) {
		List<Dictionary> dics = dictionaryService.selectDictionariesTree();
		return dics == null ? new ArrayList<>() : dics;
	}

	// 添加页面
	@RequestMapping(value = "/addDictionaryView", method = RequestMethod.GET)
	public ModelAndView addDictionaryView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/dictionary/edit");

		DictionaryExample example = new DictionaryExample();
		example.or().andIdEqualTo(form.getOptParentId());
		List<Dictionary> dics = dictionaryService.selectByExample(example);

		// 获取上级及插入信息
		Dictionary parent = CollectionUtils.isNotEmpty(dics) ? dics.get(0) : new Dictionary();
		form.setOptDeep(parent.getOptDeep() == null ? 0 : (short) (parent.getOptDeep() + 1));
		mv.addObject("parent", parent);
		mv.addObject("dictionary", form);

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 编辑页面
	@RequestMapping(value = "/editDictionaryView", method = RequestMethod.GET)
	public ModelAndView editDictionaryView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/dictionary/edit");

		// 编辑的字典和上级信息
		Dictionary dictionary = dictionaryService.selectByPrimaryKey(form.getId());
		Dictionary parent = dictionaryService.selectByPrimaryKey(dictionary.getOptParentId());
		mv.addObject("dictionary", dictionary);
		mv.addObject("parent", parent);

		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 保存
	@RequestMapping(value = "/saveDictionary", method = RequestMethod.POST)
	public ModelAndView addOptdic(Dictionary form) {
		ModelAndView mv = new ModelAndView();

		try {
			// 添加
			if (isAddOperation(form)) {
				setSuccessView(mv);
				dictionaryService.insert(form);
			}
			// 保存
			else {
				setCompleteView(mv);
				dictionaryService.update(form);
			}
		} catch (Exception e) {
			setErrorView(mv, "操作失败");
		}

		setWindowsId(mv, form);
		return mv;
	}

	// 删除
	@RequestMapping(value = "/removeDictionary", method = RequestMethod.POST)
	@ResponseBody
	public Object removeDictionary(Dictionary form, HttpServletResponse response) {
		try {
			// 删除选项字典及子选项
			dictionaryService.remove(form.getId());
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}

	// 移动位置
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	@ResponseBody
	public Object move(Dictionary form, String direction, HttpServletResponse response) {
		try {
			dictionaryService.updatePos(form.getId(), Direction.valueOf(direction));
			return new ResponseResult(true, "操作成功");
		} catch (Exception e) {
			logger.error(e.getCause().getMessage());
			return new ResponseResult(false, "操作失败");
		}
	}

	// 检测选项组名称是否存在
	@RequestMapping(value = "/isExitsOptName", method = RequestMethod.POST)
	public void isExitsOptName(Dictionary form, HttpServletResponse response) throws Exception {
		boolean isNotexist = dictionaryService.isNotExistDictionaryGroup(form);
		response.getWriter().write(String.valueOf(isNotexist));
	}

	// 检测子选项键是否存在
	@RequestMapping(value = "/isExitsOptKey", method = RequestMethod.POST)
	public void isExitsOptKey(Dictionary form, HttpServletResponse response) throws Exception {
		boolean isNotexist = dictionaryService.isNotExistDictionaryKey(form);
		response.getWriter().write(String.valueOf(isNotexist));
	}
}
