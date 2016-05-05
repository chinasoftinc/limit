package com.athena.dictionaries.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.model.DictionaryExample;
import com.athena.module.dictionaries.service.DictionaryService;

/**
 * 字典参数
 * @author niebinxiao
 */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends AbstractWebController {

	@Inject
	private DictionaryService dictionaryService;

	// 字典参数主页
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView optdicManage(Dictionary filter) {
		ModelAndView mv = new ModelAndView("/system/dictionary/main");
		mv.addObject("filter", filter);
		return mv;
	}

	// 选项字典数据 [异步ajax-json]
	@RequestMapping(value = "/dictionaryJson", method = RequestMethod.POST)
	@ResponseBody
	public Object dictionaryJson(HttpServletResponse response) {
		List<Dictionary> dics = dictionaryService.selectDictionariesTree();
		return dics == null ? new ArrayList<>() : dics;
	}

	// 字典添加页面
	@RequestMapping(value = "/addDictionaryView", method = RequestMethod.GET)
	public ModelAndView addDictionaryView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/dictionary/editDictionary");

		DictionaryExample example = new DictionaryExample();
		example.or().andIdEqualTo(form.getOptParentId());
		List<Dictionary> dics = dictionaryService.selectByExample(example);

		// 上级信息及插入信息
		Dictionary parent = CollectionUtils.isNotEmpty(dics) ? dics.get(0) : new Dictionary();
		form.setOptDeep(parent.getOptDeep() == null ? 0 : (short) (parent.getOptDeep() + 1));
		mv.addObject("parent", parent);
		mv.addObject("dictionary", form);

		setAddOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 选项字典编辑页面
	@RequestMapping(value = "/editDictionaryView", method = RequestMethod.GET)
	public ModelAndView editDictionaryView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/dictionary/editDictionary");

		// 编辑的选项字典和上级信息
		Dictionary dictionary = dictionaryService.selectByPrimaryKey(form.getId());
		Dictionary parent = dictionaryService.selectByPrimaryKey(dictionary.getOptParentId());
		mv.addObject("dictionary", dictionary);
		mv.addObject("parent", parent);

		setEditOperation(mv);
		setWindowsId(mv, form);
		return mv;
	}

	// 保存选项字典
	@RequestMapping(value = "/saveDictionary", method = RequestMethod.POST)
	public ModelAndView addOptdic(Dictionary form) {
		ModelAndView mv = new ModelAndView();

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

		setWindowsId(mv, form);
		return mv;
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
