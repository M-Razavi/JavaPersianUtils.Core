package javapersianutils.core.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * <h1>Interval</h1>
 * The Interval which store start and end time of a period
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /29/2019
 */
public class Interval {

    private java.time.Instant begin;
    private java.time.Instant end;

    /**
     * Instantiates a new Interval.
     *
     * @param begin the begin
     * @param end   the end
     */
    public Interval(Instant begin, Instant end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * Instantiates a new Interval.
     *
     * @param begin the begin
     * @param end   the end
     */
    public Interval(LocalDateTime begin, LocalDateTime end) {
        this.setBegin(begin.atZone(ZoneId.systemDefault()).toInstant());
        this.setEnd(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Instantiates a new Interval.
     *
     * @param begin the begin
     * @param end   the end
     */
    public Interval(long begin, long end) {
        this.setBegin(java.time.Instant.ofEpochMilli(begin));
        this.setEnd(java.time.Instant.ofEpochMilli(end));
    }

    /**
     * Gets begin.
     *
     * @return the begin
     */
    public Instant getBegin() {
        return begin;
    }

    /**
     * Sets begin.
     *
     * @param begin the begin
     */
    public void setBegin(Instant begin) {
        if (this.end == null || (this.end != null && begin.isBefore(this.end)) ){
            this.begin = begin;
        }
        else {
            throw new IllegalArgumentException("the begin should be before of the end.");
        }
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public Instant getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(Instant end) {
        if (this.begin == null || (this.begin != null && begin.isBefore(end)) ){
            this.end = end;
        }
        else {
            throw new IllegalArgumentException("the begin should be before of the end.");
        }
    }
}
