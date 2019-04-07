package javapersianutils.core.string;

import java.util.regex.Pattern;

import static javapersianutils.core.string.StringUtil.isNullOrEmpty;
import static javapersianutils.core.string.StringUtil.isNullOrWhiteSpace;

/**
 * Regular expression for checking Farsi language.
 */
public class RegexUtils {

    private static final Pattern _matchAllTags = Pattern.compile("<(.|\n)*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchArabicHebrew = Pattern.compile("[\u0622-\u0669,\u0600-\u06FF,\u0590-\u05FF,«,»]", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchOnlyPersianNumbersRange = Pattern.compile("^[\u06F0-\u06F9]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern _matchOnlyPersianLetters = Pattern.compile("^[\\s,\u06A9\u06AF\u06C0\u06CC\u060C,\u062A\u062B\u062C\u062D\u062E\u062F,\u063A\u064A\u064B\u064C\u064D\u064E,\u064F\u067E\u0670\u0686\u0698\u200C,\u0621-\u0629\u0630-\u0639\u0641-\u0654]+$", Pattern.CASE_INSENSITIVE);

    private RegexUtils() {
    }

    /**
     * آیا عبارت مدنظر حاوی حروف و اعداد فارسی است؟
     *
     * @param text the text
     * @return boolean
     */
    public static boolean containsFarsi(String text) {
        return !isNullOrEmpty(text) &&
                _matchArabicHebrew.matcher(stripHtmlTags(text).replace(",", "")).find();
    }


    /**
     * آیا عبارت مدنظر فقط حاوی حروف فارسی است؟
     *
     * @param text the text
     * @return boolean
     */
    public static boolean containsOnlyFarsiLetters(String text) {
        return !isNullOrEmpty(text) &&
                _matchOnlyPersianLetters.matcher(stripHtmlTags(text).replace(",", "")).matches();
    }


    /**
     * حذف تگ‌های یک عبارت
     *
     * @param text the text
     * @return string
     */
    public static String stripHtmlTags(String text) {
        return isNullOrEmpty(text) ?
                "" :
                _matchAllTags.matcher(text).replaceAll(" ").replace("&nbsp;", " ");
    }

    /**
     * اگر متن شما حاوی یک عبارت فارسی باشد آن‌را داخل یک بلاک اچ تی ام ال راست به چپ محصور می‌کند
     * در غیراینصورت در
     *
     * @param body the body
     * @return string
     */
    public static String wrapInDirectionalDiv(String body) {
        return wrapInDirectionalDiv(body, "tahoma", "9pt");
    }

    /**
     * اگر متن شما حاوی یک عبارت فارسی باشد آن‌را داخل یک بلاک اچ تی ام ال راست به چپ محصور می‌کند
     * در غیراینصورت در
     *
     * @param body       the body
     * @param fontFamily the font family
     * @param fontSize   the font size
     * @return string
     */
    public static String wrapInDirectionalDiv(String body, String fontFamily, String fontSize) {
        if (isNullOrWhiteSpace(body))
            return "";

        if (containsFarsi(body))
            return
                    "<div style='text-align: right; font-family:{fontFamily}; font-size:{fontSize};' dir='rtl'>{body}</div>";
        return
                "<div style='text-align: left; font-family:{fontFamily}; font-size:{fontSize};' dir='ltr'>{body}</div>";
    }


    /**
     * آیا عبارت مدنظر فقط حاوی اعداد فارسی است؟
     *
     * @param text the text
     * @return boolean
     */
    public static boolean containsOnlyPersianNumbers(String text) {
        return !isNullOrEmpty(text) &&
                _matchOnlyPersianNumbersRange.matcher(stripHtmlTags(text)).matches();
    }
}