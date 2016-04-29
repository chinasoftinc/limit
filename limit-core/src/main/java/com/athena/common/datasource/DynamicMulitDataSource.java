package com.athena.common.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态多数据源
 * @author Binxiao
 */
public class DynamicMulitDataSource implements DataSource {
	protected static Logger logger = LoggerFactory.getLogger(DynamicMulitDataSource.class);

	public enum SourceType {
		READER, WRITER
	}

	// 请求线程使用的数据源
	public static ThreadLocal<SourceType> currentDataSource = new ThreadLocal<SourceType>();

	// 读写数据源
	private DataSource writerSource, readerSource;

	/**
	 * 获取数据源
	 * @return
	 */
	public DataSource getDataSource() {
		DataSource useSource;
		if (currentDataSource.get() == SourceType.WRITER) {
			useSource = writerSource;
			logger.debug("使用写数据源");
		} else {
			useSource = readerSource;
			logger.debug("使用读数据源");
		}
		currentDataSource.remove();
		return useSource;
	}

	public void setWriterSource(DataSource writerSource) {
		this.writerSource = writerSource;
	}

	public void setReaderSource(DataSource readerSource) {
		this.readerSource = readerSource;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return getDataSource().getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		getDataSource().setLogWriter(out);
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		getDataSource().setLoginTimeout(seconds);
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return getDataSource().getLoginTimeout();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return getDataSource().unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return getDataSource().isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return getDataSource().getConnection(username, password);
	}

	// jdk 1.7 实现方法:
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	}

}
