package apple.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import apple.common.exception.ExceptionCode;
import apple.common.exception.BusinessException;

/**
 * 文件操作工具类
 * @author niebinxiao
 */
public class FileUtils {

	/**
	 * 读取文件内容
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readerFile(File file) throws IOException {
		if (file != null && file.isFile()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuffer buffer = new StringBuffer();
			try {
				String line = null;
				while ((line = br.readLine()) != null) {
					buffer.append(line);
				}
			} finally {
				br.close();
			}
			return new String(buffer);
		}
		throw new IOException("\"" + file + "\" 不是有效的文件");
	}

	/**
	 * 列出当前目录中的所有文件
	 * @param rootDir 当前目录
	 * @return
	 */
	public static List<File> listFiles(File root) {
		return listFiles(root, null, false, false);
	}

	/**
	 * 列出当前目录中的所有文件
	 * @param root
	 * @param isRecusion
	 * @return
	 */
	public static List<File> listFiles(File root, boolean isRecusion) {
		return listFiles(root, null, false, isRecusion);
	}

	/**
	 * 列出当前目录中的所有文件
	 * @param root 当前目录
	 * @param filterText 过滤字符
	 * @param isCase 是否大小写敏感
	 * @return
	 */
	public static List<File> listFiles(File root, String filterText, boolean isCase) {
		return listFiles(root, filterText, isCase, false);
	}

	/**
	 * 列出目录中所有文件
	 * @param root 目标目录
	 * @param filter 过滤字符
	 * @param isCase 是否大小写敏感
	 * @param isRecusion 是否递归子目录
	 * @return
	 */
	public static List<File> listFiles(File root, String filter, boolean isCase, boolean isRecusion) {
		List<File> fileList = new ArrayList<File>();

		if (root.exists() && root.isDirectory()) {
			File[] files = null;
			if (StringUtils.isNotBlank(filter)) {
				files = root.listFiles(new SimpleFilter(filter, isCase));
			} else {
				files = root.listFiles();
			}
			if (ArrayUtils.isNotEmpty(files)) {
				for (File file : files) {
					if (!file.isDirectory()) {
						fileList.add(file);
					} else if (isRecusion) {
						List<File> recursionFiles = listFiles(file, filter, isCase, isRecusion);
						if (CollectionUtils.isNotEmpty(recursionFiles)) {
							fileList.addAll(recursionFiles);
						}
					}
				}
			}
			return fileList;
		} else {
			throw new BusinessException(ExceptionCode.IllegalParamException, "文件[名称: " + root.getName() + "]不是有效的目录");
		}
	}

	/**
	 * 文件过滤条件
	 * @author niebinxiao
	 */
	static class SimpleFilter implements FilenameFilter {

		// 文件过滤字符
		private String filter = "";

		// 是否区分大小写
		private boolean isCase = false;

		public SimpleFilter(String filter, boolean isCase) {
			this.filter = filter;
			this.isCase = isCase;
		}

		public boolean accept(File dir, String name) {
			if (StringUtils.isNotEmpty(filter)) {
				if (!isCase) {
					return name.toLowerCase().contains(filter.toLowerCase());
				} else {
					return name.contains(filter);
				}
			}
			return true;
		}

		public String getFilterText() {
			return filter;
		}

		public void setFilterText(String filterText) {
			this.filter = filterText;
		}

		public boolean isCase() {
			return isCase;
		}

		public void setCase(boolean isCase) {
			this.isCase = isCase;
		}

	}

}
