package javapersianutils.core.validators;


import javapersianutils.core.string.RegexUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Mahdi Razavi on 3/6/19-3:52 PM
 */
class RegexUtilsTest {

    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {
                    "Abc تست",
                    "،",
                    "٬",
                    "؛",
                    "»",
                    "«",
                    "؟",
                    "ی",
                    "۹",
                    "؛۹ی",
                    "aaیaa",
                    "a۹a",
                    "؛a",
                    "a؛۹ی"})
    public void Test_ContainsFarsi_Works(String text) {
        assertTrue(RegexUtils.containsFarsi(text));
    }

    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {
                    "this is not rtl",
                    "this-is-not-rtl",
                    "this,is,not,rtl"})
    public void Test_DoesNot_ContainFarsi_Works(String text) {
        assertFalse(RegexUtils.containsFarsi(text));
    }


    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {"۱۲۳",
                    "۴۵۶۷۸",
                    "۹۹۹۹۹"})
    public void Test_ContainsOnlyPersianNumbers_Works(String text) {
        assertTrue(RegexUtils.containsOnlyPersianNumbers(text));
    }

    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {"ابپ",
                    "ا۲بپ",
                    "1",
                    "1234"})
    public void Test_DoesNot_ContainsOnlyPersianNumbers_Works(String text) {
        assertFalse(RegexUtils.containsOnlyPersianNumbers(text));
    }

    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {"الب",
                    "تثج",
                    "چحخدذرز"})
    public void Test_ContainsOnlyFarsiLetters_Works(String text) {
        assertTrue(RegexUtils.containsOnlyFarsiLetters(text));
    }


    @ParameterizedTest(name = "Input text {0} contain Farsi.")
    @ValueSource(strings =
            {"اaلب",
                    "a",
                    "ا۲لب",
                    "۲",
                    "this is not rtl",
                    "this-is-not-rtl",
                    "this,is,not,rtl"})
    public void Test_DoesNot_ContainsOnlyFarsiLetters_Works(String text) {
        assertFalse(RegexUtils.containsOnlyFarsiLetters(text));
    }

}