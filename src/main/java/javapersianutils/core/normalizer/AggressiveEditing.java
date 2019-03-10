package javapersianutils.core.normalizer;


import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import static javapersianutils.core.validators.StringUtil.isNullOrWhiteSpace;

/**
 * replace all more than one ! or ? marks with just one or removes all extra kashida and spaces
 */
public class AggressiveEditing {

    private static final Pattern _matchCleanupExtraMarks1 = Pattern.compile("(!){2,}", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchCleanupExtraMarks2 = Pattern.compile("(؟){2,}", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchCleanupSpacingAndLineBreaks1 = Pattern.compile("[ ]+", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchCleanupSpacingAndLineBreaks2 = Pattern.compile("([\n]+)[   ‌]*", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchRemoveAllKashida = Pattern.compile("ـ+", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchRemoveOutsideInsideSpacing1 = Pattern.compile("[   ‌]*(\\()\\s*([^)]+?)\\s*?(\\))[   ‌]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing10 = Pattern.compile("(\\{)\\s*([^)]+?)\\s*?(\\})", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing11 = Pattern.compile("(“)\\s*([^)]+?)\\s*?(”)", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing12 = Pattern.compile("(«)\\s*([^)]+?)\\s*?(»)", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing2 = Pattern.compile("[   ‌]*(\\[)\\s*([^)]+?)\\s*?(\\])[   ‌]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing3 = Pattern.compile("[   ‌]*(\\{)\\s*([^)]+?)\\s*?(\\})[   ‌]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing4 = Pattern.compile("[   ‌]*(“)\\s*([^)]+?)\\s*?(”)[   ‌]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing5 = Pattern.compile("[   ‌]*(«)\\s*([^)]+?)\\s*?(»)[   ‌]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing6 = Pattern.compile("[ ?  ]*([:;,??.?!]{1})[ ?  ]*", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing7 = Pattern.compile("([0-9]+):\\s+([0-9]+)", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing8 = Pattern.compile("(\\()\\s*([^)]+?)\\s*?(\\))", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchRemoveOutsideInsideSpacing9 = Pattern.compile("(\\[)\\s*([^)]+?)\\s*?(\\])", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchHexadecimalSymbols = Pattern.compile("[\\x00-\\x08\\x0B\\x0C\\x0E-\\x1F]", Pattern.CASE_INSENSITIVE);

    /**
     * Removes all kashida
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeAllKashida(String text) {
        return _matchRemoveAllKashida.matcher(text).replaceAll("");
    }


    /**
     * replaceAlls more than one ! or ? mark with just one
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeExtraMarks(String text) {
        String phase1 = _matchCleanupExtraMarks1.matcher(text).replaceAll("$1");
        String phase2 = _matchCleanupExtraMarks2.matcher(phase1).replaceAll("$1");
        return phase2;
    }

    /**
     * Fixes outside and inside spacing for () [] {}  “” «»
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeOutsideInsideSpacing(String text) {
        //should fix outside and inside spacing for () [] {}  “” «»
        String phase1 = _matchRemoveOutsideInsideSpacing1.matcher(text).replaceAll(" $1$2$3 ");
        String phase2 = _matchRemoveOutsideInsideSpacing2.matcher(phase1).replaceAll(" $1$2$3 ");
        String phase3 = _matchRemoveOutsideInsideSpacing3.matcher(phase2).replaceAll(" $1$2$3 ");
        String phase4 = _matchRemoveOutsideInsideSpacing4.matcher(phase3).replaceAll(" $1$2$3 ");
        String phase5 = _matchRemoveOutsideInsideSpacing5.matcher(phase4).replaceAll(" $1$2$3 ");

        // : ; , . ! ? and their Persian equivalents should have one space after and no space before
        String phase6 = _matchRemoveOutsideInsideSpacing6.matcher(phase5).replaceAll("$1 ");

        // do not put space after colon that separates time parts
        String phase7 = _matchRemoveOutsideInsideSpacing7.matcher(phase6).replaceAll("$1:$2");

        //should fix inside spacing for () [] {}  “” «»
        String phase8 = _matchRemoveOutsideInsideSpacing8.matcher(phase7).replaceAll("$1$2$3");
        String phase9 = _matchRemoveOutsideInsideSpacing9.matcher(phase8).replaceAll("$1$2$3");
        String phase10 = _matchRemoveOutsideInsideSpacing10.matcher(phase9).replaceAll("$1$2$3");
        String phase11 = _matchRemoveOutsideInsideSpacing11.matcher(phase10).replaceAll("$1$2$3");
        String phase12 = _matchRemoveOutsideInsideSpacing12.matcher(phase11).replaceAll("$1$2$3");

        return phase12.trim();
    }


    /**
     * replaceAlls more than one space or line break with just a single one
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeSpacingAndLineBreaks(String text) {
        String phase1 = _matchCleanupSpacingAndLineBreaks1.matcher(text).replaceAll(" ");
        String phase2 = _matchCleanupSpacingAndLineBreaks2.matcher(phase1).replaceAll("$1");
        return phase2.trim();
    }


    /**
     * Clean UnderLines
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String normalizeUnderLines(String text) {
        if (isNullOrWhiteSpace(text))
            return "";

        final char chr1600 = (char) 1600; //ـ=1600
        final char chr8204 = (char) 8204; //‌=8204

        return text.replaceAll(chr1600 + "", "")
                .replaceAll(chr8204 + "", "");
    }

    /**
     * There are a lot of symbols which can't be in xml code.
     *
     * @param text Text to process
     * @return Processed Text
     */
    public static String removeHexadecimalSymbols(String txt) {
        return isNullOrWhiteSpace(txt) ?
                "" : _matchHexadecimalSymbols.matcher(txt).replaceAll("");
    }

    /**
     * Convert an ASCII Arabic text to Unicode
     *
     * @param text
     * @return
     */
    public static String convertArabic1256ToUtf8(String text) {
        String string = new StringEscapeUtils().unescapeHtml4(text);
        byte[] b = string.getBytes(StandardCharsets.ISO_8859_1);
        try {
            return new String(b, "Windows-1256");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}