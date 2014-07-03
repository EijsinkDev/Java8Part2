package exercise.solution;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import exercise.ExerciseInterface;
import exercise.Singleton;
import exercise.Util;

/**
 * This class holds the Solution for the exercise. Keep in mind that multiple implementations for many of the methods are possible.
 * 
 * @author David ten Hove
 */
public class Solution implements ExerciseInterface {

	@Override
	public LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	@Override
	public LocalTime getLunchStartTime() {
		return LocalTime.of(12, 30);
	}

	@Override
	public boolean isLunchTime(LocalTime time) {
		//Find the number of minutes between lunch start and the provided time
		long minutes = getLunchStartTime().until(time, ChronoUnit.MINUTES);
		//If the difference is less than 60 minutes, return true
		return minutes >= 0  && minutes < 60;
	}

	@Override
	public LocalTime subtract4Hours15MinutesAnd3Seconds(LocalTime time) {
		return time.minusHours(4).minusMinutes(15).minusSeconds(3);
	}
	
	@Override
	public LocalDate getCurrentDate() {
		return LocalDate.now();
	}

	@Override
	public LocalDate getAlbertEinsteinBirthDay() {
		return LocalDate.of(1879, 3, 14);
	}

	@Override
	public boolean isWeekendDay(LocalDate date) {
		return date.getDayOfWeek().getValue() > 5;
	}

	@Override
	public List<LocalDate> getAllMondays(LocalDate start, LocalDate end) {
		List<LocalDate> result = new LinkedList<>();
		//Find the first Monday from 
		LocalDate current = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
		while (current.isBefore(end)) {
			result.add(current);
			//Just add 7 days every time
			current = current.plusDays(7);
		}	
		return result;
	}

	@Override
	public LocalDate add3Days(LocalDate date) {
		return date.plusDays(3);
	}

	@Override
	public LocalDate add3WorkDays(LocalDate date) {
		//Find the number of days to add, based on the provided dates day of the weekd
		int toAdd;
		switch (date.getDayOfWeek()) {
			case SUNDAY:
			case MONDAY:
			case TUESDAY: toAdd = 3; break;
			
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY: toAdd = 5; break;
			
			case SATURDAY: toAdd = 4; break;
			default: throw new RuntimeException();
		}
		//Add the appropriate number of days
		return date.plusDays(toAdd);
	}

	@Override
	public List<LocalTime> getLunchTimes(List<LocalTime> localTimes) {
		return localTimes.stream().filter(this::isLunchTime).collect(Collectors.toList());
	}

	@Override
	public List<LocalTime> subtract4Hours15MinutesAnd3SecondsFromEach(
			List<LocalTime> times) {
		return times.stream().map(this::subtract4Hours15MinutesAnd3Seconds).collect(Collectors.toList());
	}

	@Override
	public List<LocalTime> getSleepTimes(List<LocalTime> times) {
		return times.stream().filter(Util::isSleepTime).collect(Collectors.toList());
	}

	@Override
	public List<LocalDate> getWeekendDays(List<LocalDate> dates) {
		return dates.stream().filter(this::isWeekendDay).collect(Collectors.toList());
	}
	
	@Override
	public List<LocalDate> add3DaysToEach(List<LocalDate> dates) {
		return dates.stream().map(this::add3Days).collect(Collectors.toList());
	}
	
	@Override
	public List<LocalDate> add3WorkDaysToEach(List<LocalDate> dates) {
		return dates.stream().map(this::add3WorkDays).collect(Collectors.toList());
	}

	@Override
	public List<LocalDate> getDatesInLongMonths(List<LocalDate> localDates) {
		return localDates.stream().filter(Singleton.getInstance()::isDateInLongMonth).collect(Collectors.toList());
	}

	@Override
	public void printDateTimes(List<LocalDateTime> dateTimes) {
		dateTimes.stream().forEach(System.out::println);
	}
}
