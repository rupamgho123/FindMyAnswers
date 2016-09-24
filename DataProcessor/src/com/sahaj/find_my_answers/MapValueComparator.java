package com.sahaj.find_my_answers;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by rupam.ghosh on 24/09/16.
 */
public class MapValueComparator implements Comparator<Integer> {
    Map<Integer,Integer> usageInLines;

    MapValueComparator(Map<Integer,Integer> usageInLines) {
        this.usageInLines = usageInLines;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return -1 * usageInLines.get(o1).compareTo(usageInLines.get(o2));
    }
}
