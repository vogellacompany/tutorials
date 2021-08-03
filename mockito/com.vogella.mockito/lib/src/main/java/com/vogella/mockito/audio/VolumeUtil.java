package com.vogella.mockito.audio;

public class VolumeUtil {
	public static void maximizeVolume(AudioManager audioManager) {
		if (audioManager.getRingerMode() != RINGER_MODE.RINGER_MODE_SILENT) {
			int max = audioManager.getStreamMaxVolume();
			audioManager.setStreamVolume(max);
		}
	}
}