package com.github.gaoze1998.datastructure;

import lombok.*;

import java.util.List;

@Data
public class BPlusTree<T extends Comparable<T>> {
    private BPlusTreeNode root;

    @Data
    private class BPlusTreeNode {
        private List<BPlusTreeNodeSlot> slots;

        private BPlusTreeNodeSlot findFloor(T key) {
            int start = 0, end = slots.size();
            while (start < end) {
                int mid = (start + end) / 2;
                if (slots.get(mid).getKey().compareTo(key) < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return slots.get(start - 1);
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        private class BPlusTreeNodeSlot {
            private T key;
            private BPlusTreeNodeSlot pointer;
        }
    }
}
