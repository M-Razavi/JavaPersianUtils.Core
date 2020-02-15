package javapersianutils.core.number;

import java.util.*;

/**
 * The type Human readable integer.
 */
public class HumanReadableInteger {

    private static final Map<Language, String> _and = new HashMap() {{
        put(Language.English, " ");
        put(Language.Persian, " و ");
    }};

    private static final List<NumberWord> _numberWords = new ArrayList<NumberWord>() {{
        add(new NumberWord(DigitGroup.Ones, Language.English, Arrays.asList("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")));
        add(new NumberWord(DigitGroup.Ones, Language.Persian, Arrays.asList("", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه")));
        add(new NumberWord(DigitGroup.Teens, Language.English, Arrays.asList("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")));
        add(new NumberWord(DigitGroup.Teens, Language.Persian, Arrays.asList("ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده")));
        add(new NumberWord(DigitGroup.Tens, Language.English, Arrays.asList("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")));
        add(new NumberWord(DigitGroup.Tens, Language.Persian, Arrays.asList("بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود")));
        add(new NumberWord(DigitGroup.Hundreds, Language.English, Arrays.asList("", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred")));
        add(new NumberWord(DigitGroup.Hundreds, Language.Persian, Arrays.asList("", "یکصد", "دویست", "سیصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد")));
        add(new NumberWord(DigitGroup.Thousands, Language.English, Arrays.asList("", " Thousand", " Million", " Billion", " Trillion", " Quadrillion", " Quintillion", " Sextillian",
                " Septillion", " Octillion", " Nonillion", " Decillion", " Undecillion", " Duodecillion", " Tredecillion",
                " Quattuordecillion", " Quindecillion", " Sexdecillion", " Septendecillion", " Octodecillion", " Novemdecillion",
                " Vigintillion", " Unvigintillion", " Duovigintillion", " 10^72", " 10^75", " 10^78", " 10^81", " 10^84", " 10^87",
                " Vigintinonillion", " 10^93", " 10^96", " Duotrigintillion", " Trestrigintillion")));
        add(new NumberWord(DigitGroup.Thousands, Language.Persian, Arrays.asList("", " هزار", " میلیون", " میلیارد", " تریلیون", " Quadrillion", " Quintillion", " Sextillian",
                " Septillion", " Octillion", " Nonillion", " Decillion", " Undecillion", " Duodecillion", " Tredecillion",
                " Quattuordecillion", " Quindecillion", " Sexdecillion", " Septendecillion", " Octodecillion", " Novemdecillion",
                " Vigintillion", " Unvigintillion", " Duovigintillion", " 10^72", " 10^75", " 10^78", " 10^81", " 10^84", " 10^87",
                " Vigintinonillion", " 10^93", " 10^96", " Duotrigintillion", " Trestrigintillion")));
    }};


    private static final Map<Language, String> _negative = new HashMap() {{
        put(Language.English, "Negative ");
        put(Language.Persian, "منهای ");
    }};

    private static final Map<Language, String> _zero = new HashMap() {{
        put(Language.English, "Zero");
        put(Language.Persian, "صفر");
    }};


    /**
     * display a numeric value using the equivalent text
     *
     * @param number   the number
     * @param language the language
     * @return the equivalent text
     */
    public static String numberToText(int number, Language language) {
        return numberToText((long) number, language);
    }

    /**
     * display a numeric value using the equivalent text
     *
     * @param number   the number
     * @param language the language
     * @return the equivalent text
     */
    public static String numberToText(Long number, Language language) {
        return numberToText((long) number, language);
    }

    /**
     * display a numeric value using the equivalent text
     *
     * @param number   the number
     * @param language the language
     * @return the equivalent text
     */
    public static String numberToText(byte number, Language language) {
        return numberToText((long) number, language);
    }

    /**
     * display a numeric value using the equivalent text
     *
     * @param number   the number
     * @param language the language
     * @return the equivalent text
     */
    public static String numberToText(double number, Language language) {
        return numberToText((long) number, language);
    }

    /**
     * display a numeric value using the equivalent text
     *
     * @param number   the number
     * @param language the language
     * @return the equivalent text
     */
    public static String numberToText(long number, Language language) {
        if (number == 0) {
            return _zero.get(language);
        }
        if (number < 0) {
            return _negative.get(language) + numberToText(-number, language);
        }
        return wordify(number, language, "", 0);
    }

    private static String getName(int idx, Language language, DigitGroup group) {
        return _numberWords.stream().filter(numberWord -> numberWord.Group == group && numberWord.Language == language).findFirst().get().Names.get(idx);
    }

    private static String wordify(long number, Language language, String leftDigitsText, int thousands) {
        if (number == 0) {
            return leftDigitsText;
        }
        String wordValue = leftDigitsText;
        if (wordValue.length() > 0) {
            wordValue += _and.get(language);
        }
        if (number < 10) {
            wordValue += getName((int) number, language, DigitGroup.Ones);
        } else if (number < 20) {
            wordValue += getName((int) (number - 10), language, DigitGroup.Teens);
        } else if (number < 100) {
            wordValue += wordify(number % 10, language, getName((int) (number / 10 - 2), language, DigitGroup.Tens), 0);
        } else if (number < 1000) {
            wordValue += wordify(number % 100, language, getName((int) (number / 100), language, DigitGroup.Hundreds), 0);
        } else {
            wordValue += wordify(number % 1000, language, wordify(number / 1000, language, "", thousands + 1), 0);
        }
        if (number % 1000 == 0) return wordValue;
        return wordValue + getName(thousands, language, DigitGroup.Thousands);
    }
}