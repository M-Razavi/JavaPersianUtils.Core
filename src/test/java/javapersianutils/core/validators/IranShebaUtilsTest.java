package javapersianutils.core.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IranShebaUtilsTest {


    @ParameterizedTest(name = "Iran sheba code {0} is supported.")
    @ValueSource(strings =
            {"IR820540102680020817909002",
                    "IR062960000000100324200001"})
    public void ValidIranShebaCodesTest(String code) {
        Assertions.assertTrue(IranShebaUtils.isValidIranShebaNumber(code));
    }

    @ParameterizedTest(name = "Iran sheba code {0} is supported.")
    @ValueSource(strings =
            {"IR01234567890123456789",
                    "IR012345678901234567890123456789",
                    "IR01234567890123456789",
                    "IR012345678901234567890123",
                    "IR06296000000010032420000",
                    "00062960000000100324200001"})
    public void InvalidIranShebaCodesTest(String code) {
        Assertions.assertFalse(IranShebaUtils.isValidIranShebaNumber(code));
    }

}
