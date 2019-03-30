package javapersianutils.core.normalizer;

import javapersianutils.core.validators.StringUtil;

/**
 * <h1>ReplaceArabicChar</h1>
 * The ReplaceArabicChar
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3 /31/2019
 */
public class ReplaceArabicChar {

    /**
     * Arabic Ke Char \u0643 = ARABIC LETTER KAF
     */
    public static final char ARABIC_KE_CHAR = (char) 1603;
    /**
     * Arabic Ye Char \u0649 = ARABIC LETTER ALEF MAKSURA
     */
    public static final char ARABIC_YE_CHAR1 = (char) 1609;
    /**
     * Arabic Ye Char \u064A = ARABIC LETTER YEH
     */
    public static final char ARABIC_YE_CHAR2 = (char) 1610;
    /**
     * Persian Ke Char \u06A9 = ARABIC LETTER KEHEH
     */
    public static final char PERSIAN_KE_CHAR = (char) 1705;
    /**
     * Persian Ye Char \u06CC = ARABIC LETTER FARSI YEH
     */
    public static final char PERSIAN_YE_CHAR = (char) 1740;

    private ReplaceArabicChar() {
    }

    /**
     * Fixes common writing mistakes caused by using a bad keyboard layout,
     * such as replacing Arabic Ye with Persian one and so on ...
     *
     * @param data the data
     * @return the string
     */
    public static String replaceArabicChar(String data) {
        return StringUtil.isNullOrWhiteSpace(data) ?
                "" :
                data.replace(ARABIC_YE_CHAR1, PERSIAN_YE_CHAR)
                        .replace(ARABIC_YE_CHAR2, PERSIAN_YE_CHAR)
                        .replace(ARABIC_KE_CHAR, PERSIAN_KE_CHAR)
                        .trim();
    }
}
