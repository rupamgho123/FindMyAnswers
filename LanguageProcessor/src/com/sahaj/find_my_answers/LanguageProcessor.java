package com.sahaj.find_my_answers;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public interface LanguageProcessor {
    /**
     *
     * @param word
     * @return whether passed word in argument should be indexed
     */
    boolean shouldIndex(String word);
}
