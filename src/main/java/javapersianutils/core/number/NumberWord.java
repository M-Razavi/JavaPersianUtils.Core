package javapersianutils.core.number;

import java.util.List;

public class NumberWord {
    // Digit's group
    public DigitGroup Group;

    // Number to word language
    public Language Language;

    // Equivalent names
    public List<String> Names;

    public NumberWord(DigitGroup group, javapersianutils.core.number.Language language, List<String> names) {
        Group = group;
        Language = language;
        Names = names;
    }
}

