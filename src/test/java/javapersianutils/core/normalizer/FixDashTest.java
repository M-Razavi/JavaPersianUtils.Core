package javapersianutils.core.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FixDashTest {

    @Test
    void normalizeDashes1() {

        String test = "آزمون--";
        String expected = "آزمون–";
        String result = FixDash.normalizeDashes(test);
        assertEquals(expected, result);
    }

    @Test
    void normalizeDashes2() {
        String test = "آزمون---";
        String expected = "آزمون—";
        String result = FixDash.normalizeDashes(test);
        assertEquals(expected, result);
    }

}