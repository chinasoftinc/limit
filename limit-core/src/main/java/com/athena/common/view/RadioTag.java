package com.athena.common.view;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.athena.common.context.Dictionary;
import com.athena.common.exception.ExceptionCode;
import com.athena.common.utils.ApplicationContextUtils;
import com.athena.common.utils.AssertUtils;
import com.athena.module.dictionary.model.OptDic;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 描述:　单选Tag
 * @author NieBinxiao
 */
public class RadioTag implements TemplateDirectiveModel {

	// html id
	private String id;
	// html name
	private String name;
	// html style
	private String style;
	// html class
	private String clazz;
	// html disabled
	private String disabled;
	// 选项组名称
	private String optName;
	// 选中的值(回显, 针对选项组)
	private String checked;
	// 默认的选中值, 如果checked为null
	private String defaultChecked;

	@Override
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		id = params.get("id") != null ? params.get("id").toString() : "";
		name = params.get("name") != null ? params.get("name").toString() : "";
		style = params.get("style") != null ? params.get("style").toString() : "";
		disabled = params.get("disabled") != null ? params.get("disabled").toString() : "";
		clazz = params.get("class") != null ? params.get("class").toString() : "";
		optName = params.get("optName") != null ? params.get("optName").toString().trim() : "";
		checked = params.get("checked") != null ? params.get("checked").toString() : "";
		defaultChecked = params.get("defaultChecked") != null ? params.get("defaultChecked").toString() : "";

		// 检查参数合法性
		AssertUtils.isNotEmptyStr(optName, ExceptionCode.IllegalParamException, "选项字典选项组的名称不能为空");

		// 组装html属性
		StringBuffer sb = new StringBuffer();

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

		// 从字典中取optName对应的选项map
		List<OptDic> dicOptions = ApplicationContextUtils.getBean(Dictionary.class).getOptDic(optName);
		AssertUtils.isNotEmptyColl(dicOptions, ExceptionCode.IllegalParamException, "没有找到[optName:" + optName + "]对应的选项组");

		StringBuffer rs = new StringBuffer();
		for (OptDic dic : dicOptions) {
			rs.append("<input type=\"radio\"").append(sb);
			if (StringUtils.isEmpty(checked) && dic.getOptKey().equals(defaultChecked)) {
				rs.append("checked=\"checked\" ");
			} else if (dic.getOptKey().equals(checked)) {
				rs.append("checked=\"checked\" ");
			}
			rs.append("value=\"" + dic.getOptKey() + "\" ");
			rs.append(">" + dic.getOptVal() + "</input>");
		}
		
		env.getOut().write(rs.toString());
	}
}
