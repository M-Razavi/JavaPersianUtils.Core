package javapersianutils.core.normalizer;

import java.util.regex.Pattern;

/**
 * <h1>Fix Dash</h1>
 * Replaces double dash to ndash and triple dash to mdash
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/17/2019
 */
public class FixDash {
    private static final Pattern _matchFixDashes1 = Pattern.compile("-{3}", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchFixDashes2 = Pattern.compile("-{2}", Pattern.CASE_INSENSITIVE);

    private FixDash() {
    }

    /**
     * Replaces double dash to ndash and triple dash to mdash.
     * It converts آزمون--- to آزمون—
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeDashes(String text) {
        String phase1 = _matchFixDashes1.matcher(text).replaceAll("—");
        return _matchFixDashes2.matcher(phase1).replaceAll("–");
    }
}
