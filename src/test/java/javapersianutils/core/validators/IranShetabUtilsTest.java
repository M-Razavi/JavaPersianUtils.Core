package javapersianutils.core.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class IranShetabUtilsTest {

    @ParameterizedTest(name = "Iran sheba code {0} is supported.")
    @ValueSource(strings =
            {"6221061106498670",
                    "636214-1075165358",
                    "6274129005473742"})
    public void ValidIranShetabCodesTest(String code) {
        Assertions.assertTrue(IranShetabUtils.isValidIranShetabNumber(code));
    }


    @ParameterizedTest(name = "Iran sheba code {0} is supported.")
    @ValueSource(strings =
            {"6274129107473842",
                    "627412900742",
                    "62741290054737423252"})
    public void InvalidIranShetabCodesTest(String code) {
        Assertions.assertFalse(IranShetabUtils.isValidIranShetabNumber(code));
    }

}