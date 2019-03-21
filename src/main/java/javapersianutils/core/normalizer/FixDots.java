package javapersianutils.core.normalizer;

import java.util.regex.Pattern;

/**
 * <h1>FixDot</h1>
 * The FixDot
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/21/2019
 */

/**
 * Replaces three dots with ellipsis
 */
public class FixDots {
    private static final Pattern _matchConvertDotsToEllipsis = Pattern.compile("\\s*\\.{3,}", Pattern.CASE_INSENSITIVE);

    /**
     * Replaces three dots with ellipsis
     * It converts آزمون.... to آزمون…
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String NormalizeDotsToEllipsis(String text) {
        return _matchConvertDotsToEllipsis.matcher(text).replaceAll("…");
    }
}
