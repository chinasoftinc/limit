package com.athena.common.context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.athena.common.exception.BusinessException;
import com.athena.common.exception.ExceptionCode;
import com.athena.common.utils.AssertUtils;
import com.athena.module.areas.model.Area;
import com.athena.module.areas.service.AreaService;
import com.athena.module.dictionaries.model.Dictionary;
import com.athena.module.dictionaries.service.DictionaryService;

/**
 * 系统上下文 参数, 选项字典, 地区 freemarker视图变量, 以及程序调用
 * @author niebinxiao
 */
@Component
public class DictionaryProvider {
	public static final String USER_SESSION_KEY = "user";

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private AreaService areaService;

	// 服务器地址
	@Value("${server_host}")
	public String hostAddress;

	/**
	 * 根据选项字典组名称获取子选项集合
	 * @param name 选项组名称
	 * @return
	 */
	public List<Dictionary> getDictionaries(String name) {
		AssertUtils.isNotEmptyStr(name, ExceptionCode.IllegalParamException, "选项字典组名称不能为空");
		List<Dictionary> dicOptions = dictionaryService.selectDictionaries(name);
		AssertUtils.isNotEmptyColl(dicOptions, ExceptionCode.IllegalParamException, "没有找到[选项组名称为: " + name + "]对应的子选项");
		return dicOptions;
	}

	/**
	 * 获取指定选项组名称指定散列键的散列值
	 * @param name 选项组名称
	 * @param key 选项key
	 */
	public String getDictioanryValue(String name, Object key) {
		AssertUtils.isNotEmptyStr(name, ExceptionCode.IllegalParamException, "选项字典组名称不能为空");
		AssertUtils.isNotNull(key, ExceptionCode.IllegalParamException, "选项key不能为空");
		String value = dictionaryService.getDictionaryValue(name, String.valueOf(key));
		AssertUtils.isNotEmptyStr(value, ExceptionCode.IllegalParamException, "没有找到[选项组名称为: " + name + ", 散列键为:[" + key + "]]对应的选项散列值");
		return value;
	}

	/**
	 * 根据参数键获取参数值
	 * @param key 参数键
	 * @return
	 */
	public String getParameterValue(String key) {
		AssertUtils.isNotEmptyStr(key, ExceptionCode.IllegalParamException, "参数键不能为空");
		String value = dictionaryService.getParameterValue(key);
		AssertUtils.isNotEmptyStr(value, ExceptionCode.IllegalParamException, "没有找到[参数键为:[" + key + "]]对应的参数值");
		return value;
	}

	/**
	 * 根据地区id获取地区名称
	 * @param id 地区id
	 * @return
	 */
	public String getAreaName(BigDecimal id) {
		AssertUtils.isNotNull(id, ExceptionCode.IllegalParamException, "地区id不能为空");
		Area area = areaService.selectByPrimaryKey(id);
		AssertUtils.isNotNull(area, ExceptionCode.IllegalParamException, "没有找到[id:" + id + "]对应的地区");
		return area.getAreasName();
	}

	/**
	 * 获取指定选项组名称, 替换模型的对应字段的散列键为散列值, 用于页面展示 [基于反射]
	 * @param model 模型
	 * @param name 选项组名称
	 * @param fieldName 字段名
	 */
	public <T> void replaceModelDictionaries(T model, String name, String fieldName) {
		try {
			Field field = model.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			
			// 根据选项组名称和字段反射出的散列键查询散列值
			String value = getDictioanryValue(name, (String) field.get(model));
			
			// 因为在controller中对缓存中查询出的对象做了替换操作, 所以下一次查询出的对象是替换后的, 这里暂时没好的方式处理 FIXME
			if (StringUtils.isNotEmpty(value)) {
				field.set(model, value);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new BusinessException(ExceptionCode.IllegalParamException, "对[实体类:" + model.getClass() + ", 字段名称为:" + name + "]做字典散列值替换出现异常");
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
			String optionValue = getDictioanryValue(optName, getMethod.invoke(model).toString());
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
