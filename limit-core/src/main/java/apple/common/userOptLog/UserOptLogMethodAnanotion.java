package apple.common.userOptLog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import apple.common.userOptLog.UserOptAdvice.DML;

/**
 * 用户记录方法切入注解
 * @author niebinxiao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserOptLogMethodAnanotion {

	/**
	 * 操作类型
	 * @return
	 */
	DML DML();

	/**
	 * 操作详细说明
	 * @return
	 */
	String Detail();

}
