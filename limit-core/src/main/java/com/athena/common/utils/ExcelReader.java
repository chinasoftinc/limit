package com.athena.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.athena.common.context.Constants;

// 去除所有注释的正则: /\*{1,2}[\s\S]*?\*/
public class ExcelReader {

	private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);

	/**
	 * 读取excel内容, 每行一个数组, 所有行放到list中
	 * @param filePath excel路径
	 * @param sheetname 读取表中的sheet名称
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> ReadExcel(String filePath, String sheetname) throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		Workbook workbook = null;
		InputStream is = null;
		Sheet sheet = null;
		try {
			is = new FileInputStream(filePath);
			try {
				workbook = new XSSFWorkbook(is);
			} catch (Exception e1) {
				try {
					is.close();
					is = null;
					is = new FileInputStream(filePath);
					workbook = new HSSFWorkbook(is);
				} catch (IOException e) {
					logger.error("读取excel文件错误\rexcel路径:{}\rsheet:{}\r异常:{}", filePath, sheetname, e.toString());
					throw e;
				}
			}

			if ((sheetname == null) || ("".equals(sheetname))) {
				sheet = workbook.getSheetAt(0);
			} else {
				sheet = workbook.getSheet(sheetname);
			}

			String str = "";
			Row row = null;
			Cell cell = null;
			String[] obj = (String[]) null;
			row = sheet.getRow(0);
			int cellcount = row.getPhysicalNumberOfCells();

			String tableStr = "";
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				if (null != row) {
					obj = new String[cellcount];
					logger.debug("\r");

					String rowStr = "";
					for (int j = 0; j < cellcount; j++) {
						str = "";
						cell = row.getCell(j);
						try {
							if (cell != null) {
								switch (cell.getCellType()) {
								case 1:
									str = cell.getStringCellValue();
									break;
								case 0:
									if (DateUtil.isCellDateFormatted(cell)) {
										double d = cell.getNumericCellValue();

										Date date = DateUtil.getJavaDate(d);

										SimpleDateFormat format = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);

										str = format.format(date);
									} else {
										DecimalFormat df = new DecimalFormat("0");

										str = df.format(cell.getNumericCellValue());
									}

									break;
								default:
									str = "";
								}

							}
							rowStr += str + "\t";
							if (StringUtils.isNotEmpty(str)) {
								str = str.trim();
							}
							obj[j] = str;
						} catch (Exception e) {
							logger.error("读取excel单元格错误\rexcel路径:{}\rsheet:{}\rcell:列{}, 行{}\r异常:{}", filePath, sheetname, cell.getAddress().getColumn(), cell.getAddress().getRow(), e.toString());
						}
					}
					tableStr += rowStr + "\r";
					if (ArrayUtils.isNotEmpty(obj)) {
						list.add(obj);
					}
				}
			}
			logger.debug("\r" + tableStr);
		} catch (Exception e) {
			logger.error("读取excel出错");
			throw e;
		} finally {
			try {
				is.close();
				if (workbook != null) {
					workbook.close();
				}
			} catch (Exception e1) {
				logger.error("释放资源出错");
			}
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		List<String[]> content = ReadExcel("C:\\Users\\niebinxiao\\Desktop\\员工工作日志_聂宾潇.xlsx", "0118~0122");
		for (String[] arr : content) {
			for (String str : arr) {
				System.out.print(str + "\t");
			}
			System.out.println();
		}
	}

}
