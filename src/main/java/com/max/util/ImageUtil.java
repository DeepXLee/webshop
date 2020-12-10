package com.max.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import com.max.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	
	
	public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\watermark.jpg")), 0.5f)
					.outputQuality(0.8f).toFile(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return relativeAddr;

	}

	/**
	 * 创建目标路径所涉及到的目录,
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}

	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名,当前年月日时分秒+五位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机的五位数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormate.format(new Date());
		return rannum + nowTimeStr;
	}

	public static void main(String[] args) throws IOException {
		Thumbnails
				.of(new File(
						"G:\\BaiduNetdiskDownload\\SSM到Spring Boot-从零开发校园商铺平台\\网站用到的图片集_wosn.net\\images\\test.jpg"))
				.size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\watermark.jpg")), 0.5f)
				.outputQuality(0.8f)
				.toFile("G:\\BaiduNetdiskDownload\\SSM到Spring Boot-从零开发校园商铺平台\\网站用到的图片集_wosn.net\\images\\testnew.jpg");

	}
	
	/**
	 * 判断storePath是文件的路径清空是目录的路径,如果是文件删除该文件,如果是目录删除目录及子文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}

	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(337, 640)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "\\watermark.jpg")), 0.5f)
					.outputQuality(0.9f).toFile(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return relativeAddr;

	}

}
