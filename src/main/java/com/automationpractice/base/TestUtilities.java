package com.automationpractice.base;

public class TestUtilities {

	/**
	 * Pauses automation for the defined amount of time.
	 * @param millis long time in milliseconds
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
