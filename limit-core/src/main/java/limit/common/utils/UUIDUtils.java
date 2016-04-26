package limit.common.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

	/**
	 * 生成随机Long型ID
	 * @return
	 */
	public static Long longId() {
		return Long.parseLong(System.currentTimeMillis() + "" + Math.abs(new Random().nextInt(999999)) + "");
	}

	/**
	 * 生成UUID
	 */
	public static String UUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 生成UUID去除破折号
	 */
	public static String UUIDEXcludeDash() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成UUID只包含数字
	 * @return
	 */
	public static String UUIDOnlyNum() {
		return UUID.randomUUID().toString().replaceAll("[\\-a-z]", "");
	}

	public static void main(String[] args) {
		String a = UUID();
		String b = UUIDEXcludeDash();
		String c = UUIDOnlyNum();
		System.out.println(a + "\r" + b + "\r" + c);
	}

}
