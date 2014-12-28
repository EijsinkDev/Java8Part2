package time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * Interface which defines a number of date and time related methods
 */
public interface ExcerciseInterface {

	/**
	 * @return the current date
	 */
	LocalDate getCurrentDate();
	
	/**
	 * @return Returns the date of Albert Einsteins birthday: March 14, 1879
	 */
	LocalDate getEinsteinBirthday();

	/**
	 * Adds exactly one month and three days to any given date
	 * 
	 * @param date the date to add to
	 * @return a new date which is one month and three days later
	 */
	LocalDate addOneMonthAndThreeDays(LocalDate date);
	
	/**
	 * Adds three workdays to any given date. For example, Monday goes to Thursday and Thursday goes to Tuesday.
	 * This is the same as adding three days, skpping over Saturday and Sunday  
	 * 
	 * @param date the date to add three workdays to
	 * @return a new date which is three working days after the provided date
	 */
	LocalDate addThreeWorkDays(LocalDate date);
	
	/**
	 * @return the next or current date which is on a Friday
	 */
	LocalDate getFriday();

	/**
	 * Gets the earliest of the provided dates
	 * 
	 * @param dates the dates to compare
	 * @return the earliest of the provided dates
	 */
	LocalDate getEarliestDate(Collection<LocalDate> dates);
	
	/**
	 * @return the current time
	 */
	LocalTime getCurrentTime();
	
	/**
	 * Returns the time at which work ends. For this exercise, thats 17:00
	 * 
	 * @return the time work ends
	 */
	LocalTime getWorkEndTime();
	
	/**
	 * Adds two hours and nine minutes to any given time
	 * 
	 * @param time the time to add two hours and nine minutes to
	 * @return a new time which is exactly two hours and nine minutes later than the provided time
	 */
	LocalTime addTwoHoursAndNineMinutes(LocalTime time);

	/**
	 * Returns the next time to have coffee. For this exercise, coffee is had every 30 minutes past the whole hour.
	 * For example, if the current time is 9:50, the next coffee time would be 10:30.
	 * If the current time is 12:17, the next coffee time would be 12:30.
	 * 
	 * @return the next time to have coffee
	 */
	LocalTime getCoffeeTime();

	/**
	 * @return the current date and time
	 */
	LocalDateTime getCurrentDateTime();
	
	/**
	 * @return the start of the next weekend, Friday at work end time
	 */
	LocalDateTime getNextWeekendStart();
	
	/**
	 * Subtracts one week and eighty seconds from any date and time
	 * 
	 * @param dateTime the date and time to subtract one week and eighty seconds from
	 * @return a new date and time which is exactly one week and eighty seconds earlier than the provided time
	 */
	LocalDateTime subtractOneWeekAndEightySeconds(LocalDateTime dateTime);

	/**
	 * Returns the date and time the next weekend starts, represented in long String notation.
	 * The notation is defined in {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME}
	 * 
	 * @return a string representation of the current date time
	 */
	String getNextWeekendStartISONotation();

	/**
	 * @return the number of days until the next (or this) Friday
	 */
	Period getDaysUntilFriday();
	
	/**
	 * Returns the period of one lunar cycle in days (29.5), rounded up
	 * 
	 * @return the period of one lunar cycle, 30 days
	 */
	Period getPeriodOfLunarCycle();

	/**
	 * @return the period between Albert Einsteins birthday and the current date
	 */
	Period getPeriodSinceEinsteinBirthday();
	
	/**
	 * @return the duration until the start of the next weekend
	 */
	Duration getTimeUntilNextWeekend();
	
	/**
	 * @return the duration of one work day, 8 hours
	 */
	Duration getWorkDuration();
}