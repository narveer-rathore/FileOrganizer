package io.narveer.util.FileOrganizer;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// Files.mo
import io.narveer.util.FileOrganizer.FileCategory;
import io.narveer.util.FileOrganizer.FileCategory.CATEGORY;

public class Arrange extends SimpleFileVisitor<Path> {
	static int total;
	static Path dest;
	String ext;
	CATEGORY type;
	
	static String destination;
	
	Arrange(String des) {		
		destination = des;
		total = 0;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {		
		return FileVisitResult.CONTINUE;
	}
	
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (Files.isDirectory(file))
			return FileVisitResult.CONTINUE;
		
		ext = getExtension(file.getFileName().toString());	
		type = FileCategory.getCategory(ext); 
		
		switch (type) {
		case AUDIO:
			dest = Paths.get(destination, "Audio");
			break;
		case VIDEO:
			dest = Paths.get(destination, "Video");
			break;
		case IMAGES:
			dest = Paths.get(destination, "Images");
			break;
		case PROGRAMS:
			dest = Paths.get(destination, "Programs");
			break;
		case DOCUMENTS:
			dest = Paths.get(destination, "Documents");
			break;
		case CODE:
			dest = Paths.get(destination, "Code");
			break;
		default:
			dest = Paths.get(destination, "Others");
			break;
		}
		
		total++;
		
		System.out.println("File :" + file.toString());
		System.out.println("To   :" + dest.toString());
		
		System.out.println("Created");	
		
		if (!Files.exists(dest))
			Files.createDirectories(dest);
		
		System.out.println("Created");	
		
		//System.out.println("From : " + file.toString());
		//System.out.println("To   : " + dest.toString());
		
		Files.move(file, dest.resolve(file.getFileName().toString()));
		return FileVisitResult.CONTINUE;
	}
	
	public void done() {
		System.out.println("Categorized " + total + " files");
		
	}
	
	private String getExtension(String name) {
			String extension = "";
			
			int l = name.lastIndexOf('.');
			
			if (l > 0 && l < name.length() - 1) {
				extension = name.substring(l+1);
			}
			
			//System.out.println(extension);
			return extension;
	}

}
