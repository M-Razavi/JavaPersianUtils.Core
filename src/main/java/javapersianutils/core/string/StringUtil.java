package javapersianutils.core.string;

/**
 * Created by Mahdi Razavi on 3/4/19-12:03 PM
 */
public interface StringUtil {

    static boolean isNullOrWhiteSpace(String input) {
        return isNullOrEmpty(input) || input.trim().length() == 0;
    }

    static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
