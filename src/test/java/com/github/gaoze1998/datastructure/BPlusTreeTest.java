package com.github.gaoze1998.datastructure;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BPlusTreeTest {
    private static List<Integer> testedInts = new ArrayList<>();

    static {
        testedInts.add(1);
        testedInts.add(4);
        testedInts.add(9);
        testedInts.add(16);
    }

    private int testedMethod(int key) {
        int start = 0, end = testedInts.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (testedInts.get(mid).compareTo(key) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return testedInts.get(start - 1);
    }
    @Test
    public void test() {
        Assert.assertEquals(9, testedMethod(15));
    }
}
