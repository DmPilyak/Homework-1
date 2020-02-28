package com.sourceit.hw.num7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOFileHW {

	public static void main(String[] args) throws IOException {
		/*File f = new File("./test.txt");
		System.out.println(f.getAbsolutePath());
		f.createNewFile();
		String extension;*/
		Path start = Paths.get("C:");
		int maxDepth = 15;
		int count = 0;
		try (Stream<Path> stream = Files.walk(start, maxDepth)) {
		    String joined = stream
		        .map(String::valueOf)
		        .filter(path -> path.endsWith(".java"))
		        .sorted()
		        .collect(Collectors.joining("; "));
		    System.out.println("walk(): " + count);
		}

	}
	
	public static int calculateFiles(String path, String extension, int depth) throws Exception {
		Path p = Paths.get(path);
		Files.find(p, depth,
				(path2, fa) -> Files.isDirectory(path2))
		.forEach(pp ->{
			File[] files = new File(pp.toString()).listFiles();
					for(File file : files) {
						
					}
		});
		
		return 1;
	}

}
