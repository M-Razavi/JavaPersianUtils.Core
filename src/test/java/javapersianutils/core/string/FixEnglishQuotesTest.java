package javapersianutils.core.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FixEnglishQuotesTest {

    @Test
    /**
     * ConvertEnglishQuotes should replace english quotes with their persian equivalent
     */
    void normalizeEnglishQuotes() {
        String test2 = "'تست'";
        String result2 = "«تست»";
        assertEquals(result2, FixEnglishQuotes.NormalizeEnglishQuotes(test2));

        String test3 = "''تست''";
        String result3 = "«تست»";
        assertEquals(result3, FixEnglishQuotes.NormalizeEnglishQuotes(test3));

        String test4 = "`تست`";
        String result4 = "«تست»";
        assertEquals(result4, FixEnglishQuotes.NormalizeEnglishQuotes(test4));

        String test5 = "``تست``";
        String result5 = "«تست»";
        assertEquals(result5, FixEnglishQuotes.NormalizeEnglishQuotes(test5));

        String test6 = "\"گفت: سلام\"";
        String result6 = "«گفت: سلام»";
        assertEquals(result6, FixEnglishQuotes.NormalizeEnglishQuotes(test6));

        String test7 = "\"\"آزمون\"\" or \"\"آزمون\"\"";
        String result7 = "«آزمون» or «آزمون»";
        assertEquals(result7, FixEnglishQuotes.NormalizeEnglishQuotes(test7));
    }
}