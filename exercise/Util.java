package exercise;

import java.time.LocalTime;

/**
 * Simple Util class with a static time method
 * 
 * @author David ten Hove
 */
public final class Util {

	private Util() {}
	
	/**
	 * Returns true if the provided time is during sleeping hours
	 * 
	 * @param time the time to check
	 * @return true if the hour of the time is bigger than or equals to 23, or the hour is less than 7
	 */
	public static boolean isSleepTime(LocalTime time) {
		return time.getHour() >= 23 || time.getHour() < 7;
	}
}
