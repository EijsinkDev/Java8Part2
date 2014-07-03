package exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * This is the interface you need to implement for the exercise
 * The Attempt class should hold your implementation. The Solution class is there for comparison.
 * 
 * @author David ten Hove
 */
public interface ExerciseInterface {

	//Time
	/**
	 * Returns the current time
	 * @return the current time
	 */
	LocalTime getCurrentTime();
	
	/**
	 * Returns the time at lunch starts
	 * @return 12:30 PM
	 */
	LocalTime getLunchStartTime();

	/**
	 * Returns true if the time is during lunch time
	 * @param time the time to check
	 * @return true if the time is between lunch start (inclusive) and 1 hour later (exclusive)
	 */
	boolean isLunchTime(LocalTime time);
	
	/**
	 * Subtracts 4 hours, 15 minutes and 3 seconds from the provided time
	 * @param time the time to subtract from
	 * @return a new LocalTime object which is 4 hours, 15 minutes and 3 seconds before the provided time
	 */
	LocalTime subtract4Hours15MinutesAnd3Seconds(LocalTime time);
	
	//Date
	/**
	 * Returns the current date
	 * @return the current date
	 */
	LocalDate getCurrentDate();

	/**
	 * Returns the date of Albert Einsteins birthday
	 * @return the date of 14 March 1879
	 */
	LocalDate getAlbertEinsteinBirthDay();
	
	/**
	 * Returns true if the date is in a weekend
	 * @param date the date to check
	 * @return true if the date is on a Saturday or Sunday
	 */
	boolean isWeekendDay(LocalDate date);
	
	/**
	 * Return all Mondays between start (inclusive, if its a Monday) and end (exclusive)
	 * @param start the start date
	 * @param end the end date
	 * @return a List of all LocalDate's which are on a Monday and are between start and end
	 */
	List<LocalDate> getAllMondays(LocalDate start, LocalDate end);
	
	/**
	 * Adds 3 days to the provided date
	 * @param date the date to add 3 days to
	 * @return a new LocalDate object which is 3 days after the provided date
	 */
	LocalDate add3Days(LocalDate date);
	
	/**
	 * Adds 3 workdays to the provided date. Workdays are from Monday to Friday
	 * 
	 * @param date the date to add 3 workdays to
	 * @return a new LocalDate which is 3 workdays after the provided date
	 */
	LocalDate add3WorkDays(LocalDate date);

	//Time predicates
	/**
	 * Returns all LocalTimes in the provided List which are during lunch. Use {@link #isLunchTime(LocalTime)}
	 * @param localTimes the times to check
	 * @return a new List containing only the times during lunch
	 */
	List<LocalTime> getLunchTimes(List<LocalTime> localTimes);
	
	/**
	 * Returns the same times as provided, but with 4 hours, 15 minutes and 3 seconds added. Use {@link #subtract4Hours15MinutesAnd3Seconds(LocalTime)}
	 * @param times the times to add the hours, minutes and seconds to
	 * @return a new List containing the same times, but with 4 hours, 15 minute and 3 seconds added
	 */
	List<LocalTime> subtract4Hours15MinutesAnd3SecondsFromEach(List<LocalTime> times);

	/**
	 * Returns a List containing all times which are during sleeping hours. Sleeping hours are from 23:00 inclusive to 7:00 exclusive.
	 * Use {@link exercise.Util#isSleepTime(LocalTime)}
	 * @param times the times to check
	 * @return a new List containing only the times which are during sleeping hours
	 */
	List<LocalTime> getSleepTimes(List<LocalTime> times);

	//Date predicates
	/**
	 * Returns a List containing only the dates which are during the weekend.
	 * Use {@link #isWeekendDay(LocalDate)}
	 * @param dates the dates to check
	 * @return a new List containing only the dates which are on Saturday or Sunday
	 */
	List<LocalDate> getWeekendDays(List<LocalDate> dates);
	
	/**
	 * Returns the same dates as provided, but with 3 days added to them.
	 * Use {@link #add3Days(LocalDate)}
	 * @param dates the dates to add 3 days to
	 * @return a new List containing the same dates, but 3 days later
	 */
	List<LocalDate> add3DaysToEach(List<LocalDate> dates);
	
	/**
	 * Returns the same dates as provided, but with 3 workdays added to them.
	 * Use {@link #add3WorkDays(LocalDate)}
	 * @param dates the dates to add 3 days to
	 * @return a new List containing the same dates, but 3 days later
	 */
	List<LocalDate> add3WorkDaysToEach(List<LocalDate> dates);

	/**
	 * Returns a List containing all dates which are in long months. Long months have 31 days
	 * Use {@link exercise.Singleton#isDateInLongMonth(LocalDate)}
	 * @param localDates the dates to check
	 * @return a new List containing only the dates which are in long months.
	 */
	List<LocalDate> getDatesInLongMonths(List<LocalDate> localDates);

	//LocalDateTime predicates
	/**
	 * Prints all provided datetimes to the standard output.
	 * Use {@link System.out#println}
	 * @param dateTimes the datetimes to print
	 */
	void printDateTimes(List<LocalDateTime> dateTimes);
}