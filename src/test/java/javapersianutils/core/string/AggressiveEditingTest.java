package javapersianutils.core.string;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

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

        assertEquals("سلام!", AggressiveEditing.normalizeExtraMarks("سلام!!!"));
        assertEquals("چطور؟", AggressiveEditing.normalizeExtraMarks("چطور؟؟؟"));
    }

    @Test
    void normalizeOutsideInsideSpacing() {
        assertEquals("(پرانتز)", AggressiveEditing.normalizeOutsideInsideSpacing("  (پرانتز  )"));
        assertEquals("[براکت]", AggressiveEditing.normalizeOutsideInsideSpacing("  [براکت  ]"));
        assertEquals("“گیومه”", AggressiveEditing.normalizeOutsideInsideSpacing("  “گیومه  ”"));
        assertEquals("«گیومه»", AggressiveEditing.normalizeOutsideInsideSpacing("  « گیومه  »"));

        //should not put space after time colon separator
        assertEquals("ساعت 12:34", AggressiveEditing.normalizeOutsideInsideSpacing("ساعت 12:34"));

        //no space before ":"
        assertEquals("گفت: سلام", AggressiveEditing.normalizeOutsideInsideSpacing("گفت : سلام"));

        //one space after "."
        assertEquals("سلام. \n\nkhoobi", AggressiveEditing.normalizeOutsideInsideSpacing("سلام.\n\nkhoobi"));

        //should fix spacing for () [] {}  “” «» (one space outside, no space inside)
        assertEquals("انجام «آزمون»", AggressiveEditing.normalizeOutsideInsideSpacing("انجام   «   آزمون   »  "));
    }

    @Test
    void normalizeSpacingAndLineBreaks() {
        assertEquals("آزمایش فاصله", AggressiveEditing.normalizeSpacingAndLineBreaks("آزمایش      فاصله  "));
        assertEquals("سلام world! I'm virastar", AggressiveEditing.normalizeSpacingAndLineBreaks("  سلام   world!  I'm virastar   "));
        assertEquals("this is \n\n\n\na آزمون",  AggressiveEditing.normalizeSpacingAndLineBreaks("this is \n \n \n     \n a آزمون"));
        assertEquals("this is\n\n\n\na آزمون",  AggressiveEditing.normalizeSpacingAndLineBreaks("this is\n\n\n\na آزمون"));
        assertEquals("this is \n\n\na آزمون",  AggressiveEditing.normalizeSpacingAndLineBreaks("this is \n\n\n    a آزمون"));
        assertEquals("this is \na آزمون",  AggressiveEditing.normalizeSpacingAndLineBreaks("this is \n  a آزمون"));
    }

    @Test
    void normalizeUnderLines() {
        assertEquals("بررسی   زیرخط", AggressiveEditing.normalizeUnderLines("بررسی  ـ زیرخط"));

    }


    @Test
    void convertArabic1256ToUtf8() throws UnsupportedEncodingException {
        assertEquals("??????????", AggressiveEditing.convertArabic1256ToUtf8("رحــــــيم"));

    }

}