package apple.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcleExport<T> {

	private static final Logger logger = LoggerFactory.getLogger(ExcleExport.class);
	private static final short DEFAULT_CELL_WIDTH = (short) 30, DEFAULT_FONT_COLOR = 0x8, DEFAULT_FONT_HEIGHT = 12, DEFAULT_FONT_BOLD = 0x1bc, DEFAULT_BACKGROUND_COLOR = 0x2b, DEFAULT_ALIGN = Align.CENTER.code;
	private static final String DEFAULT_DATE_FORMATTER = "yyyy年MM月dd日 hh时MM分ss秒";

	public enum Align {

		LEFT((short) 0x1, "左对齐"), CENTER((short) 0x2, "居中"), RIGHT((short) 0x3, "右对齐");

		public short code;
		public String desc;

		private Align(short code, String desc) {
			this.desc = desc;
			this.code = code;
		}

	}

	private short $columWidth = DEFAULT_CELL_WIDTH, $fontColor = DEFAULT_FONT_COLOR, $fontHeight = DEFAULT_FONT_HEIGHT, $fontBold = DEFAULT_FONT_BOLD, $headfontColor = DEFAULT_FONT_COLOR, $headfontHeight = DEFAULT_FONT_HEIGHT, $headfontBold = DEFAULT_FONT_BOLD, $headBackgroundColor = DEFAULT_BACKGROUND_COLOR, $backgroundColor = DEFAULT_BACKGROUND_COLOR, $align = DEFAULT_ALIGN;

	private String $title, $dateFormatter = DEFAULT_DATE_FORMATTER, $booleanTrue = "true", $booleanFalse = "false";

	private HSSFWorkbook $workbook;

	private String[] $heads;

	public ExcleExport() {
		$workbook = new HSSFWorkbook();
	}

	/**
	 * 设置boolean值展示
	 * @param trueStr
	 * @param falseStr
	 * @return
	 */
	public ExcleExport<T> setBooleanShow(String trueStr, String falseStr) {
		this.$booleanFalse = falseStr;
		this.$booleanTrue = trueStr;
		return this;
	}

	/**
	 * 设置日期格式
	 * @param dateFormatter
	 * @return
	 */
	public ExcleExport<T> setDateFormatter(String dateFormatter) {
		this.$dateFormatter = dateFormatter;
		return this;
	}

	/**
	 * 设置单元格对其方式
	 * @param align
	 * @return
	 */
	public ExcleExport<T> setAlign(Align align) {
		this.$align = align.code;
		return this;
	}

	/**
	 * 设置表格名称
	 * @param heads
	 * @return
	 */
	public ExcleExport<T> setTitle(String title) {
		this.$title = title;
		return this;
	}

	/**
	 * 设置表头文字
	 * @param heads
	 * @return
	 */
	public ExcleExport<T> setHeads(String[] heads) {
		this.$heads = heads;
		return this;
	}

	/**
	 * 设置表格宽度
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setColumnWidth(short value) {
		$columWidth = value;
		return this;
	}

	/**
	 * 设置字体颜色
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setFontColor(short value) {
		$fontColor = value;
		return this;
	}

	/**
	 * 设置字体高度
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setFontHeight(short value) {
		$fontHeight = value;
		return this;
	}

	/**
	 * 设置字体宽度
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setFontBold(short value) {
		$fontBold = value;
		return this;
	}

	/**
	 * 设置表头颜色
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setHeadFontColor(short value) {
		$headfontColor = value;
		return this;
	}

	/**
	 * 设置表头字体高度
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setHeadFontHeight(short value) {
		$headfontHeight = value;
		return this;
	}

	/**
	 * 设置表头字体宽度
	 * @param value
	 * @return
	 */
	public ExcleExport<T> setHeadFontBold(short value) {
		$headfontBold = value;
		return this;
	}

	/**
	 * 下载excel
	 * @param dataset
	 * @param response
	 * @throws IOException
	 */
	public void downLoadExcel(Collection<T> dataset, HttpServletResponse response) throws IOException {
		response.reset();
		response.resetBuffer();
		response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode($title, "UTF-8"))));
		response.setHeader("Connection", "close");
		response.setHeader("Content-Type", "application/vnd.ms-excel");
		this.exportExcel(dataset, response.getOutputStream());
		response.getOutputStream().flush();
		response.flushBuffer();

	}

	/**
	 * 转换为excel并输出通道
	 * @param dataset [必须标准的JavaBean集合]
	 * @param out [输出通道]
	 */
	public void exportExcel(Collection<T> dataset, OutputStream out) {

		HSSFSheet sheet = $workbook.createSheet($title);
		sheet.setDefaultColumnWidth($columWidth);

		// content style
		HSSFCellStyle contentStyle = $workbook.createCellStyle();
		contentStyle.setFillForegroundColor($backgroundColor);
		buildBorder(contentStyle);
		contentStyle.setAlignment($align);
		contentStyle.setVerticalAlignment($align);
		HSSFFont contentFont = $workbook.createFont(); // content font
		contentFont.setColor($fontColor);
		contentFont.setFontHeightInPoints($fontHeight);
		contentFont.setBoldweight($fontBold);
		contentStyle.setFont(contentFont);

		// head style
		HSSFCellStyle headStyle = $workbook.createCellStyle();
		headStyle.setFillForegroundColor($headBackgroundColor);
		buildBorder(headStyle);
		headStyle.setAlignment($align);
		HSSFFont headFont = $workbook.createFont(); // head font
		headFont.setColor($headfontColor);
		headFont.setFontHeightInPoints($headfontHeight);
		headFont.setBoldweight($headfontBold);
		headStyle.setFont(headFont);

		// heads
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < $heads.length && ArrayUtils.isNotEmpty($heads); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(headStyle);
			HSSFRichTextString text = new HSSFRichTextString($heads[i]);
			cell.setCellValue(text);
		}

		// content row
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			row = sheet.createRow(++index);
			T t = (T) it.next();

			// 反射取值
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(contentStyle);
				Field field = fields[i];
				String fieldName = field.getName();

				String getMethodName = "get" + StringUtils.capitalize(fieldName);
				try {
					Class<?> tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					if (getMethod == null) {
						getMethod = tCls.getMethod(fieldName, new Class[] {});
						if (getMethod == null) {
							logger.info("未找到字段: '{}' 的GET方法, 跳过解析", fieldName);
							continue;
						}
					}
					Object value = getMethod.invoke(t, new Object[] {});

					// 根据类型处理
					String textValue = null;
					if (value instanceof Boolean) {
						textValue = (Boolean) value ? $booleanTrue : $booleanFalse;

					} else if (value instanceof Date) {
						textValue = new DateTime((Date) value).toString($dateFormatter);

					} else if (value instanceof byte[]) {
						textValue = "不支持的内容格式";

					} else {
						textValue = value.toString();

					}

					// 数字统一double
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(textValue);
							richString.applyFont(contentFont);
							cell.setCellValue(richString);
						}
					}

				} catch (ReflectiveOperationException e) {
					logger.error("bean转换xls, 字段解析出错/rexp:{}", e);
				} finally {
					IOUtils.closeQuietly($workbook);
				}
			}
		}
		try {
			$workbook.write(out);
		} catch (IOException e) {
			logger.error("解析javaBean集合为excel出错/rexp: {}", e);
		}
	}

	// 统一的边框样式
	private void buildBorder(HSSFCellStyle style) {
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	}

	static class People {
		private long id;
		private String name;
		private int age;
		private Date birthday;
		private boolean isDied;
		private double cash;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public boolean getIsDied() {
			return isDied;
		}

		public void setIsDied(boolean isDied) {
			this.isDied = isDied;
		}

		public double getCash() {
			return cash;
		}

		public void setCash(double cash) {
			this.cash = cash;
		}

		public People(long id, String name, int age, Date birthday, boolean isDied, double cash) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.birthday = birthday;
			this.isDied = isDied;
			this.cash = cash;
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.home") + "\\Desktop\\test.xls"));
		List<People> dataset = Arrays.asList(new People(320121199110041130L, "聂宾潇", 26, new Date(), false, 25000.05), new People(320121199110041130L, "庾澄庆", 31, new Date(), false, 25000.05), new People(320121199110041130L, "刘德华", 56, new Date(), true, 99999999.05));
		new ExcleExport<People>().setHeads(new String[] { "第1列", "第2列", "第3列", "第4列", "第5列", "第6列", }).setTitle("test.xls").setAlign(Align.CENTER).exportExcel(dataset, out);
	}
}