package com.sahaj.find_my_answers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class SimpleLanguageProcessor implements LanguageProcessor{
    private static List<String> BLACKLISTED_WORDS;
    static {
        String[] temp = {"What","is","of","the","some","their","are","Which"};
        BLACKLISTED_WORDS = Arrays.asList(temp);
    }

    @Override
    public boolean shouldIndex(String word) {
        return !BLACKLISTED_WORDS.contains(word);
    }
}
