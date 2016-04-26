package limit.common.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import limit.common.exception.BusinessException;
import limit.common.exception.ExceptionCode;
import limit.common.utils.AssertUtils;
import limit.module.area.model.Area;
import limit.module.area.service.AreaService;
import limit.module.dictionary.model.OptDic;
import limit.module.dictionary.service.OptDicService;

/**
 * <pre>
 * 系统上下文 参数, 选项字典, 地区
 * 注入到freemarker视图变量, 以及程序调用
 * @author niebinxiao
 */
@Component
public class Dictionary {
	public static final String USER_SESSION_KEY = "user";

	@Inject
	private OptDicService optDicService;

	@Inject
	private AreaService areaService;

	// 服务器地址
	@Value("${server_host}")
	public String hostAddress;

	/**
	 * 根据选项字典组名称获取选项字典集合 [一般用于页面下拉select]
	 * @param optName 选项组名称
	 * @return
	 */
	public List<OptDic> getOptDic(String optName) {
		AssertUtils.isNotEmptyStr(optName, ExceptionCode.IllegalParamException, "选项字典组名称不能为空");
		List<OptDic> dicOptions = optDicService.selectOption(optName);
		AssertUtils.isNotEmptyColl(dicOptions, ExceptionCode.IllegalParamException, "没有找到[optName: " + optName + "]对应的选项组");
		return dicOptions;
	}

	/**
	 * 获取指定选项组名称指定子选项key的value展示值 [替换页面中逻辑值为展示值]
	 * @param optName 选项组名称
	 * @param optKey 选项key
	 */
	public String getOptionValue(String optName, Object optKey) {
		AssertUtils.isNotEmptyStr(optName, ExceptionCode.IllegalParamException, "选项字典组名称不能为空");
		AssertUtils.isNotNull(optKey, ExceptionCode.IllegalParamException, "选项key不能为空");
		String value = optDicService.getOptionValue(optName, optKey.toString());
		AssertUtils.isNotEmptyStr(value, ExceptionCode.IllegalParamException, "没有找到[optName: " + optName + ", optKey:[" + optKey + "]]对应的选项值");
		return value;
	}

	/**
	 * 参数获取
	 * @param paramKey 参数key
	 * @return
	 */
	public String getParamValue(String paramKey) {
		AssertUtils.isNotEmptyStr(paramKey, ExceptionCode.IllegalParamException, "参数key不能为空");
		String value = optDicService.getParamValue(paramKey);
		AssertUtils.isNotEmptyStr(value, ExceptionCode.IllegalParamException, "没有找到[paramKey:[" + paramKey + "]]对应的参数值");
		return value;
	}

	/**
	 * 获取地区名称
	 * @param id 地区id
	 * @return
	 */
	public String getAreaName(Long id) {
		AssertUtils.isNotNull(id, ExceptionCode.IllegalParamException, "地区id不能为空");
		Area area = areaService.selectByPrimaryKey(id);
		AssertUtils.isNotNull(area, ExceptionCode.IllegalParamException, "没有找到[id:" + id + "]对应的地区");
		return area.getAreaname();
	}

	/**
	 * 获取指定选项组名称替换model的选项字段值对应的展示值 [基于反射]
	 * @param model
	 * @param optName 选项组名称
	 * @param modelFieldName 字段名
	 */
	public <T> void replaceOptionValue(T model, String optName, String modelFieldName) {
		try {
			Field field = model.getClass().getDeclaredField(modelFieldName);
			field.setAccessible(true);
			// 根据选项组名称和字段反射出的选项key查询选项value
			String optionValue = getOptionValue(optName, (String) field.get(model));
			// 因为在controller中对缓存中查询出的对象做了替换操作, 所以下一次查询出的对象是替换后的, 这里暂时没好的方式处理 FIXME
			if (StringUtils.isNotEmpty(optionValue)) {
				field.set(model, optionValue);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new BusinessException(ExceptionCode.IllegalParamException, "对[class:" + model.getClass() + ", modelFileName:" + optName + "]做字典参数替换出现异常");
		}
	}

	/**
	 * 获取指定选项组名称替换model的选项字段值对应的展示值 [基于get/set方法]
	 * @param model
	 * @param optName 选项组名称
	 * @param getName 字段get方法
	 * @param setName 字段set方法
	 */
	public <T> void replaceOptionValue(T model, String optName, String getName, String setName) {
		try {
			Method getMethod = model.getClass().getMethod(getName);
			// 从选项字典查询出指定字典名称, 指定选项值的选项显示名称
			String optionValue = getOptionValue(optName, getMethod.invoke(model).toString());
			// 因为在controller中对缓存中查询出的对象做了替换操作, 所以下一次查询出的对象是替换后的, 这里暂时没好的方式处理 FIXME
			if (StringUtils.isNotEmpty(optionValue)) {
				Method setMethod = model.getClass().getMethod(setName, String.class);
				setMethod.invoke(model, optionValue);
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new BusinessException(ExceptionCode.IllegalParamException, "对[class:" + model.getClass() + ", modelSettingMethod:" + setName + "]做字典参数替换出现异常");
		}
	}

}
