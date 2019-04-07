package javapersianutils.core.calendar;

import java.time.LocalDate;
import java.util.Objects;

/**
 * <h1>IranHolidays</h1>
 * The official holidays of Iran
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 4/8/2019
 */

public class Holiday {

    public LocalDate date;
    public String description;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return Objects.equals(date, holiday.date) &&
                Objects.equals(description, holiday.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description);
    }

    @Override
    public String toString() {
        return description;
    }
}
