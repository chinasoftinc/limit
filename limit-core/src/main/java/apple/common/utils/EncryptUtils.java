package apple.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import apple.common.exception.ExceptionCode;

/**
 * 加解工具类
 * @author niebinxiao
 */
public class EncryptUtils {

	// 盐值格式
	private static final String SALT_CONPRESS = "{%s}";

	/**
	 * 对字符串进行加密
	 * @param str 需要加密的字符串
	 * @param type 加密的枚举类型
	 * @param salt 盐值 [可为空, 不加盐]
	 * @return
	 */
	public static String encrypt(String str, EncryType type, String salt) {
		AssertUtils.isNotEmptyStr(str, ExceptionCode.IllegalParamException, "加密字符串不能为空");
		AssertUtils.isNotNull(type, ExceptionCode.IllegalParamException, "加密模式不能为空");
		// 如果盐值不为空, 加盐后再加密
		if (StringUtils.isNotEmpty(salt)) {
			str.concat(String.format(SALT_CONPRESS, salt));
		}
		return type.getEncrypt().encrypt(str);
	}

	/**
	 * 加解密实现类型枚举
	 * @author niebinxiao
	 */
	public static enum EncryType {
		/** MD5算法 */
		MD5(new Encrypt() {
			private final Logger logger = LoggerFactory.getLogger(Encrypt.class);
			// 十六进制字节数组
			private final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			// MD5摘要算法实例
			private MessageDigest md5 = init();

			// 初始化MD5摘要实例
			private MessageDigest init() {
				try {
					return MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					logger.error("初始化MD5加密工具类异常\n" + e.toString());
				}
				return md5;
			}

			public String encrypt(String str) {
				// 将明文转化为字符数组
				byte[] bytes = str.getBytes();
				// 使用摘要算法处理字节数组
				md5.update(bytes);
				// 得到密文
				byte[] digest = md5.digest();
				// 密文长度
				int j = digest.length;
				// 创建一个双倍密文长度的字节数组容器装载处理后的字符
				char chars[] = new char[j * 2];
				// 将密文转化为16进制的字符串形式
				int k = 0;
				for (int i = 0; i < j; i++) {
					chars[k++] = hexDigits[digest[i] >>> 4 & 0xf];
					chars[k++] = hexDigits[digest[i] & 0xf];
				}
				return new String(chars);
			}
		}),

		/** SHA算法 */
		SHA(new Encrypt() {
			private final Logger logger = LoggerFactory.getLogger(Encrypt.class);
			// SHA摘要算法实例
			private MessageDigest sha = init();

			// 初始化MD5摘要实例
			private MessageDigest init() {
				try {
					return MessageDigest.getInstance("SHA");
				} catch (NoSuchAlgorithmException e) {
					logger.error("初始化SHA加密工具类异常\n" + e.toString());
				}
				return sha;
			}

			public String encrypt(String str) {
				// 将明文转化为字节数组
				byte[] bytes = str.getBytes();
				// 使用摘要算法处理字节数组
				sha.update(bytes);
				// 获取密文字节数组
				byte[] digest = sha.digest();
				return new String(digest);
			}

		});

		private Encrypt encrypt;

		private EncryType(Encrypt encrypt) {
			this.encrypt = encrypt;
		}

		public Encrypt getEncrypt() {
			return encrypt;
		}

		public void setEncrypt(Encrypt encrypt) {
			this.encrypt = encrypt;
		}
	}

	/**
	 * 加密接口
	 * @author niebinxiao
	 */
	public interface Encrypt {

		/**
		 * 对字符串进行加密
		 * @Author:niebinxiao
		 */
		String encrypt(String str);
	}

	public static void main(String[] args) {

		// md5
		String rs = EncryptUtils.encrypt("123", EncryType.MD5, "123");
		System.out.println(rs);

		// sha
		rs = EncryptUtils.encrypt("123", EncryType.SHA, "123");
		System.out.println(rs);
	}

}
