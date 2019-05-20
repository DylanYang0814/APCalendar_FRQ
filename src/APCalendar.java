import java.util.Calendar;

public class APCalendar {
    /**
     * Returns true if year is a leap year and false otherwise.
     */

    private static Calendar cal = Calendar.getInstance();


    private static boolean isLeapYear(int year) {
//        if (year % 4 == 0) {
//            return true;
//        }
//        return false;
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    /**
     * Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2) {
        int count = 0;
        while (year1 <= year2) {
            if (isLeapYear(year1)) {
                count++;
            }
            year1++;
        }
        return count;
    }

    /**
     * Returns the value representing the day of the week for the first day of year,
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     */
    private static int firstDayOfYear(int year) {
        cal.set(year, Calendar.JANUARY, 1);
        return cal.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
    }

    /**
     * Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    private static int dayOfYear(int month, int day, int year) {
        if (Calendar.JANUARY == 0)
            month--;
        cal.set(year, month, day);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year) {
        int first = firstDayOfYear(year);
        int firstDayWeek = dayOfYear(month, day, year);

        int modFirst = firstDayWeek % 7;
        int output = modFirst + first - 1;
        if (output > 7) {
            return (output % 7);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Testing library functions");
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        System.out.println(firstDayOfYear(2019) + " should be 2"); // Tuesday
        System.out.println(dayOfYear(1, 7, 2019) + " should be 7"); //7
        System.out.println(dayOfYear(2, 7, 2019) + " should be 38"); //38
        System.out.println(dayOfYear(3, 1, 2017) + " should be 60"); //60
        System.out.println(dayOfYear(3, 1, 2016) + " should be 61"); //61


        System.out.println(isLeapYear(1903) + " should be false"); // no (not 4)
        System.out.println(isLeapYear(1900) + " should be false"); // no (4, but 100 and not 400)
        System.out.println(isLeapYear(2000) + " should be true"); // yes (4, and 100 but 400)
        System.out.println(isLeapYear(2016) + " should be true"); // yes (4)

        System.out.println("\nTesting part a");
        System.out.println(numberOfLeapYears(1899, 1901) + " should be 0");
        System.out.println(numberOfLeapYears(1899, 1923) + " should be 5");
        System.out.println(numberOfLeapYears(1999, 2022) + " should be 6");
        System.out.println(numberOfLeapYears(2015, 2017) + " should be 1");

        System.out.println("\nTesting part b");
        System.out.println(dayOfWeek(1, 1, 2019) + " should be 2");
        System.out.println(dayOfWeek(1, 5, 2019) + " should be 6");
        System.out.println(dayOfWeek(1, 10, 2019) + " should be 4");
        System.out.println(dayOfWeek(5, 19, 2019) + " should be 0");
        System.out.println(dayOfWeek(3, 1, 2017) + " should be 3");
        System.out.println(dayOfWeek(3, 1, 2016) + " should be 2");

    }
}
// There may be instance variables, constructors, and other methods not shown.
