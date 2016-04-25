package apple.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinyinUtils {

	private static Logger logger = LoggerFactory.getLogger(PinyinUtils.class);

	/**
	 * 获取字符串的全拼首首字母集合
	 * @author nbx
	 * @date 2015年1月22日 下午3:14:51
	 * @param str
	 * @return
	 */
	public static String getFirstPinyin(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	/**
	 * 根据指定字段对集合中的对象进行排序 [排序规则: 英文按字典顺序排序, 中文取首字母再按字典顺序排序]
	 * @param objects
	 * @param fieldName
	 * @return
	 */
	public static <T> List<T> sortObjectsByFirstPinyin(Collection<T> objects, final String fieldName) {

		List<T> list = new ArrayList<T>(objects);
		Collections.sort(list, new Comparator<T>() {

			@Override
			public int compare(T t1, T t2) {
				try {
					Field field1 = t1.getClass().getDeclaredField(fieldName);
					field1.setAccessible(true);
					Field field2 = t2.getClass().getDeclaredField(fieldName);
					field2.setAccessible(true);
					return getFirstPinyin(field1.get(t1).toString()).compareTo(getFirstPinyin(field2.get(t2).toString()));
				} catch (Exception e) {
					logger.error(e.toString());
				}
				return 0;
			}
		});

		return list;
	}

}
