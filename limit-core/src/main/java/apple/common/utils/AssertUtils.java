package apple.common.utils;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import apple.common.exception.ExceptionCode;
import apple.common.exception.BusinessException;

/**
 * 系统断言工具类
 * @author niebinxiao
 */
public class AssertUtils {

	/**
	 * 断言为真
	 * @param expression 真假表达式
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isTrue(boolean expression, ExceptionCode code, String msg) {
		if (!expression) {
			catched(code, msg);
		}
	}

	/**
	 * 断言为假
	 * @param expression 真假表达式
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isFalse(boolean expression, ExceptionCode code, String msg) {
		if (expression) {
			catched(code, msg);
		}
	}

	/**
	 * 断言集合不为空
	 * @param coll 集合对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotEmptyColl(Collection<?> coll, ExceptionCode code, String msg) {
		if (CollectionUtils.isEmpty(coll)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言集合为空
	 * @param coll 集合对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isEmptyColl(Collection<?> coll, ExceptionCode code, String msg) {
		if (!CollectionUtils.isEmpty(coll)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言Map不为空
	 * @param map Map对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotEmptyMap(Map<?, ?> map, ExceptionCode code, String msg) {
		if (MapUtils.isEmpty(map)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言Map为空
	 * @param map Map对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isEmptyMap(Map<?, ?> map, ExceptionCode code, String msg) {
		if (!MapUtils.isEmpty(map)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言字符串不为空
	 * @param str 字符串对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotEmptyStr(String str, ExceptionCode code, String msg) {
		if (StringUtils.isEmpty(str)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言字符串为空
	 * @param str 字符串对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isEmptyStr(String str, ExceptionCode code, String msg) {
		if (StringUtils.isNotEmpty(str)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象不为空
	 * @param obj 对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotNull(Object obj, ExceptionCode code, String msg) {
		if (obj == null) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象为空
	 * @param obj 对象
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNull(Object obj, ExceptionCode code, String msg) {
		if (obj != null) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象相等
	 * @param obj1 对象1
	 * @param obj2 对象2
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isEqauls(Object obj1, Object obj2, ExceptionCode code, String msg) {
		if (!obj1.equals(obj2)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象不相等
	 * @param obj1 对象1
	 * @param obj2 对象2
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotEqauls(Object obj1, Object obj2, ExceptionCode code, String msg) {
		if (obj1.equals(obj2)) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象是同一个对象
	 * @param obj1 对象1
	 * @param obj2 对象2
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isSelf(Object obj1, Object obj2, ExceptionCode code, String msg) {
		if (obj1 != obj2) {
			catched(code, msg);
		}
	}

	/**
	 * 断言对象不是同一个对象
	 * @param obj1 对象1
	 * @param obj2 对象2
	 * @param code 异常状态码
	 * @param msg 自定义异常消息
	 */
	public static void isNotSelf(Object obj1, Object obj2, ExceptionCode code, String msg) {
		if (obj1 == obj2) {
			catched(code, msg);
		}
	}

	// 捕捉和处理异常
	private static void catched(ExceptionCode code, String msg) {
		if (StringUtils.isBlank(msg))
			// 没有指定异常消息, 抛出异常状态码
			throw new BusinessException(code);
		else
			throw new BusinessException(code, msg);
	}
}
