package javapersianutils.core.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Mahdi Razavi on 3/10/19-3:29 PM
 */
class AggressiveEditingTest {


    @Test
    void normalizeAllKashida() {
        assertEquals("الحمد", AggressiveEditing.normalizeAllKashida("الحمــــــد"));
        assertEquals("رحيم", AggressiveEditing.normalizeAllKashida("رحــــــيم"));
    }

    @Test
    void normalizeExtraMarks() {
        assertEquals("سلام خوبی؟", AggressiveEditing.normalizeExtraMarks("سلام خوبی؟؟؟"));
        assertEquals("من خوبم!", AggressiveEditing.normalizeExtraMarks("من خوبم!!!"));
    }

    @Test
    void normalizeOutsideInsideSpacing() {
        assertEquals("(پرانتز)", AggressiveEditing.normalizeOutsideInsideSpacing("  (پرانتز  )"));
        assertEquals("[براکت]", AggressiveEditing.normalizeOutsideInsideSpacing("  [براکت  ]"));
        assertEquals("“گیومه”", AggressiveEditing.normalizeOutsideInsideSpacing("  “گیومه  ”"));
        assertEquals("«گیومه»", AggressiveEditing.normalizeOutsideInsideSpacing("  « گیومه  »"));
    }

    @Test
    void normalizeSpacingAndLineBreaks() {
        assertEquals("آزمایش فاصله", AggressiveEditing.normalizeSpacingAndLineBreaks("آزمایش      فاصله  "));
    }

    @Test
    void normalizeUnderLines() {
        assertEquals("بررسی   زیرخط", AggressiveEditing.normalizeUnderLines("بررسی  ـ زیرخط"));

    }


    @Test
    void convertArabic1256ToUtf8() {
        assertEquals("??????????",AggressiveEditing.convertArabic1256ToUtf8("رحــــــيم"));

    }

}