package limit.common.view;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import limit.common.context.Dictionary;
import limit.common.exception.ExceptionCode;
import limit.common.utils.ApplicationContextUtils;
import limit.common.utils.AssertUtils;
import limit.module.dictionary.model.OptDic;

/**
 * 描述: freemarker单选Tag
 * @author NieBinxiao
 */
public class SingleSelectTag implements TemplateDirectiveModel {

	private String id;
	private String name;
	private String style;
	private String clazz;
	private String disabled;
	private String optName;
	private String selected;
	private String data_options;

	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		id = params.get("id") != null ? params.get("id").toString() : "";
		name = params.get("name") != null ? params.get("name").toString() : "";
		style = params.get("style") != null ? params.get("style").toString() : "";
		disabled = params.get("disabled") != null ? params.get("disabled").toString() : "";
		clazz = params.get("class") != null ? params.get("class").toString() : "";
		selected = params.get("selected") != null ? params.get("selected").toString() : "";
		optName = params.get("optName") != null ? params.get("optName").toString().trim() : "";
		data_options = params.get("data_options") != null ? params.get("data_options").toString() : "";

		// 检查参数合法性
		AssertUtils.isNotEmptyStr(optName, ExceptionCode.IllegalParamException, "选项字典选项组的名称不能为空");

		StringBuffer sb = new StringBuffer("<select ");
		if (StringUtils.isNotEmpty(id))
			sb.append("id=\"" + id + "\" ");
		if (StringUtils.isNotEmpty(name))
			sb.append("name=\"" + name + "\" ");
		if (StringUtils.isNotEmpty(style))
			sb.append("style=\"" + style + "\" ");
		if (StringUtils.isNotEmpty(disabled))
			sb.append("disabled=\"" + disabled + "\" ");
		if (StringUtils.isNotEmpty(clazz))
			sb.append("class=\"" + clazz + "\" ");
		if (StringUtils.isNotEmpty(selected))
			sb.append("selected=\"" + selected + "\" ");

		// easyui validator验证表达式
		if (StringUtils.isNotEmpty(data_options))
			sb.append("data-options=" + data_options);
		sb.append("><option value=\"\"></option>");

		// 从字典中取optName对应的选项map
		List<OptDic> dicOptions = ApplicationContextUtils.getBean(Dictionary.class).getOptDic(optName);
		AssertUtils.isNotEmptyColl(dicOptions, ExceptionCode.IllegalParamException, "没有找到[optName:" + optName + "]对应的选项组");

		for (OptDic dic : dicOptions) {
			if (dic.getOptKey().equals(selected)) {
				sb.append("<option value=\"" + dic.getOptKey() + "\" selected=\"selected\">" + dic.getOptVal() + "</option>");
			} else {
				sb.append("<option value=\"" + dic.getOptKey() + "\">" + dic.getOptVal() + "</option>");
			}
		}
		sb.append("</select>");

		env.getOut().write(sb.toString());
	}
}
