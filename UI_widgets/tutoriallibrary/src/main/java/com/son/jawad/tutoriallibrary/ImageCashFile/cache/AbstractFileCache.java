package com.son.jawad.tutoriallibrary.ImageCashFile.cache;

import android.content.Context;
import android.util.Log;

import com.son.jawad.tutoriallibrary.ImageCashFile.util.FileHelper;

import java.io.File;


public abstract class AbstractFileCache {

	private String dirString;
	
	public AbstractFileCache(Context context) {
		
		dirString = getCacheDir();
		boolean ret = FileHelper.createDirectory(dirString);
		Log.i("AbstractFileCache", "FileHelper.createDirectory:" + dirString + ", ret = " + ret);
	}
	
	public File getFile(String url) {
		File f = new File(getSavePath(url));
		return f;
	}
	
	public abstract String getSavePath(String url);
	public abstract String getCacheDir();

	public void clear() {
		FileHelper.deleteDirectory(dirString);
	}

}
