package com.athena.common.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * @author NieBinxiao
 */
public class FreeMarkerViewResolve extends FreeMarkerView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		model.put("ctx", request.getContextPath());
		
		response.addHeader("P3P", "CP=CAO PSA OUR");
		
		super.renderMergedTemplateModel(model, request, response);
	}

}
