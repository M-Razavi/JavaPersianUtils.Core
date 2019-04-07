package javapersianutils.core.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceArabicCharTest {

    @Test
    public void Test_initializeIntervalClass_fail() {
        String textWithArabicChars = "کی";
        String textWithPersianChars = "کی";
        assertEquals(textWithPersianChars, ReplaceArabicChar.replaceArabicChar(textWithArabicChars));
    }

}