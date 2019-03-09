package javapersianutils.core.validators;

import java.util.regex.Pattern;

import static javapersianutils.core.validators.StringUtil.isNullOrWhiteSpace;

/**
 * IranCodes Utils
 */
public class IranCodesUtils {


    private static final Pattern _matchIranianMobileNumber1 = Pattern.compile("^(((98)|(\\+98)|(0098)|0)(9){1}[0-9]{9})+$", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchIranianMobileNumber2 = Pattern.compile("^(9){1}[0-9]{9}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchIranianPhoneNumber = Pattern.compile("^[2-9][0-9]{7}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchIranianPostalCode = Pattern.compile("^(\\d{5}-?\\d{5})$", Pattern.CASE_INSENSITIVE);

    /**
     * Validate Iranian mobile number
     * @param mobileNumber
     * @return
     */
    public static boolean isValidIranianMobileNumber( String mobileNumber) {
        return !isNullOrWhiteSpace(mobileNumber) &&
                (_matchIranianMobileNumber1.matcher(mobileNumber).matches() || _matchIranianMobileNumber2.matcher(mobileNumber).matches());
    }

    /**
     * Validate Iranian phone number
     * @param phoneNumber
     * @return
     */
    public static boolean isValidIranianPhoneNumber(String phoneNumber) {
        return !isNullOrWhiteSpace(phoneNumber) && _matchIranianPhoneNumber.matcher(phoneNumber).matches();
    }

    /**
     * Validate Iranian postal code
     * @param postalCode
     * @return
     */
    public static boolean isValidIranianPostalCode(String postalCode) {
        return !isNullOrWhiteSpace(postalCode) && _matchIranianPostalCode.matcher(postalCode).matches();
    }

}
