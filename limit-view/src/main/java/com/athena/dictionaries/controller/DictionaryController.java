package com.athena.dictionaries.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.context.Constants;
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
		ModelAndView mv = new ModelAndView("/system/attribute/dictionaryMain");
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
	public ModelAndView addOptdicView(Dictionary form) {
		ModelAndView mv = new ModelAndView("/system/attribute/editOptdic");

		// 获取父选项组
		DictionaryExample example = new DictionaryExample();

		example.or().andParentIdEqualTo(0L).andOptNameNotEqualTo("sys_param");
		List<OptDic> optdicGroup = dictionaryService.selectByExample(example);

		mv.addObject("optdicGroup", optdicGroup);
		setAddOperation(mv);
		setParentWinId(mv, form);
		return mv;
	}

	// 选项字典编辑页面
	@RequestMapping(value = "/editOptdicView", method = RequestMethod.GET)
	public ModelAndView editOptdicView(OptDic form) {
		ModelAndView mv = new ModelAndView("/system/attribute/editOptdic");

		// 获取父选项组
		OptDicExam exam = new OptDicExam();
		exam.or().andParentIdEqualTo(0L).andOptNameNotEqualTo("sys_param");
		List<OptDic> optdicGroup = dictionaryService.selectByExample(exam);

		mv.addObject("optdicGroup", optdicGroup);
		setEditOperation(mv);
		setParentWinId(mv, form);

		// 编辑的选项字典
		form = dictionaryService.selectByPrimaryKey(form.getId());
		mv.addObject("optdic", form);
		return mv;
	}

	// 保存选项字典
	@RequestMapping(value = "/saveOptdic", method = RequestMethod.POST)
	public ModelAndView addOptdic(OptDic form) {
		ModelAndView mv = new ModelAndView();
		if ("add".equals(form.getOperation())) {
			setSuccessView(mv);
			// 处理子选项名称
			if (StringUtils.isBlank(form.getOptName())) {
				form.setOptName(dictionaryService.selectByPrimaryKey(form.getParentId()).getOptName()); // optname为父选项组名称
			}

			dictionaryService.insert(form); // 添加选项
		} else {
			setCompleteView(mv);
			// 处理子选项添加
			if (StringUtils.isBlank(form.getOptName())) {
				form.setOptName(dictionaryService.selectByPrimaryKey(form.getParentId()).getOptName()); // optname为父选项组名称
			}
			dictionaryService.updateOptdic(form); // 更新父选项后, 需要级联所有子选项的optname
		}

		setParentWinId(mv, form);
		setCurrentWinId(mv, form);
		return mv;
	}

	// 删除选项字典 [ajax]
	@RequestMapping(value = "/removeOptdic", method = RequestMethod.POST)
	@ResponseBody
	public Object removeOptdic(OptDic optdic, HttpServletResponse response) {
		try {
			dictionaryService.removeOptdic(optdic.getId()); // 删除选项字典及子选项
			return new ResponseResult(true, "删除成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseResult(false, "操作失败");
		}
	}

	/** ----------------------------- 参数管理 -------------------------------------- */

	// 参数管理json [easyui datagrid]
	@RequestMapping(value = "/paramJson", method = RequestMethod.POST)
	@ResponseBody
	public Object paramJson(HttpServletResponse response) {
		List<OptDic> optDics = dictionaryService.selectParams();
		return optDics == null ? new ArrayList<OptDic>() : optDics;
	}

	// 添加参数页面
	@RequestMapping(value = "/addParamView", method = RequestMethod.GET)
	public ModelAndView addParamView(OptDic form) {
		ModelAndView mv = new ModelAndView("/system/attribute/editParam");
		setAddOperation(mv);
		setParentWinId(mv, form);
		return mv;
	}

	// 选项字典编辑页面
	@RequestMapping(value = "/editParamView", method = RequestMethod.GET)
	public ModelAndView editParamView(OptDic form) {
		ModelAndView mv = new ModelAndView("/system/attribute/editParam");
		setEditOperation(mv);
		setParentWinId(mv, form);

		// 编辑的选项字典
		form = dictionaryService.selectByPrimaryKey(form.getId());
		mv.addObject("optdic", form);
		return mv;
	}

	// 保存参数
	@RequestMapping(value = "/saveParam", method = RequestMethod.POST)
	public ModelAndView saveParam(OptDic form) {
		ModelAndView mv = new ModelAndView();
		if ("add".equals(form.getOperation())) {
			setSuccessView(mv);
			form.setOptName("sys_param"); // 标识是参数类型
			dictionaryService.insert(form); // 添加参数
		} else {
			setCompleteView(mv);
			dictionaryService.updateByPrimaryKeySelective(form); // 更新参数
		}

		setParentWinId(mv, form);
		setCurrentWinId(mv, form);
		return mv;
	}

	// 删除参数 [ajax]
	@RequestMapping(value = "/removeParam", method = RequestMethod.POST)
	@ResponseBody
	public Object removeParam(OptDic optdic, HttpServletResponse response) {
		try {
			dictionaryService.deleteByPrimaryKey(optdic.getId());
			return new ResponseResult(true, "删除成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new ResponseResult(true, "操作失败");
		}
	}

	// 验证选项字典唯一性
	@RequestMapping(value = "/isExitsOptdic", method = RequestMethod.POST)
	public void isExistOptdic(String optName, HttpServletResponse response) throws IOException {
		OptDicExam exam = new OptDicExam();
		exam.or().andOptNameEqualTo(optName);
		List<OptDic> optdics = dictionaryService.selectByExample(exam);
		response.getWriter().write(CollectionUtils.isNotEmpty(optdics) ? "false" : "true");
	}

	// 验证参数唯一性
	@RequestMapping(value = "/isExitsParam", method = RequestMethod.POST)
	public void isExistParam(String optKey, HttpServletResponse response) throws IOException {
		OptDicExam exam = new OptDicExam();
		exam.or().andOptKeyEqualTo(optKey).andOptNameEqualTo("sys_param");
		List<OptDic> optdics = dictionaryService.selectByExample(exam);

		response.getWriter().write(CollectionUtils.isNotEmpty(optdics) ? "false" : "true");
	}
}
