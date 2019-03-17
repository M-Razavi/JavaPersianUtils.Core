package javapersianutils.core.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FixDiacriticsTest {

    @Test
    void removeDiacritics1() {
        String actual = "وَحید";
        String result = FixDiacritics.removeDiacritics(actual);
        String expected = "وحید";
        assertEquals(expected, result);
    }

    @Test
    void removeDiacritics2() {
        String actual = "آفتاب";
        String result = FixDiacritics.removeDiacritics(actual);
        String expected = "آفتاب";
        assertEquals(expected, result);
    }
}