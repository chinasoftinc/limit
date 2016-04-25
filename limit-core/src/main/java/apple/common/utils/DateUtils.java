package apple.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:　日期工具类
 * @author NieBinxiao
 */
public class DateUtils {

	/**
	 * 将日期字符串按对应格式化转化为日期
	 * @param dateText
	 * @param formatterPattren
	 * @return
	 */
	public static Date text2Date(String dateText, String formatterPattren) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatterPattren);
		try {
			return formatter.parse(dateText);
		} catch (ParseException e) {
			throw new RuntimeException("字符串转换日期出现错误");
		}
	}

	/**
	 * 将日期按格式化转化为日期字符串
	 * @param date
	 * @param formatterPattren
	 * @return
	 */
	public static String date2String(Date date, String formatterPattren) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatterPattren);
		return formatter.format(date);
	}

	/**
	 * 将毫秒值转化为日期字符
	 * @param currentMillis
	 * @param formatterPattern
	 * @return
	 */
	public static String millis2String(Long currentMillis, String formatterPattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatterPattern);
		return formatter.format(new Date(currentMillis));
	}

}
