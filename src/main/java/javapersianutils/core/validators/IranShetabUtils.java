package javapersianutils.core.validators;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

import static javapersianutils.core.string.StringUtil.isNullOrEmpty;

/**
 * Credit and Debit Card (Shetab) validation
 */
public class IranShetabUtils {

    private static final Pattern _matchIranShetab = Pattern.compile("[0-9]{16}", Pattern.CASE_INSENSITIVE);

    private IranShetabUtils() {
    }

    /**
     * validate Shetab card numbers
     *
     * @param creditCardNumber Shetab card number
     * @return boolean
     */
    public static boolean isValidIranShetabNumber(String creditCardNumber) {
        if (isNullOrEmpty(creditCardNumber)) {
            return false;
        }

        creditCardNumber = creditCardNumber.replace("-", StringUtils.EMPTY).replace(" ", StringUtils.EMPTY);

        if (creditCardNumber.length() != 16) {
            return false;
        }

        if (!_matchIranShetab.matcher(creditCardNumber).matches()) {
            return false;
        }

        int sumOfDigits = 0;
        int result = 0;
        for (int i = 1; i <= creditCardNumber.length(); i++) {
            int number = Integer.parseInt(creditCardNumber.charAt(i - 1) + "");
            sumOfDigits += ((result = number * (i % 2 == 0 ? 1 : 2)) > 9 ? (result - 9) : result);
        }
        return sumOfDigits % 10 == 0;
    }
}
