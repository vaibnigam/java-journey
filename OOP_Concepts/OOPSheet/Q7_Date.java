package OOPSheet;

/*Q7. A class called Date, which models a calendar date, is designed as the Date class.*/

public class Q7_Date {
	public static void main(String[] args) {

		DateClass d1 = new DateClass(2026, 8, 23);
		System.out.println(d1);

		DateClass d2 = new DateClass(2026, 2, 30);  // invalid - Feb doesn't have 30 days
		System.out.println(d2);

		DateClass d3 = new DateClass(2024, 2, 29);  // valid - 2024 is a leap year
		System.out.println(d3);

		DateClass d4 = new DateClass(1900, 2, 29);  // invalid - 1900 is not a leap year
		System.out.println(d4);
	}
}

class DateClass {

	private int year;
	private int month;
	private int day;

	public DateClass(int year, int month, int day) {
		if (isValidDate(year, month, day)) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			System.out.println("Invalid date provided");
			this.year = 0;
			this.month = 0;
			this.day = 0;
		}
	}

	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	private int getDaysInMonth(int month, int year) {
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				return isLeapYear(year) ? 29 : 28;
			default:
				return 0;
		}
	}

	private boolean isValidDate(int year, int month, int day) {
		if (year <= 0) {
			return false;
		}
		if (month < 1 || month > 12) {
			return false;
		}
		int maxDays = getDaysInMonth(month, year);
		if (day < 1 || day > maxDays) {
			return false;
		}
		return true;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	@Override
	public String toString() {
		return String.format("%02d-%02d-%04d", day, month, year);
	}
}