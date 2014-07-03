package exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import exercise.attempt.Attempt;
import exercise.solution.Solution;

/**
 * Main class for the exercise. Running it will compare the implementations of the Solution and Attempt classes
 * 
 * @author David ten Hove
 */
public class Main {

	/**
	 * Main method
	 * @param args the (ignored) command line parameters
	 */
	public static void main(String[] args) {
		// Set up
		ExerciseInterface attempt = new Attempt();
		ExerciseInterface solution = new Solution();

		// Time
		validate("Validating getCurrentTime()", solution.getCurrentTime(), attempt.getCurrentTime(), true);
		validate("Validating getLunchStartTime()", solution.getLunchStartTime(), attempt.getLunchStartTime(), false);
		
		LocalTime time = getRandomDateTime().toLocalTime();
		validate("Validating isLunchTime()", solution.isLunchTime(time), attempt.isLunchTime(time));

		validate("Validating subtract4Hours15MinutesAnd3Seconds()", solution.subtract4Hours15MinutesAnd3Seconds(time), attempt.subtract4Hours15MinutesAnd3Seconds(time));

		// Date
		validate("Validating getCurrentDate()", solution.getCurrentDate(), attempt.getCurrentDate());
		validate("Validating getAlbertEinsteinBirthDay()", solution.getAlbertEinsteinBirthDay(), attempt.getAlbertEinsteinBirthDay());

		LocalDate date = getRandomDateTime().toLocalDate();
		validate("Validating isWeekendDay()", solution.isWeekendDay(date), attempt.isWeekendDay(date));
		LocalDate date2 = date.plusDays(100);
		validate("Validating getAllMondays()", solution.getAllMondays(date, date2), attempt.getAllMondays(date,  date2));
		validate("Validating add3Days()", solution.add3Days(date), attempt.add3Days(date));
		validate("Validating add3WorkDays()", solution.add3WorkDays(date), attempt.add3WorkDays(date));

		// Predicates
		List<LocalTime> randomTimes = getRandomTimes();
		List<LocalDate> randomDates = getRandomDates();
		List<LocalDateTime> randomDateTimes = getRandomDateTimes();

		validate("Validating getLunchTimes()", solution.getLunchTimes(randomTimes), attempt.getLunchTimes(randomTimes));
		validate("Validating subtract4Hours15MinutesAnd3SecondsFromEach()", 
				solution.subtract4Hours15MinutesAnd3SecondsFromEach(randomTimes),
				attempt.subtract4Hours15MinutesAnd3SecondsFromEach(randomTimes));

		validate("Validating getSleepTimes()", solution.getSleepTimes(randomTimes), attempt.getSleepTimes(randomTimes));

		validate("Validating getWeekendDays()", solution.getWeekendDays(randomDates), attempt.getWeekendDays(randomDates));
		validate("Validating add3DaysToEach()", solution.add3DaysToEach(randomDates), attempt.add3DaysToEach(randomDates));
		validate("Validating add3WorkDaysToEach()", solution.add3WorkDaysToEach(randomDates), attempt.add3WorkDaysToEach(randomDates));

		validate("Validating getDatesInLongMonths()", solution.getDatesInLongMonths(randomDates), attempt.getDatesInLongMonths(randomDates));
		
		// solution.printDateTimes(randomDateTimes);
		//Print the first 10 datetimes only
		attempt.printDateTimes(randomDateTimes.subList(0, 10));
	}

	private static List<LocalDate> getRandomDates() {
		return getRandomDateTimes().stream().map(t -> t.toLocalDate())
				.collect(Collectors.toList());
	}

	private static List<LocalTime> getRandomTimes() {
		return getRandomDateTimes().stream().map(t -> t.toLocalTime())
				.collect(Collectors.toList());
	}

	private static List<LocalDateTime> getRandomDateTimes() {
		List<LocalDateTime> result = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			result.add(getRandomDateTime());
		}
		return result;
	}

	private static LocalDateTime getRandomDateTime() {
		return LocalDateTime.ofEpochSecond(
				(long) (Math.random() * 1000000000L), 0, ZoneOffset.UTC);
	}

	private static void validate(String message, boolean expected, boolean actual) {
		System.out.println(message);
		if (expected != actual) {
			System.out.println("Inconsistency detected");
			System.out.println("Solution: " + expected);
			System.out.println("Attempt: " + actual);
			System.exit(0);
		}
	}
	
	private static void validate(String message, Object expected, Object actual) {
		System.out.println(message);
		if (!expected.equals(actual)) {
			System.out.println("Inconsistency detected");
			System.out.println("Solution: " + expected);
			System.out.println("Attempt: " + actual);
			System.exit(0);
		}
	}

	private static void validate(String message, LocalTime expected, LocalTime actual,
			boolean allow1Second) {
		System.out.println(message);
		if (!expected.equals(actual)) {
			if (!allow1Second || expected.getSecond() - actual.getSecond() > 1) {
				System.out.println("Inconsistency detected");
				System.out.println("Solution: " + expected);
				System.out.println("Attempt: " + actual);
				System.exit(0);
			}
		}
	}
}