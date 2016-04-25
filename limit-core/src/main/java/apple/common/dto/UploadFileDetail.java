package apple.common.dto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件详细信息
 * @author niebinxiao
 */
public class UploadFileDetail {

	// 原始文件完整名称
	private String srcFullName;
	// 原始文件去除扩展名名称
	private String srcBaseName;
	// 扩展名(带点)
	private String extNameWithPoint;
	// 新文件完整名称
	private String newFullName;
	// 新文件去除扩展名名称
	private String newBaseName;
	// 新文件完整存储路径
	private String newFileSavePath;
	// 文件上传IO流
	private InputStream inStream;
	// 文件上传后的访问url
	private String accessUrl;

	/**
	 * 通过spring上传文件构建
	 * @param up
	 * @param newName
	 * @param savePathPrefix
	 * @param accessPrefixUrl
	 * @throws IOException
	 */
	public UploadFileDetail(MultipartFile up, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {
		this.buildUploadFileDetail(up, newName, savePathPrefix, accessPrefixUrl);
	}

	/**
	 * 通过系统文件构建
	 * @param up
	 * @param newName
	 * @param savePathPrefix
	 * @param accessPrefixUrl
	 * @throws IOException
	 */
	public UploadFileDetail(File up, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {
		this(new FileSystemResource(up), newName, savePathPrefix, accessPrefixUrl);
	}

	/**
	 * 通过url构建
	 * @param url
	 * @param newName
	 * @param savePathPrefix
	 * @param accessPrefixUrl
	 * @throws IOException
	 */
	public UploadFileDetail(String url, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {
		this(new UrlResource(url), newName, savePathPrefix, accessPrefixUrl);
	}

	/**
	 * 将上传文件存储到指定存储目录
	 * @throws IOException
	 */
	public void save() throws IOException {

		// 上传文件夹
		File dir = new File(FilenameUtils.getFullPathNoEndSeparator(newFileSavePath));

		// 初始化上传文件夹
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		FileUtils.copyInputStreamToFile(inStream, new File(dir, newFullName));
	}

	// 统一资源构建
	private UploadFileDetail(Resource resource, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {
		this.buildUploadFileDetail(resource, newName, savePathPrefix, accessPrefixUrl);
	}

	// 通过资源文件构建
	private void buildUploadFileDetail(Resource resource, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {

		String fileFullName = resource.getFilename();
		this.srcFullName = fileFullName;
		this.srcBaseName = FilenameUtils.getBaseName(fileFullName);
		this.extNameWithPoint = "." + FilenameUtils.getExtension(fileFullName);
		this.newBaseName = newName;
		this.newFullName = newName + this.extNameWithPoint;
		this.newFileSavePath = (savePathPrefix.endsWith("/") ? savePathPrefix : savePathPrefix + "/") + newFullName;
		this.inStream = resource.getInputStream();

		if (StringUtils.isNotEmpty(accessPrefixUrl))
			this.accessUrl = (accessPrefixUrl.endsWith("/") ? accessPrefixUrl : accessPrefixUrl + "/") + newFullName;
	}

	// 通过spring的multiPartFile构建上传文件的详细信息
	private void buildUploadFileDetail(MultipartFile up, String newName, String savePathPrefix, String accessPrefixUrl) throws IOException {

		String fileFullName = up.getOriginalFilename();
		this.srcFullName = fileFullName;
		this.srcBaseName = FilenameUtils.getBaseName(fileFullName);
		this.extNameWithPoint = "." + FilenameUtils.getExtension(fileFullName);
		this.newBaseName = newName;
		this.newFullName = newName + this.extNameWithPoint;
		this.newFileSavePath = (savePathPrefix.endsWith("/") ? savePathPrefix : savePathPrefix + "/") + newFullName;
		this.inStream = up.getInputStream();

		if (StringUtils.isNotEmpty(accessPrefixUrl))
			this.accessUrl = (accessPrefixUrl.endsWith("/") ? accessPrefixUrl : accessPrefixUrl + "/") + newFullName;

	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getSrcFullName() {
		return srcFullName;
	}

	public void setSrcFullName(String srcFullName) {
		this.srcFullName = srcFullName;
	}

	public String getSrcBaseName() {
		return srcBaseName;
	}

	public void setSrcBaseName(String srcBaseName) {
		this.srcBaseName = srcBaseName;
	}

	public String getExtNameWithPoint() {
		return extNameWithPoint;
	}

	public void setExtNameWithPoint(String extNameWithPoint) {
		this.extNameWithPoint = extNameWithPoint;
	}

	public String getNewFullName() {
		return newFullName;
	}

	public void setNewFullName(String newFullName) {
		this.newFullName = newFullName;
	}

	public String getNewBaseName() {
		return newBaseName;
	}

	public void setNewBaseName(String newBaseName) {
		this.newBaseName = newBaseName;
	}

	public String getNewFileSavePath() {
		return newFileSavePath;
	}

	public void setNewFileSavePath(String newFileSavePath) {
		this.newFileSavePath = newFileSavePath;
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}
}
