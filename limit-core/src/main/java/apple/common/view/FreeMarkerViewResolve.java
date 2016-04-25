package apple.common.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 自定义freemarker视图解析器
 * @author NieBinxiao
 */
public class FreeMarkerViewResolve extends FreeMarkerView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 上下文路径
		model.put("ctx", request.getContextPath());
		// 让iframe的session共享
		response.addHeader("P3P", "CP=CAO PSA OUR");
		super.renderMergedTemplateModel(model, request, response);
	}

}
