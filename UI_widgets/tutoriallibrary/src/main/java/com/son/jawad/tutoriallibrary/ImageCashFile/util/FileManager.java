package com.son.jawad.tutoriallibrary.ImageCashFile.util;


public class FileManager {

	public static String getCacheFileSavePath() {
		if (CommonUtil.hasSDCard()) {
			return CommonUtil.getRootFilePath() + "lazyloaddemo/cache/";
		} else {
			return CommonUtil.getRootFilePath() + "lazyloaddemo/cache/";
		}
	}

}
