package com.athena.business.yunguan.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.EncodingUtils;
import org.apache.wicket.request.UrlEncoder;
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
import com.athena.module.chelxx.model.ChelxxExample.Criteria;
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

		List<String> chepysList = chelxxService.selectDistinctChepys();
		List<String> fazjgList = chelxxService.selectDistinctFazjg();

		PageModel model = new PageModel();
		model.setTotalNumber(chelxxService.countByExample(new ChelxxExample()));
		mv.addObject("page", model);
		mv.addObject("chepysList", chepysList);
		mv.addObject("fazjgList", fazjgList);
		return mv;
	}

	@RequestMapping("/chelxxJson")
	@ResponseBody
	public Object chelxxJson(Chelxx filter, PageModel model) {

		ChelxxExample example = new ChelxxExample();
		Criteria or = example.or();
		if (filter.getChepys() != null) {
			System.out.println(URLDecoder.decode(filter.getChepys()));
			or.andChepysEqualTo(URLDecoder.decode(filter.getChepys()));
		}
		if (filter.getCheg() != null) {
			System.out.println(filter.getCheg());
			or.andChegEqualTo(filter.getCheg());
		}
		if (filter.getHedzws() != null) {
			System.out.println(filter.getHedzws());
			or.andHedzwsEqualTo(filter.getHedzws());
		}
		if (filter.getFazjg() != null) {
			System.out.println(URLDecoder.decode(filter.getFazjg()));
			or.andFazjgEqualTo(URLDecoder.decode(filter.getFazjg()));
		}

		Pagination p = new Pagination(model.getPageNumber(), model.getPageSize());
		example.setPagination(p);

		model.setData(chelxxService.selectByExample(example));

		return model;
	}

}
