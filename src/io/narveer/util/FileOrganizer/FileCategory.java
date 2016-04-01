package io.narveer.util.FileOrganizer;

import java.util.ArrayList;
import java.util.Arrays;

public class FileCategory {
	
	static enum CATEGORY {AUDIO, VIDEO, IMAGES, PROGRAMS, DOCUMENTS, CODE, OTHERS};
	
	static ArrayList<String> audioExt = new ArrayList<String>(Arrays.asList("mp3", "flac", "ogg", "wma"));
	static ArrayList<String> videoExt = new ArrayList<String>(Arrays.asList("mp4", "flv", "avi", "webm", "mpeg", "mpg"));
	static ArrayList<String> imagesExt = new ArrayList<String>(Arrays.asList("png", "jpeg", "gif", "bmp", "jpeg"));
	static ArrayList<String> programsExt = new ArrayList<String>(Arrays.asList("exe", "deb", "rpm"));
	static ArrayList<String> documentsExt = new ArrayList<String>(Arrays.asList("txt", "pdf", "doc"));	
	static ArrayList<String> codeExt = new ArrayList<String>(Arrays.asList("java", "py", "c", "cpp", "html", "xml", "rb"));
	
	public static CATEGORY getCategory(String ext) {
			if (audioExt.contains(ext)) {
				return CATEGORY.AUDIO;
			}
			
			if (videoExt.contains(ext)) {
				return CATEGORY.VIDEO;
			}
			
			if (imagesExt.contains(ext)) {
				return CATEGORY.IMAGES;
			}
			
			if (programsExt.contains(ext)) {
				return CATEGORY.PROGRAMS;
			}
			
			if (documentsExt.contains(ext)) {
				return CATEGORY.DOCUMENTS;
			}
			
			if (codeExt.contains(ext)) {
				return CATEGORY.CODE;
			}
			
			return CATEGORY.OTHERS;
	}
}
