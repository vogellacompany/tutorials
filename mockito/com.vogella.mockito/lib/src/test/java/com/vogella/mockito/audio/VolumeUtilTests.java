package com.vogella.mockito.audio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vogella.mockito.audio.AudioManager;
import com.vogella.mockito.audio.RINGER_MODE;
import com.vogella.mockito.audio.VolumeUtil;

@ExtendWith(MockitoExtension.class)
class VolumeUtilTests {

	@Mock
	AudioManager audioManager;

	@Test
	void ensureThatMaximizeVolumeUseConfiguredValueFromAudiomanager() {
		// 1. script mock behavior.
		when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_NORMAL);
		when(audioManager.getStreamMaxVolume()).thenReturn(100);

		// 2. Test the code of interest.

		VolumeUtil.maximizeVolume(audioManager);

		// 3. Validate that we saw exactly what we wanted.
		verify(audioManager).setStreamVolume(100);
	}

	@Test
	void ensureSilentModeWillNotSetVolumeIsNotDisturbed() {
		// 1. script mock behavior.
		AudioManager audioManager = mock(AudioManager.class);
		when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_SILENT);
		// 2. Test the code of interest.
		VolumeUtil.maximizeVolume(audioManager);
		// 3. Validate that we saw exactly what we wanted.
		verify(audioManager).getRingerMode();
		verifyNoMoreInteractions(audioManager);
	}
}
