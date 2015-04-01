package com.bdqn.minitxt.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.bdqn.minitxt.common.ServerConstant;
import com.bdqn.minitxt.novel.entity.Novel;

/**
 * 
 * @ClassName: FileUitls
 * @主题：在线迷你阅读器
 * @Description: 文件操作类
 * @author Adrian Xu
 * @date 2014年3月25日 下午4:19:28
 * 
 */
public class FileUtils {
	/**
	 * 文件拷贝
	 */
	public static void fileCopy(Novel novel) {
		File sourceFile = new File(novel.getSourceDirectory());
		File targetFile = new File(novel.getTargetDirectory());

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(sourceFile)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(targetFile)))) {

			String line;
			StringBuffer partContent=new StringBuffer();
			while ((line = br.readLine()) != null) {
				//小说在线阅读
				if(ServerConstant.NOVEL_ONLINE_READ.equals(novel.getStatus())){
					if(partContent.length()<=ServerConstant.CONTENT_SIZE){
						partContent.append(line+"\n");
					}else{
						break;
					}
				}else{
					bw.write(line);
					bw.newLine();
				}
				novel.setPartContent(partContent.toString());
			}
			bw.flush();
			novel.setResult(true);// 操作成功
		} catch (IOException e) {
			e.printStackTrace();
			novel.setResult(false);// 操作失败
		}
	}

}
