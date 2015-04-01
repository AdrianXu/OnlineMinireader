/**
 * 
 */
package com.bdqn.minitxt.novel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.bdqn.minitxt.common.ServerConstant;

/**
 * @ClassName: Novel
 * @主题：在线迷你阅读器
 * @Description: 小说类
 * @author Adrian Xu
 * @date 2014年3月25日 下午4:22:22
 * 
 */
public class Novel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;// 小说名
	private String author;// 作者
	private String introduction;// 简介
	private String catogory;// 类别1.武侠2.言情
	private String status;// 在线阅读txt；3.下载TXT；2.上传TXT；1.返回；0.显示列表；
	private String sourceDirectory;// 小说源路径
	private String targetDirectory;// 小说目标路径
	private boolean result;// true：成功 false：失败
	private int downloadTimes;// 下载次数
	private Date downloadTime;// 最后下载时间
	private Date updateTime;// 上传时间
	private Set<Novel> novels = new LinkedHashSet<>();// 根据小说分类查询
	private String partContent;// 下载时部分内容

	public Novel() {
		super();
	}

	public Novel(String name, String author, String introduction,
			String catogory, String status, String sourceDirectory,
			String targetDirectory, int downloadTimes, Date downloadtime,
			Date updateTime) {
		super();
		this.name = name;
		this.author = author;
		this.introduction = introduction;
		this.catogory = catogory;
		this.status = status;
		this.sourceDirectory = sourceDirectory;
		this.targetDirectory = targetDirectory;
		this.downloadTimes = downloadTimes;
		this.downloadTime = downloadtime;
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCatogory() {
		return catogory;
	}

	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSourceDirectory() {
		return sourceDirectory;
	}

	public void setSourceDirectory(String sourceDirectory) {
			this.sourceDirectory = sourceDirectory;
	}

	public String getTargetDirectory() {
		return targetDirectory;
	}

	public void setTargetDirectory(String targetDirectory) {
		if (targetDirectory.indexOf("\\") != -1||targetDirectory.indexOf("/") != -1
				&& targetDirectory.substring(targetDirectory.length() - 4,
						targetDirectory.length()).equals(".txt")) {
			this.targetDirectory = targetDirectory;
		}else{
			System.out.println("文件路径不对，使用默认路径");
			this.targetDirectory=ServerConstant.DEFAULT_FILE_PATH+name+".txt";
		}
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public Date getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(Date downloadtime) {
		this.downloadTime = downloadtime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Set<Novel> getNovels() {
		return novels;
	}

	public void setNovels(Set<Novel> novels) {
		this.novels = novels;
	}

	public String getPartContent() {
		return partContent;
	}

	public void setPartContent(String partContent) {
		this.partContent = partContent;
	}

}
