package limit.common.utils;

import java.util.Date;

import org.apache.commons.lang.math.NumberRange;

import limit.common.context.Constants;
import limit.common.exception.BusinessException;
import limit.common.exception.ExceptionCode;

/**
 * <pre>
 * 公用检测类, 服务器端验证的相关支持类
 * 
 * 	1. 基于JSR303的javax.validation.constraints类相关的注解说明
 * 		• @Min： 被Min所注解的元素必须是个数字，其值要大于或等于给定的最小值
 * 		• @Max： 被Max所注解的元素必须是个数字，其值要小于或等于给定的最大值
 * 		• @Size： Size表示被注解的元素必须位于给定的最小值和最大值之间。支持Size验证的数据类型有String、Collection（计算集合的大小）、Map以及数组
 * 		• @NotNull： NotNull确保被注解的元素不能为null
 * 		• @Null： Null确保被注解的元素一定为null
 * 		• @Pattern： Pattern确保被注解的元素（String）一定会匹配给定的Java正则表达式
 * END
 */
public class ValidateUtils {

	/**
	 * 说明:　验证时间范围
	 * @param minTimeText 最小时间字符串, 格式 yyyy-MM-dd HH:mm:ss
	 * @param maxTimeText 最大时间字符串, 格式 yyyy-MM-dd HH:mm:ss
	 * @return [true:在范围内]/[false:不在范围内]
	 */
	public static boolean validatorTimeRange(Date date, String minTimeText, String maxTimeText) {
		Date minDate = DateUtils.text2Date(minTimeText, Constants.FULL_DATE_FORMAT);
		Date maxDate = DateUtils.text2Date(maxTimeText, Constants.FULL_DATE_FORMAT);
		if (minDate.compareTo(date) != 1 && maxDate.compareTo(date) != -1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 说明:　检测数值是否在某个指定的范围内<br>
	 * 包含头和尾
	 * @param min 最小范围值
	 * @param max 最大范围值
	 * @param compare 比较值
	 * @return
	 */
	public static <T extends Number> boolean test(T min, T max, T compare) {
		NumberRange nr = new NumberRange(min, max);
		return nr.containsNumber(compare);
	}

	/**
	 * 正则表达式工具类
	 * @author niebinxiao
	 */
	public static class RegexUtils {

		/** 邮箱正则 */
		public static final String EMAIL_REGEX = "^^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

		/** 手机号码正则 */
		public static final String PHONE_REGEX = "^1[3|4|5|8][0-9]\\d{8}$";

		/**
		 * 中英文数字混输正则
		 * @param min
		 * @param max
		 * @return
		 */
		public static String regex_zh_en_num(Integer min, Integer max) {
			if (min != null && max != null && min >= 0 && max > min) {
				return "^[\u4E00-\u9FA5A-Za-z0-9_]{" + min + "," + max + "}$";
			} else {
				throw new BusinessException(ExceptionCode.IllegalParamException, "指定长度范围的参数不正确");
			}
		}

		/**
		 * 英文数字混输正则
		 * @param min
		 * @param max
		 * @return
		 */
		public static String regex_en_num(Integer min, Integer max, boolean startsWithEn) {
			StringBuilder builder = new StringBuilder();
			if (min != null && max != null && min >= 0 && max > min) {
				if (startsWithEn) {
					builder.append("[a-zA-Z]{1}");
				}
				builder.append("^([a-zA-Z0-9]|[_]){" + min + "," + max + "}$");
				return new String(builder);
			} else {
				throw new BusinessException(ExceptionCode.IllegalParamException, "指定长度范围的参数不正确");
			}
		}

		/**
		 * 中文正则
		 * @param min
		 * @param max
		 * @return
		 */
		public static String regex_zh(Integer min, Integer max) {
			if (min != null && max != null && min >= 0 && max > min) {
				return "^[^u4E00-u9FA5]{" + min + "," + max + "}$";
			} else {
				throw new BusinessException(ExceptionCode.IllegalParamException, "指定长度范围的参数不正确");
			}
		}
	}

}
