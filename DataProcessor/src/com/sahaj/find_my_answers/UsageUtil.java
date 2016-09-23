package com.sahaj.find_my_answers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class UsageUtil {
    public static Set<Integer> getQuestionUsage(String question, Map<String, Map<String, Integer>> questionIndex, Map<String, Set<Integer>> paragraphIndex) {
        Set<String> words = questionIndex.get(question).keySet();
        Set<Integer> usageInLines = new HashSet<Integer>();
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            Set<Integer> integers = paragraphIndex.get(iterator.next());
            if (integers != null) {
                usageInLines.addAll(integers);
            }
        }
        return usageInLines;
    }

    public static Set<Integer> getAnswerUsage(String answer, Map<String, Map<String, Integer>> answerIndex, Map<String, Set<Integer>> paragraphIndex) {
        Set<String> words = answerIndex.get(answer).keySet();
        Set<Integer> usageInLines = null;
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            Set<Integer> integers = paragraphIndex.get(iterator.next());
            if (integers != null) {
                if (usageInLines == null) {
                    usageInLines = new HashSet<Integer>();
                    usageInLines.addAll(integers);
                } else {
                    usageInLines.retainAll(integers);
                }
            }
        }
        return usageInLines;
    }
}
