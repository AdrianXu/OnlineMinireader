package com.bdqn.minitxt.novel.dao.impl;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.bdqn.minitxt.common.ServerConstant;
import com.bdqn.minitxt.novel.dao.NovelDao;
import com.bdqn.minitxt.novel.entity.Novel;
import com.bdqn.minitxt.utils.DataFormatUtils;
import com.bdqn.minitxt.utils.FileUtils;
import com.bdqn.minitxt.utils.XMLUtils;

/**
 * 
 * @ClassName: NovelDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @主题：在线迷你阅读器
 * @author Adrian Xu
 * @date 2014年3月25日 下午9:37:37
 * 
 */
public class NovelDaoImpl implements NovelDao {
	private File file = new File(ServerConstant.NOVEL_XML_PATH);
	private Document doc = XMLUtils.getDocument(file);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.novel.dao.NovelDao#saveNovel(com.bdqn.minitxt.novel.
	 * entity.Novel)
	 */
	@Override
	public void saveNovel(Novel novel) {

		Element root = (Element) doc.getRootElement();
		Element levelOne = root.addElement("novel");
		Element name = levelOne.addElement("name");
		name.setText(novel.getName());
		Element author = levelOne.addElement("author");
		author.setText(novel.getAuthor());
		Element introduction = levelOne.addElement("introduction");
		introduction.setText(novel.getIntroduction());
		Element catogory = levelOne.addElement("catogory");
		catogory.setText(novel.getCatogory());
		Element status = levelOne.addElement("status");
		status.setText(novel.getStatus());
		Element sourceDirectory = levelOne.addElement("sourceDirectory");
		sourceDirectory.setText(novel.getSourceDirectory());
		Element targetDirectory = levelOne.addElement("targetDirectory");
		targetDirectory.setText(novel.getTargetDirectory());
		Element downloadTimes = levelOne.addElement("downloadTimes");
		downloadTimes.setText(novel.getDownloadTimes() + "");
		Element downloadtime = levelOne.addElement("downloadTime");
		downloadtime.setText("");
		Element updateTime = levelOne.addElement("updateTime");
		updateTime.setText(DataFormatUtils.getStringFormatDate(novel
				.getUpdateTime()));

		XMLUtils.writeToXml(doc, file);

		// 文件拷贝
		FileUtils.fileCopy(novel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bdqn.minitxt.novel.dao.NovelDao#findNovels(java.lang.String)
	 */
	@Override
	public Set<Novel> findNovels(String catogory) {

		Set<Novel> novels = new LinkedHashSet<>();
		Element root = doc.getRootElement();
		String queryStr = "//novel[catogory='" + catogory + "']";
		@SuppressWarnings("unchecked")
		List<Node> nodes = root.selectNodes(queryStr);
		for (Node node : nodes) {
			Novel novel = new Novel();
			novel.setName(node.selectSingleNode("name").getText());
			novel.setAuthor(node.selectSingleNode("author").getText());
			novel.setIntroduction(node.selectSingleNode("introduction")
					.getText());
			novels.add(novel);
		}
		return novels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.novel.dao.NovelDao#findNovelByName(java.lang.String)
	 */
	@Override
	public boolean findNovelByName(String name) {
		Node novelElement = findSpecialNovel(name);
		if (novelElement != null) {
			return true;
		}
		return false;
	}

	/**
	 * @param name
	 * @return
	 */
	private Node findSpecialNovel(String name) {
		Element root = doc.getRootElement();
		String queryStr = "//novel[name='" + name + "']";
		Node novelElement = root.selectSingleNode(queryStr);
		return novelElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bdqn.minitxt.novel.dao.NovelDao#updataNovel(com.bdqn.minitxt.novel
	 * .entity.Novel)
	 */
	@Override
	public void updataNovel(Novel novel) {
		Node novelElement = findSpecialNovel(novel.getName());
		if (novelElement != null) {
			novelElement.selectSingleNode("status").setText(novel.getStatus());// 修改状态
			if(ServerConstant.NOVEL_DOWNLOAD.equals(novel.getStatus())){
				// 修改下载次数
				Node downloadTimes = novelElement.selectSingleNode("downloadTimes");
				int times = new Integer(downloadTimes.getText());
				downloadTimes.setText(++times + "");
				// 修改下载时间
				novelElement.selectSingleNode("downloadTime")
				.setText(
						DataFormatUtils.getStringFormatDate(novel
								.getDownloadTime()));
				novel.setResult(true);
			}
			XMLUtils.writeToXml(doc, file);
			// 下载时XML文件就变成了源
			novel.setSourceDirectory(novelElement.selectSingleNode(
					"targetDirectory").getText());
			FileUtils.fileCopy(novel);
			novel.setResult(true);
		} else {
			novel.setResult(false);
		}
	}

}
