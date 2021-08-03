package com.vogella.mockito.audio;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConfigureThreadingUtilTests {

	@Mock
	MyApplication app;

	@Test
	void ensureThatThreadPoolCanBeConfigured() {
		// mock MyApplication
		ConfigureThreadingUtil.configureThreadPool(app);
		verify(app, only()).getNumberOfThreads();
	}
}