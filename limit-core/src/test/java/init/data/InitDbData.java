package init.data;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.InputSource;

import oracle.jdbc.OracleDriver;

/**
 * 初始数据
 * @author NieBinxiao
 */
public class InitDbData {
	private static final Logger logger = Logger.getLogger(InitDbData.class);

	protected static IDatabaseConnection dbUnitConnection;

	public static void main(String[] args) throws Exception {
		File dataXml = new File(System.getProperty("user.dir") + "/src/test/resources/init/dataConfiguration.xml");
		insertData(dataXml);
	}

	/**
	 * 指定数据xml文件, 插入数据
	 * @param dataSetXmlPath
	 * @throws Exception
	 */
	public static void insertData(File xmlFile) throws Exception {
		connection();
		// 读取xml数据, 组装成数据处理对象
		InputSource is = new InputSource(new FileInputStream(xmlFile));
		FlatXmlProducer xmlProducer = new FlatXmlProducer(is);
		IDataSet set = new FlatXmlDataSet(xmlProducer);
		// 数据集包装类
		ReplacementDataSet rds = new ReplacementDataSet(set);
		rds.addReplacementObject("null", null);
		DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, rds);
		destory();
	}

	// 获取dnunit数据库连接
	private static void connection() throws DatabaseUnitException, Exception {
		Connection con = null;
		Properties prop = new Properties();
		prop.load(new ClassPathResource("jdbc.properties").getInputStream());
		if (prop.size() == 0) {
			throw new RuntimeException("读取jdbc.properties失败");
		}
		DriverManager.registerDriver(new OracleDriver());
		con = DriverManager.getConnection((String) prop.get("datasource.jdbcUrl"), (String) prop.get("datasource.jdbcUserName"), (String) prop.get("datasource.jdbcPassWord"));
		dbUnitConnection = new DatabaseConnection(con, "CHANNEL");
	}

	// 释放操作 释放数据库连接对象
	private static void destory() {
		try {
			if (dbUnitConnection != null)
				dbUnitConnection.close();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

}
