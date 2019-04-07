package javapersianutils.core.validators;


import java.util.regex.Pattern;

import static javapersianutils.core.string.StringUtil.isNullOrEmpty;

/**
 * Validate IBAN
 */
public class IranShebaUtils {

    private static final Pattern _matchIranSheba = Pattern.compile("IR[0-9]{24}", Pattern.CASE_INSENSITIVE);

    private IranShebaUtils() {
    }

    /**
     * Validate IBAN (International Bank Account Number, Sheba)
     *
     * @param iban International Bank Account Number, Sheba
     * @return result
     */
    public static boolean isValidIranShebaNumber(String iban) {
        if (isNullOrEmpty(iban)) {
            return false;
        }


        if (iban.length() < 4 || iban.charAt(0) == ' ' || iban.charAt(1) == ' ' || iban.charAt(2) == ' ' || iban.charAt(3) == ' ') {
            return false;
        }

        if (iban.length() != 26) {
            return false;
        }

        if (!_matchIranSheba.matcher(iban).matches()) {
            return false;
        }

        int checksum = 0;
        int ibanLength = iban.length();
        for (int charIndex = 0; charIndex < ibanLength; charIndex++) {
            if (iban.charAt(charIndex) == ' ') {
                continue;
            }

            int value;
            char c = iban.charAt((charIndex + 4) % ibanLength);
            if ((c >= '0') && (c <= '9')) {
                value = c - '0';
            } else if ((c >= 'A') && (c <= 'Z')) {
                value = c - 'A';
                checksum = (checksum * 10 + (value / 10 + 1)) % 97;
                value %= 10;
            } else if ((c >= 'a') && (c <= 'z')) {
                value = c - 'a';
                checksum = (checksum * 10 + (value / 10 + 1)) % 97;
                value %= 10;
            } else {
                return false;
            }

            checksum = (checksum * 10 + value) % 97;
        }
        return checksum == 1;
    }
}
