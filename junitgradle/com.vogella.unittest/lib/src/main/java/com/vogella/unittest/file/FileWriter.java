package com.vogella.unittest.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriter {

	private FileWriter() {

	}

	public static void createFile(Path path) {
		try {
			Files.write(path, "".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void appendFile(Path path, String content) throws IOException {
		// image more logic here...
		Files.writeString(path, content, StandardOpenOption.APPEND);
	}
}
