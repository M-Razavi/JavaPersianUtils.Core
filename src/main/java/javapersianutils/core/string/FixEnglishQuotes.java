package javapersianutils.core.string;

/**
 * <h1>Fix</h1>
 * The Fix
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/21/2019
 */

import java.util.regex.Pattern;

/**
 * Replaces English quotes with their Persian equivalent
 */
public class FixEnglishQuotes {
    private static final Pattern _matchConvertEnglishQuotes = Pattern.compile("([\"\"'`]+)(.+?)\\1", Pattern.CASE_INSENSITIVE);

    /**
     * Replaces English quotes with their Persian equivalent.
     * It converts 'تست' to «تست»
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String NormalizeEnglishQuotes(String text) {
        return _matchConvertEnglishQuotes.matcher(text).replaceAll("«$2»");
    }
}
