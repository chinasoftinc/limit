package apple.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import apple.common.exception.ExceptionCode;
import apple.common.exception.BusinessException;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * FreeMarker模板工具类
 * @author niebinxiao
 */
public class TemplateUtils {
	private static Logger logger = LoggerFactory.getLogger(TemplateUtils.class);
	private static TemplateUtils instance;
	private static Configuration configuration;

	/**
	 * 创建freemarker实例, 不使用web容器中的, 若想使用, 注入spring的视图解析器get
	 * @return
	 * @throws IOException
	 */
	public static TemplateUtils getInstance() {
		try {
			if (null == instance) {
				Properties prop = new Properties();
				prop.load(TemplateUtils.class.getClassLoader().getResourceAsStream("freemarker.properties"));
				instance = new TemplateUtils(prop);
			}
			return instance;
		} catch (IOException e) {
			logger.error("初始化freemarker实例失败");
			return null;
		}
	}

	/**
	 * 构造初始化模板参数
	 * @param prop
	 */
	private TemplateUtils(Properties prop) {
		try {
			configuration = new Configuration();
			// 共享的一些配置方式, 使用simpleHash对象, 向context中注入一些预设参数
			SimpleHash hash = new SimpleHash();
			hash.put("fmXmlEscape", Class.forName(prop.getProperty("fmXmlEscape")).newInstance()); // 模版的字符转义类
			// FIXME, 可以注入contextPath, 字典等

			configuration.setAllSharedVariables(hash);
			configuration.setDefaultEncoding(prop.getProperty("setDefaultEncoding"));
			configuration.setSetting("tag_syntax", prop.getProperty("tag_syntax"));
			configuration.setSetting("default_encoding", prop.getProperty("default_encoding"));
			configuration.setSetting("output_encoding", prop.getProperty("output_encoding"));
			configuration.setSetting("locale", prop.getProperty("locale"));
			configuration.setSetting("date_format", prop.getProperty("date_format"));
			configuration.setSetting("time_format", prop.getProperty("time_format"));
			configuration.setSetting("datetime_format", prop.getProperty("datetime_format"));
			configuration.setSetting("classic_compatible", prop.getProperty("classic_compatible"));
			configuration.setSetting("auto_import", prop.getProperty("template_local_auto_import"));
			configuration.setSetting("number_format", prop.getProperty("number_format"));
			configuration.setSetting("url_escaping_charset", prop.getProperty("url_escaping_charset"));
			// configuration.setClassForTemplateLoading(TempLateContext.class, (String) prop.get("template_local_root_directory"));
			configuration.setTemplateLoader(new FileTemplateLoader(new File(prop.getProperty("template_path"))));

		} catch (Exception e) {
			throw new BusinessException(ExceptionCode.SystemException, "Freemarker工具类初始化失败:\rerror:" + e.toString());
		}
	}

	/**
	 * 生成模板文件, 注意生成文件的保存位置是freemarker中已设置了<br/>
	 * @param model 参数
	 * @param templateName 模板文件名
	 * @param path 生成的HTML文件路径
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void processTempLateFile(Map<String, Object> model, String templateName, String path) throws IOException, TemplateException {
		Template tl = configuration.getTemplate(templateName.endsWith(".ftl") ? templateName : templateName + ".ftl");
		AssertUtils.isNotNull(tl, ExceptionCode.IllegalParamException, "未找到模版[templateName" + templateName + "]");
		FileWriter writer = new FileWriter(new File(path));
		tl.process(model, writer);
		writer.close();
	}

	/**
	 * 生成模板文本<br/>
	 * 这个生成文本意思就是直接以文本方式返回模版生成的文件, 仅供调试
	 * @param model
	 * @param templateName
	 * @param target
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String processTempLateText(Map<String, Object> model, String templateName) throws IOException, TemplateException {
		Template tl = configuration.getTemplate(templateName.endsWith(".ftl") ? templateName : templateName + ".ftl");
		AssertUtils.isNotNull(tl, ExceptionCode.IllegalParamException, "未找到模版[templateName" + templateName + "]");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		tl.process(model, new PrintWriter(baos));
		return new String(baos.toByteArray());
	}
}
