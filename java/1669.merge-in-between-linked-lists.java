/*
 * @lc app=leetcode id=1669 lang=java
 *
 * [1669] Merge In Between Linked Lists
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node1 = list1, prev = null;
        int steps = 0;
        while (steps < a) {
            prev = node1;
            node1 = node1.next;
            ++steps;
        }

        prev.next = list2;
        while (steps <= b) {
            node1 = node1.next;
            ++steps;
        }

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = node1;
        return list1;
    }
}
// @lc code=end

