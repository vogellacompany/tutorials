package com.vogella.unittest.file;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileWriterTest {

	@Test
	void ensureThatPathFromTempDirISWritable(@TempDir Path path) {
		// Check if the path created by the TempDir extension is writable
		assertTrue(Files.isWritable(path));
	}

	@Test
	void ensureThatNonExistingFileThrowsAnException(@TempDir Path path) {
		Path file = path.resolve("content.txt");
		assertThrows(IOException.class, () -> {
			FileWriter.appendFile(file, "Hello");
		});
	}

	@Test
	void ensureAppendingWorks(@TempDir Path path) throws IOException {
		Path file = path.resolve("content.txt");
		FileWriter.createFile(file);
		FileWriter.appendFile(file, "Hello");

		assertTrue(Files.isReadable(file));
		// TODO check the content of the file
	}

}
