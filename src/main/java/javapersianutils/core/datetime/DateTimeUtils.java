package javapersianutils.core.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

/**
 * <h1>LocalTimeUtils</h1>
 * The Date Time Utils
 * Some helper methods for working with georgian calendar
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/23/2019
 */
public class DateTimeUtils {

    private DateTimeUtils() {
    }

    private static final String IRAN_TIME_ZONE_ID = "Asia/Tehran";
    /**
     * Iran Standard Time
     */
    private static final TimeZone iranStandardTime = TimeZone.getTimeZone(IRAN_TIME_ZONE_ID);
    /**
     * Epoch represented as LocalTime
     */
    private static Calendar calendar = Calendar.getInstance();

    /**
     * Calculate the age at the given date
     *
     * @param birthday    the birthday
     * @param currentDate the current date
     * @return age age
     */
    public static int getAge(LocalDate birthday, LocalDate currentDate) {
        return Period.between(birthday, currentDate).getYears();
    }

    /**
     * Calculate the age at the current time.
     *
     * @param birthday the birthday
     * @return age age
     */
    public static int getAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        return getAge(birthday, currentDate);
    }

    /**
     * Checks the given date is between the two provided dates
     *
     * @param givenDate the given date
     * @param startDate the start date
     * @param endDate   the end date
     * @return boolean boolean
     */
    public static boolean isBetween(LocalDateTime givenDate, LocalDateTime startDate, LocalDateTime endDate) {
        return (!givenDate.isBefore(startDate)) && (givenDate.isBefore(endDate));
    }

    /**
     * Returns whether the given date is the last day of the month
     *
     * @param localDate the local date
     * @return boolean boolean
     */
    public static boolean isLastDayOfTheMonth(LocalDate localDate) {
        return localDate.with(lastDayOfMonth()).isEqual(localDate);
    }

    /**
     * Returns whether the given date falls in a weekend
     *
     * @param dt the dt
     * @return boolean boolean
     */
    public static boolean isWeekend(LocalDate dt) {
        switch (dt.getDayOfWeek()) {
            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
        }
    }

    /**
     * Check t1 has overlap with t1 or not
     * @param t1 first time
     * @param t2 second time
     * @return return true if given period has overlap
     */
    public static boolean hasOverlap(Interval t1, Interval t2) {
        return !t1.getEnd().isBefore(t2.getBegin()) && !t1.getBegin().isAfter(t2.getEnd());
    }
}
