package apple.common.utils;

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
				// 创建源文件的读取流
				FileInputStream in = new FileInputStream(file);
				// 默认打包后的文件路径是分区根目录开始的, 处理成该文件的根目录
				String name = file.getPath().substring(file.getPath().indexOf(topDir), file.getPath().length());
				// 使用TarArchiveEntry封装文件 (计算该文件的某些信息, 记录该文件的路径, 大小等)
				TarArchiveEntry entry = new TarArchiveEntry(file, name);
				// 将该文件put进tarOut
				out.putArchiveEntry(entry);
				// 在把该文件的内容写入tarOut
				IOUtils.copy(in, out);
				// 释放资源
				IOUtils.closeQuietly(in);
				// tarOut读取该文件entry并释放资源
				out.closeArchiveEntry();
			} else {
				recursionCompress(file, out, topDir);
			}
		}
	}

}
