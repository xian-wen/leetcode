import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // /**
    //  * Solution 1
    //  */
    // public int numComponents(ListNode head, int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         set.add(num);
    //     }

    //     int count = 0;
    //     while (head != null) {
    //         if (set.contains(head.val) 
    //                 && (head.next == null || !set.contains(head.next.val))) {
    //             ++count;
    //         }

    //         head = head.next;
    //     }
    //     return count;
    // }

    /**
     * Solution 2: Idea of Union Find
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = nums.length;
        while (head.next != null) {
            if (set.contains(head.val) && set.contains(head.next.val)) {
                --count;
            }

            head = head.next;
        }
        return count;
    }

    private String listToString(ListNode head) {
        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

