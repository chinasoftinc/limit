package com.athena.common.context;

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

	/**
	 * 通用枚举:移动方向
	 * @author niebinxiao
	 */
	public enum Direction {
		UP, DOWN;
	}

	/**
	 * 通用枚举: 是否删除
	 * @author niebinxiao
	 */
	public enum IS_DEL {
		DELED("1"), NOT("0");

		public String code;

		private IS_DEL(String code) {
			this.code = code;
		}
	}

	/**
	 * 用户模块常量
	 * @author niebinxiao
	 */
	public static class UserModel {

		/**
		 * 是否登录
		 * @author niebinxiao
		 */
		public enum IsLogin {
			LOGIN("1"), NOT("0");

			public String code;

			private IsLogin(String code) {
				this.code = code;
			}
		}

		/**
		 * 描述: 账户状态注解
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
	}

	/**
	 * 部门模块常量
	 * @author niebinxiao
	 */
	public static class DepartmentModel {

		/**
		 * 一级路径深度
		 */
		public static final short TOP_DEEP = 0;

		/**
		 * 类型
		 * @author niebinxiao
		 */
		public enum Type {
			DEPARTMENT("1"), ORG("0");

			public String code;

			private Type(String code) {
				this.code = code;
			}

		}
	}

	/**
	 * 日志模块常量
	 * @author niebinxiao
	 */
	public static class loggerModel {

		/**
		 * 操作类型
		 */
		public enum OptorType {
			insert("0"), edit("1"), remove("2");

			private OptorType(String code) {
				this.code = code;
			}

			public String code;

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}
		}

		/**
		 * 实体类型名称
		 * @author niebinxiao
		 */
		public enum EntityName {
			user("user", "用户管理"), department("department", "组织机构"), role("role", "角色管理");

			public String code;
			public String name;

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			private EntityName(String code, String name) {
				this.code = code;
				this.name = name;
			}

		}
	}

	/**
	 * 地区模块常量
	 * @author niebinxiao
	 */
	public static class AreaModel {

		/**
		 * 一级路径深度
		 */
		public static final short TOP_DEEP = 0;
	}

	/**
	 * 字典参数模块常量
	 * @author niebinxiao
	 */
	public static class DictionaryModel {

		/**
		 * 一级路径深度
		 */
		public static final short TOP_DEEP = 0;

		/**
		 * 字典类型
		 * @author niebinxiao
		 */
		public enum Type {
			DICTIONARY_GROUP("2"), DICTIONARY("1"), PARAMETER("0");

			public String code;

			private Type(String code) {
				this.code = code;
			}

		}

		/**
		 * 是否是目录
		 * @author niebinxiao
		 */
		public enum IsDir {
			YES("1"), NO("0");

			public String code;

			private IsDir(String code) {
				this.code = code;
			}

		}
	}

}
