package javapersianutils.core.validators;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IranCodesUtilsTest {


    @ParameterizedTest(name = "Iran postal code {0} is supported.")
    @ValueSource(strings =
            {"1619735744",
                    "16197-35744"})
    public void ValidIranianPostalCodesTest(String code) {
        Assertions.assertTrue(IranCodesUtils.isValidIranianPostalCode(code));
    }

    @ParameterizedTest(name = "Iran postal code {0} is not supported.")
    @ValueSource(strings =
            {"116197-35744",
                    "11619735744"})
    public void InvalidIranianPostalCodesTest(String code) {
        Assertions.assertFalse(IranCodesUtils.isValidIranianPostalCode(code));
    }

    @ParameterizedTest(name = "Iran postal code {0} is supported.")
    @ValueSource(strings =
            {"37236445"})
    public void ValidIranianPhoneNumbersTest(String code) {
        Assertions.assertTrue(IranCodesUtils.isValidIranianPhoneNumber(code));
    }

    @ParameterizedTest(name = "Phone number  {0} is not supported.")
    @ValueSource(strings = {
            "07236445",
            "7236445",
            "17236445"})
    public void InvalidIranianPhoneNumbersTest(String code) {
        Assertions.assertFalse(IranCodesUtils.isValidIranianPostalCode(code));
    }

    @ParameterizedTest(name = "Mobile number {0} is supported.")
    @ValueSource(strings = {
            "+989355214655",
            "989355214655",
            "00989355214655",
            "09355214655",
            "09901464762",
            "9901464762"})
    public void ValidIranianMobileNumbersTest(String code) {
        Assertions.assertTrue(IranCodesUtils.isValidIranianMobileNumber(code));
    }


    @ParameterizedTest(name = "Mobile number {0} is not supported.")
    @ValueSource(strings =
            {"0935521465"})
    public void InvalidIranianMobileNumbersTest(String code) {
        Assertions.assertFalse(IranCodesUtils.isValidIranianMobileNumber(code));
    }


}
