package javapersianutils.core.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixZwnjTest {

    /**
     * ApplyHalfSpaceRule should put zwnj between word and prefix suffix
     */
    @Test
    void applyHalfSpaceRule() {
    
        String test = "ما می توانیم";
        String result = "ما می‌توانیم";
        assertEquals(result, FixZwnj.applyHalfSpaceRule(test));

        String test2 = "ما نمی توانیم";
        String result2 = "ما نمی‌توانیم";
        assertEquals(result2, FixZwnj.applyHalfSpaceRule(test2));

        String test3 = "این بهترین کتاب ها است";
        String result3 = "این بهترین کتاب‌ها است";
        assertEquals(result3, FixZwnj.applyHalfSpaceRule(test3));

        String test4 = "بزرگ تری و قدرتمند ترین زبان های دنیا";
        String result4 = "بزرگ‌تری و قدرتمند‌ترین زبان‌های دنیا";
        assertEquals(result4, FixZwnj.applyHalfSpaceRule(test4));

        String test5 = "زمانیکه نگارش";
        String result5 = "زمانیکه نگارش";
        assertEquals(result5, FixZwnj.applyHalfSpaceRule(test5));
    }

    @Test
    /**
     *  CleanupZwnj should remove unnecessary zwnj chars that are succeeded preceded by a space
     */
    void normalizeZwnj() {
        String test = "سلام‌ دنیا";// before space
        String result = "سلام دنیا";
        assertEquals(result, FixZwnj.normalizeZwnj(test));

        String test2 = "سلام ‌دنیا"; //after space
        String result2 = "سلام دنیا";
        assertEquals(result2, FixZwnj.normalizeZwnj(test2));
    }


}