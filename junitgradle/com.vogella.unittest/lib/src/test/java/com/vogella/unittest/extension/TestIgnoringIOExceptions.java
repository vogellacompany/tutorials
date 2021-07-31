package com.vogella.unittest.extension;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

@ExtendWith(IgnoreIOExceptionExtension.class)
class TestIgnoringIOExceptions {
	@Test
	void testThatIOExceptionsAreIgnored(@TempDir Path path) throws IOException {
		Files.writeString(path, "Hello", StandardOpenOption.APPEND);
		assertTrue(true);
	}
}
