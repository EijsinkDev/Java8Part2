package time.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import time.Attempt;
import time.ExcerciseInterface;
import time.Solution;

public class ExcerciseTest {

	private static final int ATTEMPTS = 5;
	
	private ExcerciseInterface solution;
	private ExcerciseInterface attempt;
	
	public ExcerciseTest() {
		solution = new Solution();
		attempt = new Attempt();
	}
	
	@Test
	public void testGetCurrentDate() {
		assertEquals(solution.getCurrentDate(), attempt.getCurrentDate());
	}
	
	@Test
	public void testEinsteinBirthday() {
		assertEquals(solution.getEinsteinBirthday(), attempt.getEinsteinBirthday());
	}
	
	@Test
	public void testAddOneMonthAndThreeDays() {
		for (int i = 0; i < ATTEMPTS; i++) {
			LocalDate date = getRandomLocalDate();
			assertEquals(solution.addOneMonthAndThreeDays(date), attempt.addOneMonthAndThreeDays(date));
		}
	}
	
	@Test
	public void testAddThreeWorkDays() {
		for (int i = 0; i < ATTEMPTS; i++) {
			LocalDate date = getRandomLocalDate();
			assertEquals(solution.addThreeWorkDays(date), attempt.addThreeWorkDays(date));
		}
	}

	@Test
	public void testGetFriday() {
		assertEquals(solution.getFriday(), attempt.getFriday());
	}
	
	@Test
	public void testGetCurrentTime() {
		LocalTime solutionTime = solution.getCurrentTime();
		LocalTime attemptTime = attempt.getCurrentTime();
		assertNotNull(attemptTime);
		Duration difference = Duration.between(solutionTime, attemptTime);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}
	
	@Test
	public void testGetWorkEndTime() {
		assertEquals(solution.getWorkEndTime(), attempt.getWorkEndTime());
	}
	
	@Test
	public void testAddTwoHoursAndNineMinutes() {
		for (int i = 0; i < ATTEMPTS; i++) {
			LocalTime time = getRandomLocalTime();
			assertEquals(solution.addTwoHoursAndNineMinutes(time), attempt.addTwoHoursAndNineMinutes(time));
		}
	}
	
	@Test
	public void testGetCoffeeTime() {
		assertEquals(solution.getCoffeeTime(), attempt.getCoffeeTime());
	}
	
	@Test
	public void testGetCurrentDateTime() {
		LocalDateTime solutionDateTime = solution.getCurrentDateTime();
		LocalDateTime attemptDateTime = attempt.getCurrentDateTime();
		assertNotNull(attemptDateTime);
		Duration difference = Duration.between(solutionDateTime, attemptDateTime);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}
	
	@Test
	public void testGetEarliestDate() {
		for (int i = 0; i < ATTEMPTS; i++) {
			Collection<LocalDate> dates = new HashSet<>();
			for (int j = 0; j < ATTEMPTS; j++) {
				dates.add(getRandomLocalDate());
			}
			assertEquals(solution.getEarliestDate(dates), attempt.getEarliestDate(dates));
		}
	}
	
	@Test
	public void testGetNextWeekendStart() {
		assertEquals(solution.getNextWeekendStart(), attempt.getNextWeekendStart());
	}
	
	@Test
	public void testAddOneWeekAndEightySeconds() {
		for (int i = 0; i < ATTEMPTS; i++) {
			LocalDateTime dateTime = getRandomLocalDateTime();
			assertEquals(solution.subtractOneWeekAndEightySeconds(dateTime), attempt.subtractOneWeekAndEightySeconds(dateTime));
		}
	}
	
	@Test
	public void testGetNextWeekendStartLongNotation() {
		assertEquals(solution.getNextWeekendStartISONotation(), attempt.getNextWeekendStartISONotation());
	}
	
	@Test
	public void testGetDaysUntilFriday() {
		assertEquals(solution.getDaysUntilFriday(), attempt.getDaysUntilFriday());
	}
	
	@Test
	public void testGetPeriodOfLunarCycle() {
		assertEquals(solution.getPeriodOfLunarCycle(), attempt.getPeriodOfLunarCycle());
	}
	
	@Test
	public void testGetTimeUntilNextWeekend() {
		Duration solutionDuration = solution.getTimeUntilNextWeekend();
		Duration attemptDuration = attempt.getTimeUntilNextWeekend();
		assertNotNull(attemptDuration);
		Duration difference = solutionDuration.minus(attemptDuration);
		assertTrue(difference.getSeconds() == 0 || difference.getSeconds() == 1);
	}
	
	@Test
	public void testGetWorkDuration() {
		assertEquals(solution.getWorkDuration(), attempt.getWorkDuration());
	}
	
	private static LocalDate getRandomLocalDate() {
		return LocalDate.ofEpochDay((int)(Math.random() * 10000000));
	}
	
	private static LocalTime getRandomLocalTime() {
		return LocalTime.ofSecondOfDay((int)(Math.random() * 86400));
	}
	
	private static LocalDateTime getRandomLocalDateTime() {
		return LocalDateTime.of(getRandomLocalDate(), getRandomLocalTime());
	}
}
