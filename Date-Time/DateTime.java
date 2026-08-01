import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ===========================================================
 *  java.time API — Complete Reference
 * ===========================================================
 *
 * Introduced in Java 8 (JSR-310) to replace the old, mutable,
 * thread-unsafe java.util.Date / Calendar classes.
 *
 * GOLDEN RULE: Every class in java.time is IMMUTABLE.
 * Methods like plusDays(), minusHours(), etc. never modify the
 * original object — they always return a NEW object.
 * You must reassign the result, or the change is lost.
 *
 * Classes covered here:
 *   LocalDate       -> date only (no time, no zone)
 *   LocalTime       -> time only (no date, no zone)
 *   LocalDateTime   -> date + time (no zone)
 *   ZonedDateTime   -> date + time + timezone (for global apps)
 *   Instant         -> machine timestamp (UTC, epoch-based)
 *   Period          -> date-based difference (years/months/days)
 *   Duration        -> time-based difference (hours/min/sec)
 *   DateTimeFormatter -> formatting & parsing
 * ===========================================================
 */
public class DateTime {

	public static void main(String[] args) {
		demoLocalDate();
		demoLocalTime();
		demoLocalDateTime();
		demoZonedDateTime();
		demoInstant();
		demoPeriod();
		demoDuration();
		demoFormatter();
	}

	// ===========================================================
	// 1. LocalDate — date only (year, month, day)
	// Real use case: DOB, invoice date, deadline — time irrelevant.
	// ===========================================================
	private static void demoLocalDate() {
		System.out.println("\n===== LocalDate =====");

		LocalDate today = LocalDate.now();                 // system clock se aaj ki date
		LocalDate dob = LocalDate.of(2009, 10, 19);          // manually specific date (validates! invalid date -> DateTimeException)
		LocalDate parsed = LocalDate.parse("2024-05-20");    // ISO format string se (yyyy-MM-dd)

		System.out.println("Today       : " + today);
		System.out.println("DOB         : " + dob);
		System.out.println("Parsed      : " + parsed);

		// ---- Extracting components ----
		System.out.println("Day         : " + today.getDayOfMonth());
		System.out.println("Year        : " + today.getYear());
		Month month = today.getMonth();          // enum: JANUARY...DECEMBER
		DayOfWeek dow = today.getDayOfWeek();    // enum: MONDAY...SUNDAY
		System.out.println("Month       : " + month);
		System.out.println("Day of Week : " + dow);

		// ---- Arithmetic (returns NEW object, original unchanged) ----
		LocalDate future = today.plusDays(10);
		LocalDate past = today.minusMonths(2);
		System.out.println("Future(+10d): " + future);
		System.out.println("Past(-2m)   : " + past);

		// ---- Comparison ----
		System.out.println("isBefore    : " + dob.isBefore(today));
		System.out.println("isAfter     : " + today.isAfter(dob));
		System.out.println("isEqual     : " + today.isEqual(dob));
		System.out.println("isLeapYear  : " + today.isLeapYear());

		// ---- Field replacement ----
		System.out.println("withYear(30): " + today.withYear(2030));
	}

	// ===========================================================
	// 2. LocalTime — time only (hour, minute, second, nanosecond)
	// Real use case: opening hours, alarm time, daily schedule.
	// NOTE: Wraps around 24hr clock — no date awareness, so
	// plusHours() near midnight cycles back to 00:xx silently.
	// ===========================================================
	private static void demoLocalTime() {
		System.out.println("\n===== LocalTime =====");

		LocalTime now = LocalTime.now();
		LocalTime specific = LocalTime.of(14, 30, 0);   // 2:30:00 PM (24-hr format)
		LocalTime later = now.plusHours(2);

		System.out.println("Now         : " + now);
		System.out.println("Specific    : " + specific);
		System.out.println("Later(+2h)  : " + later);
		System.out.println("Hour/Min/Sec: " + now.getHour() + "/" + now.getMinute() + "/" + now.getSecond());
	}

	// ===========================================================
	// 3. LocalDateTime — date + time combined (still NO timezone)
	// Real use case: single-timezone app's internal timestamp.
	// ===========================================================
	private static void demoLocalDateTime() {
		System.out.println("\n===== LocalDateTime =====");

		LocalDateTime dt = LocalDateTime.now();
		LocalDateTime specific = LocalDateTime.of(2024, 5, 20, 14, 30);
		LocalDateTime combined = LocalDate.now().atTime(LocalTime.now());  // joining a LocalDate + LocalTime

		System.out.println("Now         : " + dt);
		System.out.println("Specific    : " + specific);
		System.out.println("Combined    : " + combined);
		System.out.println("Date part   : " + dt.toLocalDate());
		System.out.println("Time part   : " + dt.toLocalTime());
	}

