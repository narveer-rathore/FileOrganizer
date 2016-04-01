package io.narveer.util.FileOrganizer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOrganizer {
	
	// for testing and debugging
	static final Path SOURCE_DIR = Paths.get("D:\\test");
	static final Path DESTINATION_DIR = Paths.get(SOURCE_DIR.toString() + "\\Organized");
	
	public static void main(String args[]) {
		//System.out.println(SOURCE_DIR.toString());
		//System.out.println(DESTINATION_DIR.toString());
		
		new Handler(SOURCE_DIR, DESTINATION_DIR);
	}
}
