package apple.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.fusesource.hawtbuf.ByteArrayInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import apple.common.exception.BusinessException;
import apple.common.exception.ExceptionCode;

public class FTPUtils {
	private static final Logger logger = LoggerFactory.getLogger(FTPUtils.class);

	private static final int DEFAULT_BUFFER_SIZE = 1024;

	private static final String DEFAULT_CHARSET = "UTF-8";

	private static final int DEFAULT_TIME_OUT = 3000;

	/**
	 * 获取ftp连接
	 * @param hostname 主机名称
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws IOException
	 */
	public static FTPClient getConnection(String hostname, String username, String password) throws IOException {
		FTPClient client = new FTPClient();
		try {
			client.connect(hostname);
			client.setBufferSize(DEFAULT_BUFFER_SIZE);
			client.setConnectTimeout(DEFAULT_TIME_OUT);
			client.setDataTimeout(DEFAULT_TIME_OUT);
			client.setControlEncoding(DEFAULT_CHARSET);
			client.enterLocalPassiveMode();
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.login(username, password);
			logger.info("连接ftp成功;\r hostname:{}, username:{}, passwordd:{}", username, hostname, password);

		} catch (IOException e) {
			logger.error("连接ftp失败;\r hostname:{}, username:{}, passwordd:{}\r异常:{}", username, hostname, password, e.toString());
			throw e;
		}
		return client;
	}

	/**
	 * 释放连接
	 * @param client
	 */
	public static void releaseConnection(FTPClient client) {
		try {
			if (null != client && client.isConnected()) {
				client.logout();
				client.disconnect();

				logger.info("释放ftp连接成功; host:{}", client.getPassiveHost());
			} else {
				client = null;
			}
			// 关闭需要关闭的流 IOUtils.closeQuietly(stream);
		} catch (IOException e) {
			logger.error("释放连接异常");
		}
	}

	/**
	 * 列出指定目录下的所有文件及目录 [不包括子目录]
	 * @param path 目录路径
	 * @return
	 * @throws IOException
	 */
	public static FTPFile[] listPathFile(String path, FTPClient client) throws IOException {
		return client.listFiles(path);
	}

	/**
	 * 下载文件
	 * @param path 文件地址
	 * @param os 目标输出流
	 * @throws IOException
	 */
	public static void downLoadFile(String path, OutputStream os, FTPClient client) throws IOException {
		client.retrieveFile(path, os);
	}

	/**
	 * http下载文件
	 * @param response
	 * @param ftpFilePath
	 * @param fileName
	 */
	public static void downLoadFileFromFtp(HttpServletResponse response, String path, String fileName, FTPClient client) {
		try {
			fileName = URLEncoder.encode(fileName, DEFAULT_CHARSET);
			response.reset();
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			OutputStream repOS = null;
			repOS = response.getOutputStream();
			downLoadFile(path, repOS, client);
			repOS.flush();
		} catch (IOException e) {
			logger.error("下载文件出错; 目录:{}, 文件名:{}, 主机:{}, \r异常:{}", path, fileName, client.getPassiveHost(), e);
			throw new BusinessException(ExceptionCode.DownloadFileException, "下载文件失败");
		}
	}

	/**
	 * 上传文件
	 * @param savepath 保存路径
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static boolean uploadFile(String savepath, String fileName, InputStream in, FTPClient client) throws IOException {
		if (mkdir(savepath, client) && client.changeWorkingDirectory(savepath))
			return client.storeFile(fileName, in);
		else
			logger.error("文件上传失败或创建目录异常; \r保存路径:{}, 文件名称:{}, 目标主机:{}", savepath, fileName, client.getPassiveHost());
		return false;
	}

	/**
	 * 删除文件或文件夹
	 * @param path
	 * @return 是否成功
	 * @throws
	 * @throws IOException
	 */
	public static boolean remove(String path, FTPClient client) throws IOException {
		return recusionRemovePath(client.listFiles(path), path, client);
	}

	/**
	 * 递归删除文件及文件夹
	 * @param files
	 * @param path
	 * @param client
	 * @throws IOException
	 * @throws Exception
	 */
	private static boolean recusionRemovePath(FTPFile[] files, String path, FTPClient client) throws IOException {
		if (ArrayUtils.isNotEmpty(files)) {
			for (FTPFile file : files) {
				if (file.isDirectory()) {
					recusionRemovePath(client.listFiles(path + "/" + file.getName()), path + "/" + file.getName(), client);
					boolean isDelete = client.removeDirectory(path + "/" + file.getName());
					if (isDelete) {
						logger.info("删除ftp文件夹成功; 路径: {}, 文件夹: {}, 主机:{}", path, file.getName(), client.getPassiveHost());
					} else {
						logger.info("删除ftp文件夹失败; 路径: {}, 文件夹: {}, 主机:{}", path, file.getName(), client.getPassiveHost());
						return false;
					}
				} else {
					boolean isDelete = client.deleteFile(path + "/" + file.getName());
					if (isDelete) {
						logger.info("删除ftp文件成功; 路径: {}, 文件: {}, 主机:{}", path, file.getName(), client.getPassiveHost());
					} else {
						logger.info("删除ftp文件失败; 路径: {}, 文件: {}, 主机:{}", path, file.getName(), client.getPassiveHost());
						return false;
					}
				}
			}
		}
		return client.removeDirectory(path) || client.deleteFile(path);
	}

	/**
	 * 递归创建目录
	 * @param createPath 格式: 'a/b/c' || '/a/b/c' || '/'
	 * @return
	 * @throws IOException
	 */
	public static boolean mkdir(String createPath, FTPClient client) throws IOException {
		// 根目录不用创建
		if (createPath.equalsIgnoreCase("/"))
			return true;
		// 去除开头的/
		if (createPath.startsWith("/"))
			createPath = createPath.substring(1, createPath.length());

		String[] arr = createPath.split("/");
		for (String path : arr) {
			if (!client.changeWorkingDirectory(path)) {
				client.mkd(path);
				boolean isChange = client.changeWorkingDirectory(path);
				if (!isChange) {
					return false;
				}

			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		uploadFile("~", "test.txt", new ByteArrayInputStream("呵呵".getBytes()), getConnection("172.18.173.197", "channel_ftpuser", "rootq1w2E#R$"));

		FTPFile[] fs = listPathFile("~", getConnection("172.18.173.197", "channel_ftpuser", "rootq1w2E#R$"));

		for (FTPFile f : fs) {
			System.out.println(f.getName());
		}
	}
}
