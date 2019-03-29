package javapersianutils.core.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilsTest {


    @Test
    void isBetween() {
        LocalDateTime satarday = LocalDateTime.parse("2019-03-16T00:00");
        LocalDateTime sunday = LocalDateTime.parse("2019-03-31T00:00");
        LocalDateTime wednesday = LocalDateTime.parse("2019-03-27T00:00");

        assertTrue(DateTimeUtils.isBetween(wednesday, satarday, sunday));
    }

    @Test
    void isLastDayOfTheMonth() {
        LocalDate satarday = LocalDate.parse("2019-03-30");
        assertFalse(DateTimeUtils.isLastDayOfTheMonth(satarday));

        LocalDate sunday = LocalDate.parse("2019-03-31");
        assertTrue(DateTimeUtils.isLastDayOfTheMonth(sunday));
    }

    @Test
    void isWeekend() {
        LocalDate friday = LocalDate.parse("2019-03-22");
        assertTrue(DateTimeUtils.isWeekend(friday));

        LocalDate wednesday = friday.minusDays(2);
        assertFalse(DateTimeUtils.isWeekend(wednesday));
    }


    @Test
    public void Test_GetAge_CorrectAge() {
        LocalDate now = LocalDate.now();
        LocalDate birthday = now.minusYears(32);

        int actualAge = DateTimeUtils.getAge(birthday);
        assertEquals(32, actualAge);
    }

    @Test
    public void Test_GetAgeFromAGivenDate_CorrectAge() {
        LocalDate now = LocalDate.now();
        LocalDate birthday = now.minusYears(32);

        int actualAge = DateTimeUtils.getAge(birthday, LocalDate.now().minusYears(2));
        assertEquals(30, actualAge);
    }

    @Test
    public void Test_checkOverlap_success() {
        LocalDateTime t1_start = LocalDateTime.now();
        LocalDateTime t1_end = LocalDateTime.now().plusHours(1);
        Interval t1 = new Interval(t1_start, t1_end);

        LocalDateTime t2_start = LocalDateTime.now().plusMinutes(40);
        LocalDateTime t2_end = LocalDateTime.now().plusHours(2);
        Interval t2 = new Interval(t2_start, t2_end);

        assertTrue(DateTimeUtils.hasOverlap(t1,t2));
    }

    @Test
    public void Test_checkNotOverlap_success() {
        LocalDateTime t1_start = LocalDateTime.now();
        LocalDateTime t1_end = LocalDateTime.now().plusHours(1);
        Interval t1 = new Interval(t1_start, t1_end);

        LocalDateTime t2_start = LocalDateTime.now().plusHours(2);
        LocalDateTime t2_end = LocalDateTime.now().plusHours(4);
        Interval t2 = new Interval(t2_start, t2_end);

        assertFalse(DateTimeUtils.hasOverlap(t1,t2));
    }
}