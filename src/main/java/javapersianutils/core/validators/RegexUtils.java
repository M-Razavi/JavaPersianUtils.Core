package javapersianutils.core.validators;

import java.util.regex.Pattern;

import static javapersianutils.core.validators.StringUtil.isNullOrEmpty;
import static javapersianutils.core.validators.StringUtil.isNullOrWhiteSpace;

/**
 *Regular expression for checking Farsi language.
 */
public class RegexUtils {


    private static final Pattern _matchAllTags = Pattern.compile("<(.|\n)*?>", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchArabicHebrew = Pattern.compile("[\u0622-\u0669,\u0600-\u06FF,\u0590-\u05FF,«,»]", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchOnlyPersianNumbersRange = Pattern.compile("^[\u06F0-\u06F9]+$", Pattern.CASE_INSENSITIVE);

    private static final Pattern _matchOnlyPersianLetters = Pattern.compile("^[\\s,\u06A9\u06AF\u06C0\u06CC\u060C,\u062A\u062B\u062C\u062D\u062E\u062F,\u063A\u064A\u064B\u064C\u064D\u064E,\u064F\u067E\u0670\u0686\u0698\u200C,\u0621-\u0629\u0630-\u0639\u0641-\u0654]+$", Pattern.CASE_INSENSITIVE);


    /**
     * آیا عبارت مدنظر حاوی حروف و اعداد فارسی است؟
     *
     * @param txt
     * @return
     */
    public static boolean ContainsFarsi(String txt) {
        return !isNullOrEmpty(txt) &&
                _matchArabicHebrew.matcher(StripHtmlTags(txt).replace(",", "")).find();
    }


    /**
     * آیا عبارت مدنظر فقط حاوی حروف فارسی است؟
     *
     * @param txt
     * @return
     */
    public static boolean ContainsOnlyFarsiLetters(String txt) {
        return !isNullOrEmpty(txt) &&
                _matchOnlyPersianLetters.matcher(StripHtmlTags(txt).replace(",", "")).matches();
    }


    /**
     * حذف تگ‌های یک عبارت
     *
     * @param text
     * @return
     */
    public static String StripHtmlTags(String text) {
        return isNullOrEmpty(text) ?
                "" :
                _matchAllTags.matcher(text).replaceAll(" ").replace("&nbsp;", " ");
    }

    /**
     * اگر متن شما حاوی یک عبارت فارسی باشد آن‌را داخل یک بلاک اچ تی ام ال راست به چپ محصور می‌کند
     * در غیراینصورت در
     *
     * @param body
     * @return
     */
    public static String WrapInDirectionalDiv(String body) {
        return WrapInDirectionalDiv(body, "tahoma", "9pt");
    }

    /**
     * اگر متن شما حاوی یک عبارت فارسی باشد آن‌را داخل یک بلاک اچ تی ام ال راست به چپ محصور می‌کند
     * در غیراینصورت در
     *
     * @param body
     * @param fontFamily
     * @param fontSize
     * @return
     */
    public static String WrapInDirectionalDiv(String body, String fontFamily, String fontSize) {
        if (isNullOrWhiteSpace(body))
            return "";

        if (ContainsFarsi(body))
            return
                    "<div style='text-align: right; font-family:{fontFamily}; font-size:{fontSize};' dir='rtl'>{body}</div>";
        return
                "<div style='text-align: left; font-family:{fontFamily}; font-size:{fontSize};' dir='ltr'>{body}</div>";
    }


    /**
     * آیا عبارت مدنظر فقط حاوی اعداد فارسی است؟
     *
     * @param text
     * @return
     */
    public static boolean ContainsOnlyPersianNumbers(String text) {
        return !isNullOrEmpty(text) &&
                _matchOnlyPersianNumbersRange.matcher(StripHtmlTags(text)).matches();
    }
}