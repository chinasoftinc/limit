package com.athena.business.yunguan.controller;

import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

	/**
	 * 运管首页
	 * @return
	 */
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

	/**
	 * 车辆信息列表查询数据
	 * @param filter
	 * @param model
	 * @return
	 */
	@RequestMapping("/chelxxJson")
	@ResponseBody
	public Object chelxxJson(Chelxx filter, PageModel model) {

		ChelxxExample example = createChelxxExample(filter);
		model.setTotalNumber(chelxxService.countByExample(example));

		Pagination p = new Pagination(model.getPageNumber(), model.getPageSize());
		example.setPagination(p);

		model.setData(chelxxService.selectByExample(example));

		return model;
	}

	/**
	 * 车辆查询条件生成
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private ChelxxExample createChelxxExample(Chelxx filter) {
		ChelxxExample example = new ChelxxExample();
		Criteria or = example.or();
		if (StringUtils.isNotEmpty(filter.getChepys())) {
			or.andChepysEqualTo(URLDecoder.decode(filter.getChepys()));
		}
		if (StringUtils.isNotEmpty(filter.getCheph())) {
			or.andChephLikeInsensitive("%" + URLDecoder.decode(filter.getCheph()) + "%");
		}
		if (StringUtils.isNotEmpty(filter.getChegRange()) && filter.getChegRange().split("-").length == 2) {
			String[] arr = filter.getChegRange().split("-");
			or.andChegBetween(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
		}
		if (filter.getHedzws() != null) {
			or.andHedzwsEqualTo(filter.getHedzws());
		}
		if (StringUtils.isNotEmpty(filter.getFazjg())) {
			or.andFazjgEqualTo(URLDecoder.decode(filter.getFazjg()));
		}

		return example;
	}

}
