package com.athena.business.yunguan.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athena.business.dto.PageModel;
import com.athena.common.base.controller.AbstractWebController;
import com.athena.common.dto.Pagination;
import com.athena.module.chelxx.model.Chelxx;
import com.athena.module.chelxx.model.ChelxxExample;
import com.athena.module.chelxx.service.ChelxxService;

/**
 * @author niebinxiao
 */
@Controller
@RequestMapping("/business/yunguan")
public class YunGuanController extends AbstractWebController {

	@Autowired
	private ChelxxService chelxxService;

	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("/business/yunguan/main");
		PageModel model = new PageModel();
		model.setTotalNumber(chelxxService.countByExample(new ChelxxExample()));
		mv.addObject("page", model);
		return mv;
	}

	@RequestMapping("/chelxxJson")
	@ResponseBody
	public Object chelxxJson(PageModel model) {

		ChelxxExample example = new ChelxxExample();

		Pagination p = new Pagination(model.getPageNumber(), model.getPageSize());
		example.setPagination(p);

		model.setData(chelxxService.selectByExample(example));
		
		return model;
	}

}
