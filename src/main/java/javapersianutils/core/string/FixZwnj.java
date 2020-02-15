package javapersianutils.core.string;

/**
 * <h1>Fixx</h1>
 * The Fixx
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/21/2019
 */


import java.util.regex.Pattern;

/**
 * Puts zwnj char/half space between word and prefix/suffix
 */
public class FixZwnj {

    private static final Pattern _matchApplyHalfSpaceRule1 = Pattern.compile("\\s+(ن?می)\\s+", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchApplyHalfSpaceRule2 = Pattern.compile("\\s+(تر(ی(ن)?)?|ها(ی)?)\\s+", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchCleanupZwnj = Pattern.compile("\\s+‌|‌\\s+", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchYeHeHalfSpace = Pattern.compile("(\\S)(ه[\\s‌]+[یی])(\\s)", Pattern.CASE_INSENSITIVE);

    /**
     * Adds zwnj char between word and prefix/suffix
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String applyHalfSpaceRule(String text) {
        text = normalizeZwnj(text);

        //put zwnj between word and prefix (mi* nemi*)
        String phase1 = _matchApplyHalfSpaceRule1.matcher(text).replaceAll(" $1‌");

        //put zwnj between word and suffix (*tar *tarin *ha *haye)
        String phase2 = _matchApplyHalfSpaceRule2.matcher(phase1).replaceAll("‌$1 ");

        String phase3 = normalizeYeHeHalfSpace(phase2);
        return phase3;
    }


    /**
     * Removes unnecessary zwnj char that are succeeded/preceded by a space
     *
     * @param text the text
     * @return string
     */
    public static String normalizeZwnj(String text) {
        return _matchCleanupZwnj.matcher(text).replaceAll(" ");
    }


    /**
     * Converts ه ی to ه‌ی
     *
     * @param text the text
     * @return string
     */
    public static String normalizeYeHeHalfSpace(String text) {
        return _matchYeHeHalfSpace.matcher(text).replaceAll("$1ه‌ی‌$3"); // fix zwnj
    }
}
