package io.narveer.util.FileOrganizer;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

public class Handler {
	Path sourceDir;
	String des;
	
	Arrange arranger;
	DirectoryStream<Path> stream;
	
	Handler(Path from, Path to) {
		sourceDir = from;
		des = "\\" + to.getFileName().toString();
		
		//System.out.println("From " + from.toString());
		//System.out.println("To " + from.toString() + des);
		
		arranger = new Arrange(from.toString() + des);
		
		try {
			Files.walkFileTree(from, arranger);
		} catch (IOException e) {
			System.out.println(e.toString() + " " + e.getStackTrace());
		}
		
		arranger.done();
	}		
}
