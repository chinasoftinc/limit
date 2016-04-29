package com.athena.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 解压缩工具类
 * @author niebinxiao
 */
public class CompressUtils {

	/**
	 * 压缩文件或文件夹到指定位置的压缩文件
	 * @param src
	 * @param dest
	 * @throws Exception
	 */
	public static void compress(File src, File dest) throws Exception {
		TarArchiveOutputStream out = new TarArchiveOutputStream(new FileOutputStream(dest));
		recursionCompress(src, out, null);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 解压文件到指定位置
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void unCompress(File src, File dest) throws IOException {

		// 读取压缩包
		TarArchiveInputStream in = new TarArchiveInputStream(new FileInputStream(src));
		TarArchiveEntry entry = null;
		File file = null;
		while ((entry = in.getNextTarEntry()) != null) {
			file = new File(dest, entry.getName()); // 拼接解压缩文件路径 [这里需要递归创建文件夹了, 操!] 不测试了
			FileOutputStream out = new FileOutputStream(file);
			IOUtils.copy(in, out);
			out.close();
		}
		in.close();
	}

	// 递归打包辅助类
	private static void recursionCompress(File src, TarArchiveOutputStream out, String topDir) throws Exception {
		// 需要将文件遍历, 一个一个按规则加入tarOut
		if (src.listFiles().length == 0) {
			return;
		} else if (StringUtils.isBlank(topDir)) {
			topDir = src.getName();
		}
		File[] files = src.listFiles();
		for (File file : files) {
			if (!file.isDirectory()) {
				FileInputStream in = new FileInputStream(file);

				String name = file.getPath().substring(file.getPath().indexOf(topDir), file.getPath().length());

				TarArchiveEntry entry = new TarArchiveEntry(file, name);

				out.putArchiveEntry(entry);

				IOUtils.copy(in, out);

				IOUtils.closeQuietly(in);

				out.closeArchiveEntry();
			} else {
				recursionCompress(file, out, topDir);
			}
		}
	}

}
