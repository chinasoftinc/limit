package usecase.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-test.xml")
@TransactionConfiguration(defaultRollback = true)
public class BaseUsecase extends AbstractTransactionalJUnit4SpringContextTests {

	// 数据文件位置
	private static final String ROOT_DIR = System.getProperty("user.dir") + "/src/test/resource/dataSet/";

	@Autowired
	private DataSource dataSource;

	private static IDatabaseConnection iDBConnection;

	private File tempFile;

	@Before
	public void init() throws DatabaseUnitException, Exception {
		iDBConnection = new DatabaseConnection(dataSource.getConnection());
		// 配置数据库操作类型
		iDBConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
	}

	/**
	 * 读取xml数据插入到数据库
	 * @param xmlName
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws DatabaseUnitException
	 */
	protected void getXmlDataSet(String xmlName) throws IOException, DatabaseUnitException, SQLException {
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		// 根据第一行展现出来的表结构，自动将别的行的列补齐
		builder.setColumnSensing(true);
		IDataSet dataSet = builder.build(new FileInputStream(new File(ROOT_DIR + xmlName)));
		dataSet = replacementDataSet(dataSet);
		DatabaseOperation.INSERT.execute(iDBConnection, dataSet);
	}

	/**
	 * 读取xls数据, 并插入到数据库
	 * @deprecated
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws DatabaseUnitException
	 */
	protected void getXlsDataSet(String name) throws SQLException, IOException, DatabaseUnitException {
		XlsDataSet dataSet = new XlsDataSet(new FileInputStream(new File(ROOT_DIR + name)));
		DatabaseOperation.INSERT.execute(iDBConnection, dataSet);
	}

	/**
	 * 备份db所有表到临时文件
	 * @throws Exception
	 */
	protected void backupAlltables() throws Exception {
		IDataSet ds = iDBConnection.createDataSet();
		tempFile = File.createTempFile("temp", "xml");
		FlatXmlDataSet.write(ds, new FileWriter(tempFile), "UTF-8");
	}

	/**
	 * 备份指定表到临时文件
	 * @Title: backupCustom
	 * @param tableName
	 * @throws Exception
	 */
	protected void backupTables(String... tableName) throws Exception {
		QueryDataSet qds = new QueryDataSet(iDBConnection);
		for (String str : tableName) {
			qds.addTable(str);
		}
		tempFile = File.createTempFile("temp", "xml");
		FlatXmlDataSet.write(qds, new FileWriter(tempFile), "UTF-8");
	}

	/**
	 * 从临时文件恢复数据
	 * @Title: rollback
	 * @throws Exception
	 */
	protected void rollback() throws Exception {
		if (tempFile.exists() && tempFile.canRead()) {
			FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
			// 根据第一行展现出来的表结构，自动将别的行的列补齐
			builder.setColumnSensing(true);
			IDataSet ds = builder.build(new FileInputStream(tempFile));
			DatabaseOperation.CLEAN_INSERT.execute(iDBConnection, ds);
		}
	}

	/**
	 * 空字符转义
	 * @param dataSet
	 * @return
	 */
	protected ReplacementDataSet replacementDataSet(IDataSet dataSet) {
		ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
		replacementDataSet.addReplacementObject("[null]", null);
		replacementDataSet.addReplacementObject("null", null);
		return replacementDataSet;
	}

	@After
	public void destory() throws SQLException {
		if (iDBConnection != null)
			iDBConnection.close();
	}

}
