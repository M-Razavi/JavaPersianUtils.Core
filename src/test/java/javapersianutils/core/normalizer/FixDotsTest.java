package javapersianutils.core.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FixDotsTest {

    /**
     * ConvertDotsToEllipsis should replace three dots with ellipsis
     */
    @Test
    void normalizeDotsToEllipsis() {
        String test = "آزمون...";
        String result = "آزمون…";
        assertEquals(result, FixDots.NormalizeDotsToEllipsis(test));

        String test2 = "آزمون....";
        String result2 = "آزمون…";
        assertEquals(result2, FixDots.NormalizeDotsToEllipsis(test2));

        String test3 = "خداحافظ ... به به";
        String result3 = "خداحافظ… به به";
        assertEquals(result3, FixDots.NormalizeDotsToEllipsis(test3));

        String test4 = "آزمون.........";
        String result4 = "آزمون…";
        assertEquals(result4, FixDots.NormalizeDotsToEllipsis(test4));
    }
}