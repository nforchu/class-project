package com.fashionkings.core.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileUtil {

	public String save(String destFolder, String filename, byte[] bytes) throws IOException {
		String[] parts  = filename.split("\\.");  //[books, jpg] //books.jpg
		String extension = parts[parts.length -1];
		long time = System.currentTimeMillis();
		filename = String.format("%s.%s",  time, extension);
		Path path = Paths.get(destFolder + filename);
		Files.write(path, bytes);
		return filename;
	}
	
	public Resource load(String location, String filename) throws MalformedURLException {
		Path root = Paths.get(location);
		Path file = root.resolve(filename);
		Resource resource = new UrlResource(file.toUri());
		return resource;
	}
}
