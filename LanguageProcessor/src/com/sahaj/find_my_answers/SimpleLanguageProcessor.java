package com.sahaj.find_my_answers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class SimpleLanguageProcessor implements LanguageProcessor {
    private static Set<String> BLACKLISTED_WORDS;

    static {
        String[] temp = {"What", "is", "of", "the", "some", "their", "are", "Which"};
        BLACKLISTED_WORDS = new HashSet<String>();
        for (String word : temp) {
            BLACKLISTED_WORDS.add(word);
        }
    }

    @Override
    public boolean shouldIndex(String word) {
        return !BLACKLISTED_WORDS.contains(word);
    }
}
