package javapersianutils.core.normalizer;

import java.text.Normalizer;

import static javapersianutils.core.validators.StringUtil.isNullOrWhiteSpace;

/**
 * <h1>Fix Diacritics</h1>
 * حذف اعراب از حروف و کلمات
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 3/17/2019
 */
public class FixDiacritics {

    private FixDiacritics() {
    }

    /**
     * Delete sound (pronunciation mode) of letters and words
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String removeDiacritics(String text) {
        if (isNullOrWhiteSpace(text))
            return "";

        String normalizedString = Normalizer.normalize(text, Normalizer.Form.NFKC);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : normalizedString.toCharArray()) {
            int unicodeCategory = Character.getType(c);
            if (unicodeCategory != Character.NON_SPACING_MARK) {
                stringBuilder.append(c);
            }
        }
        return Normalizer.normalize(stringBuilder.toString(), Normalizer.Form.NFC);
    }
}