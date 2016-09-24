package com.sahaj.find_my_answers;

import java.util.*;

/**
 * Created by rupam.ghosh on 23/09/16.
 */
public class UsageUtil {
    public static Set<Integer> getQuestionUsage(String question, Map<String, Map<String, Integer>> questionIndex, Map<String, Set<Integer>> paragraphIndex) {
        Set<String> words = questionIndex.get(question).keySet();
        Map<Integer, Integer> usageInLines = new HashMap<Integer, Integer>();

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            Set<Integer> integers = paragraphIndex.get(iterator.next());
            if (integers != null) {
                for (Integer lineNumber : integers) {
                    int count = 0;
                    if (usageInLines.containsKey(lineNumber)) {
                        count = usageInLines.get(lineNumber);
                    }
                    usageInLines.put(lineNumber, count + 1);
                }
            }
        }
        PriorityQueue<Integer> sortedUsageInLines = new PriorityQueue<Integer>(10, new MapValueComparator(usageInLines));
        Set<Integer> usageCounts = usageInLines.keySet();
        for (Integer usageCount : usageCounts) {
            sortedUsageInLines.offer(usageCount);
        }

        Iterator<Integer> integerIterator = sortedUsageInLines.iterator();
        Set<Integer> smallerSet = new HashSet<Integer>();
        int lastNextUsage = 0;
        while (integerIterator.hasNext()) {
            int next = integerIterator.next();
            int nextUsage = usageInLines.get(next);
            if (nextUsage >= lastNextUsage) {
                smallerSet.add(next);
                lastNextUsage = nextUsage;
            }
        }
        return smallerSet;
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
