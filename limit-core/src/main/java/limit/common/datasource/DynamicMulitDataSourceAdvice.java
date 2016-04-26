package limit.common.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 多数据源切面, 读写分离
 * @author niebinxiao
 */
public class DynamicMulitDataSourceAdvice implements InitializingBean {

	protected static Logger logger = LoggerFactory.getLogger(DynamicMulitDataSourceAdvice.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("动态数据源切面加载成功");
	}

	/**
	 * 切入写入方法, 设置写入数据源
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	public Object writeDataSource(ProceedingJoinPoint point) throws Throwable {
		DynamicMulitDataSource.currentDataSource.set(DynamicMulitDataSource.SourceType.WRITER);
		return point.proceed();
	}
}