	// ===========================================================
	// 4. ZonedDateTime — date + time + timezone
	// Real use case: global apps — flight booking, meeting
	// scheduling, video calls across countries.
	// ===========================================================
	private static void demoZonedDateTime() {
		System.out.println("\n===== ZonedDateTime =====");

		ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		ZonedDateTime nyTime = istTime.withZoneSameInstant(ZoneId.of("America/New_York"));

		System.out.println("IST         : " + istTime);
		System.out.println("Same instant in NY: " + nyTime);
	}

	// ===========================================================
	// 5. Instant — machine timestamp (epoch: 1 Jan 1970 UTC)
	// Real use case: backend logging, DB createdAt/updatedAt,
	// distributed systems — universal, timezone-independent.
	// Rule: store Instant/UTC in DB, convert to ZonedDateTime
	// only when displaying to a user.
	// ===========================================================
	private static void demoInstant() {
		System.out.println("\n===== Instant =====");

		Instant now = Instant.now();
		Instant future = now.plusSeconds(7200);   // 2 hours later (new object!)

		System.out.println("Now (UTC)   : " + now);
		System.out.println("Future(+2h) : " + future);

		// Converting Instant -> local zone for display purposes
		ZonedDateTime localView = now.atZone(ZoneId.of("Asia/Kolkata"));
		System.out.println("As IST      : " + localView);
	}

	// ===========================================================
	// 6. Period — date-based difference (Years, Months, Days)
	// Real use case: age calculation, membership duration.
	// IMPORTANT: Period.between(start, end) — order matters!
	// Reversing start/end gives a negative Period.
	// ===========================================================
	private static void demoPeriod() {
		System.out.println("\n===== Period =====");

		LocalDate dob = LocalDate.of(1997, 11, 8);
		LocalDate today = LocalDate.now();

		Period age = Period.between(dob, today);   // start=dob, end=today
		System.out.println("Age         : " + age.getYears() + " years, "
				+ age.getMonths() + " months, " + age.getDays() + " days");

		// getMonths() gives only the "leftover" months (0-11), not total months
		System.out.println("Total months: " + age.toTotalMonths());
	}

	// ===========================================================
	// 7. Duration — time-based difference (Hours, Minutes, Seconds)
	// Real use case: session duration, working hours, API response
	// time. Handles borrow/carry internally — safer than manual
	// hour/minute subtraction.
	// ===========================================================
	private static void demoDuration() {
		System.out.println("\n===== Duration =====");

		LocalTime start = LocalTime.of(9, 45);
		LocalTime end = LocalTime.of(17, 30);

		Duration workHours = Duration.between(start, end);

		// toXxx() = TOTAL value in that unit
		// toXxxPart() = "remainder" part only, like a clock display
		System.out.println("Total minutes    : " + workHours.toMinutes());
		System.out.println("Hours part        : " + workHours.toHoursPart());
		System.out.println("Minutes part      : " + workHours.toMinutesPart());
		System.out.println("Formatted         : " + workHours.toHoursPart() + "hr "
				+ workHours.toMinutesPart() + "min");
	}

	// ===========================================================
	// 8. DateTimeFormatter — formatting (Date -> String)
	//    and parsing (String -> Date)
	// Real use case: UI display, reports, API response formatting.
	//
	// Pattern letters (CASE MATTERS!):
	//   d/dd   -> day of month     M/MM  -> month (number)
	//   MMM    -> month short name  MMMM -> month full name
	//   y/yyyy -> year               E/EEEE -> day of week
	//   H/HH   -> hour (24h)        h/hh -> hour (12h)
	//   m/mm   -> MINUTES (lowercase! not month)
	//   s/ss   -> seconds            a   -> AM/PM
	// ===========================================================
	private static void demoFormatter() {
		System.out.println("\n===== DateTimeFormatter =====");

		// ---- Formatting: Date -> String ----
		DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
		String formattedToday = LocalDate.now().format(fullFormatter);
		System.out.println("Full format : " + formattedToday);   // e.g. Sunday, 02 August 2026

		DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println("Short format: " + LocalDate.now().format(shortFormatter));

		// ---- Parsing: String -> Date ----
		// The pattern must EXACTLY match the string's format, or DateTimeParseException is thrown.
		DateTimeFormatter slashFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateStr = "25/12/2025";
		LocalDate parsedDate = LocalDate.parse(dateStr, slashFormatter);
		DayOfWeek dayOfWeek = parsedDate.getDayOfWeek();

		System.out.println("Parsed date : " + parsedDate);
		System.out.println("Day of week for " + dateStr + " : " + dayOfWeek);
	}
}