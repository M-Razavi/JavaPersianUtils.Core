package javapersianutils.core.datetime;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

class IntervalTest {

    @Test
    public void Test_initializeIntervalClass_success() {
        LocalDateTime t1_start = LocalDateTime.now();
        LocalDateTime t1_end = LocalDateTime.now().plusHours(1);
        Interval t1 = new Interval(t1_start, t1_end);

        t1.setBegin(t1_start.minusMinutes(50).atZone(ZoneId.systemDefault()).toInstant());
        t1.setEnd(t1_end.plusMinutes(50).atZone(ZoneId.systemDefault()).toInstant());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_initializeIntervalClass_fail() {
        LocalDateTime t1_start = LocalDateTime.now();
        LocalDateTime t1_end = LocalDateTime.now().plusHours(1);
        Interval t1 = new Interval(t1_end, t1_start);
    }

}