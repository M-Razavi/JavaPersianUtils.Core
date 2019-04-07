package javapersianutils.core.validators;

import org.apache.commons.lang3.StringUtils;

import static javapersianutils.core.string.StringUtil.isNullOrWhiteSpace;
import static org.apache.commons.lang3.StringUtils.leftPad;

/**
 * Validate IR National Code
 */
public class NationalCodeUtils {

    private NationalCodeUtils() {
    }

    /**
     * If String is a number returns true
     *
     * @param data the data
     * @return boolean
     */
    public static boolean isNumber(String data) {
        return !isNullOrWhiteSpace(data) && StringUtils.isNumeric(data);
    }

    /**
     * Validate IR National Code
     *
     * @param nationalCode the national code
     * @return boolean
     */
    public static boolean isValidIranianNationalCode(String nationalCode) {
        if (isNullOrWhiteSpace(nationalCode)) {
            return false;
        }

        nationalCode = leftPad(nationalCode, 10, '0');

        final int nationalCodeLength = 10;
        if (nationalCode.length() != nationalCodeLength) {
            return false;
        }

        if (!isNumber(nationalCode)) {
            return false;
        }

        int j = nationalCodeLength;
        int sum = 0;
        for (int i = 0; i < nationalCode.length() - 1; i++) {
            sum += (int) Character.getNumericValue(nationalCode.charAt(i)) * j--;
        }

        int remainder = sum % 11;
        int controlNumber = (int) Character.getNumericValue(nationalCode.charAt(9));
        return remainder < 2 && controlNumber == remainder ||
                remainder >= 2 && controlNumber == 11 - remainder;
    }

}