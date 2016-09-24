package com.sahaj.find_my_answers;

import java.util.*;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class WordIndexer {
    private static final String SPACE = " ";
    private LanguageProcessor languageProcessor;

    public WordIndexer(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;
    }

    public void indexWords(String line, Map<String, Map<String, Integer>> mainIndexedHash) {
        if (line != null) {
            Map<String, Integer> indexedHash = new HashMap<String, Integer>();
            String[] words = line.replaceAll("\\?", "").split(SPACE);
            for (String word : words) {
                if (languageProcessor.shouldIndex(word)) {
                    int count = 1;
                    if (indexedHash.containsKey(word)) {
                        count = indexedHash.get(word) + 1;
                    }
                    indexedHash.put(word, count);
                }
            }
            mainIndexedHash.put(line, indexedHash);
        }
    }

    public void indexWordsByCount(List<String> lines, Map<String, Map<String, Integer>> mainIndexedHash) {
        for (String line : lines) {
            indexWords(line, mainIndexedHash);
        }
    }

    public void indexWordsByLineNumber(List<String> lines, Map<String, Set<Integer>> mainIndexedHash) {
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String[] words = lines.get(lineIndex).replaceAll("\\?", "").split(SPACE);
            for (String word : words) {
                if (languageProcessor.shouldIndex(word)) {
                    Set<Integer> integerSet = mainIndexedHash.get(word);
                    if (integerSet == null) {
                        integerSet = new HashSet<Integer>();
                    }
                    integerSet.add(lineIndex);
                    mainIndexedHash.put(word, integerSet);
                }
            }
        }
    }
}
