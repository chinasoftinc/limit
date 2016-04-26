package limit.common.context;

import org.apache.commons.lang.SystemUtils;

/**
 * 系统常量及枚举类
 * @author niebinxiao
 */
public class Constants {

	/** 全日期格式 */
	public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** 短日期格式 */
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

	/** 系统换行符 */
	public static final String LINE_SEPARATOR = SystemUtils.LINE_SEPARATOR;

	/** 操作系统类型: windows/linux/other */
	public static OsName OS_TYPE;

	static {
		// 判断操作系统类型
		String osName = System.getProperty("os.name");
		if (osName.startsWith("Window")) {
			OS_TYPE = OsName.WINDOWS;
		} else if (osName.startsWith("Linux")) {
			OS_TYPE = OsName.LINUX;
		} else {
			OS_TYPE = OsName.OTHER;
		}
	}

	/**
	 * 返回状态枚举超类
	 * @author niebinxiao
	 */
	public interface CommonResult {
		String getCode();

		String getDescription();

		String getMessage();
	}

	/**
	 * 描述:　账户状态注解
	 * @author NieBinxiao
	 */
	public enum LoginStatus implements CommonResult {
		VAILD("1", "启用", "登录成功"), INVAILD("0", "停用", "该账户已停用"), ADMIN("9", "管理员", "欢迎您, 管理员"), ERROR("-1", "不存在或错误", "该账户不存在或密码错误"), EXCEPTION("-2", "登录异常", "登录异常, 请和管理员联系");

		public String code; // code
		public String description; // 说明
		public String message; // 返回提示语

		private LoginStatus(String code, String description, String message) {
			this.code = code;
			this.description = description;
			this.message = message;
		}

		@Override
		public String getCode() {
			return code;
		}

		@Override
		public String getDescription() {
			return description;
		}

		@Override
		public String getMessage() {
			return message;
		}

	}

	/**
	 * 枚举描述:操作系统类型
	 * @author niebinxiao
	 */
	public enum OsName {
		WINDOWS("windows"), LINUX("linux"), OTHER("other");

		public String name;

		private OsName(String name) {
			this.name = name;
		}
	}

	/**
	 * 通用枚举, 是否
	 * @author niebx
	 */
	public enum IsTrue {
		YES("1", "是"), NO("0", "否");

		private IsTrue(String code, String description) {
			this.code = code;
			this.description = description;
		}

		public String code;
		public String description;

	}

	/**
	 * 通用枚举:生效状态
	 * @author NieBinxiao
	 */
	public enum VaildStatus {
		VAILD("1", "生效"), INVAILD("0", "无效");

		public String code;
		public String description;

		private VaildStatus(String code, String description) {
			this.code = code;
			this.description = description;
		}

	}

	/**
	 * 通用枚举:运行状态
	 * @author NieBinxiao
	 */
	public enum RunStatus {
		RUN("1", "运行中"), STOP("0", "停止");

		public String code;
		public String description;

		private RunStatus(String code, String description) {
			this.code = code;
			this.description = description;
		}

	}

	/**
	 * 通用枚举:执行结果
	 * @author NieBinxiao
	 */
	public enum OptResult {
		SUCCESS("1", "成功"), FAILD("0", "失败");

		public String code;
		public String description;

		private OptResult(String code, String description) {
			this.code = code;
			this.description = description;
		}

	}

}
