package exercise;

import java.time.LocalDate;

/**
 * Simple singleton class which a date method
 * 
 * @author David ten Hove
 */
public final class Singleton {

	private static Singleton instance = new Singleton();
	
	/**
	 * Returns the only instance of this class
	 * 
	 * @return the only instance of this class
	 */
	public static Singleton getInstance() {
		return instance;
	}
	
	/**
	 * Returns true if the provided date is in a long month
	 * 
	 * @param date the date to check
	 * @return true if the month of the provided date has 31 days
	 */
	public boolean isDateInLongMonth(LocalDate date) {
		return date.getMonth().length(false) == 31;
	}
}
