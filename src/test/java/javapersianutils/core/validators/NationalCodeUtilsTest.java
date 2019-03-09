package javapersianutils.core.validators;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mahdi Razavi on 3/4/19-1:46 PM
 */


public class NationalCodeUtilsTest {

    @Test
    public void TestIsNumber1() {

        assertEquals(true, NationalCodeUtils.isNumber("0010350829"));
    }

    @Test
    public void TestIsNumber2() {
        assertEquals(false, NationalCodeUtils.isNumber("001a0350829"));
    }

    @Test
    public void NationalCodeValidationTest() {
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("0010350829"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCode1() {
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("0077611616"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCode2() {
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("0081037511"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCode3() {
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("172942284"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCode4() {
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("81037511"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCode5() {
        // http://www.fardanews.com/fa/news/127747/%D8%B1%D9%86%D8%AF%D8%AA%D8%B1%DB%8C%D9%86-%D8%B4%D9%85%D8%A7%D8%B1%D9%87-%D9%85%D9%84%DB%8C-%D8%A8%D9%84%D8%A7%DB%8C-%D8%AC%D8%A7%D9%86-%D8%B5%D8%A7%D8%AD%D8%A8%D8%B4-%D8%B4%D8%AF
        assertEquals(true, NationalCodeUtils.isValidIranianNationalCode("1111111111"));
    }

    @Test
    public void NationalCodeValidationTestCorrectCodeWithSpace() {
        assertEquals(false, NationalCodeUtils.isValidIranianNationalCode(" 0077611616  "));
    }

    @Test
    public void NationalCodeValidationTestEmptyString() {
        assertEquals(false, NationalCodeUtils.isValidIranianNationalCode(""));
    }

    @Test
    public void NationalCodeValidationTestShortString() {
        assertEquals(false, NationalCodeUtils.isValidIranianNationalCode("0254"));
    }

    @Test
    public void NationalCodeValidationTestWithDashes() {
        assertEquals(false, NationalCodeUtils.isValidIranianNationalCode("007-125698-4"));
    }


    @ParameterizedTest(name = "National code {0} is supported.")
    @ValueSource(strings =
            {"7731689956",
                    "45768676",
                    "15768643",
                    "15758648",
                    "0013542419",
                    "3240175800",
                    "3240164175",
                    "3370075024",
                    "0010532129",
                    "0860170470",
                    "1292794021",
            })
    public void ValidIranianNationalCodesTest(String code) {
        assertTrue(NationalCodeUtils.isValidIranianNationalCode(code));
    }


    @ParameterizedTest(name = "National code {0} is not supported.")
    @ValueSource(strings =
            {"7731685956",
                    "c9xk9dkd",
                    "15758448",
                    "324011122",
                    "3213213"})
    public void InvalidIranianNationalCodesTest(String code) {
        assertFalse(NationalCodeUtils.isValidIranianNationalCode(code));
    }

}
