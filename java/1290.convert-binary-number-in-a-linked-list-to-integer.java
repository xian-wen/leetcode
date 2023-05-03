/*
 * @lc app=leetcode id=1290 lang=java
 *
 * [1290] Convert Binary Number in a Linked List to Integer
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
    // public int getDecimalValue(ListNode head) {
    //     StringBuilder sb = new StringBuilder();
    //     while (head != null) {
    //         sb.append(head.val);
    //         head = head.next;
    //     }
    //     return Integer.parseInt(sb.toString(), 2);
    // }

    /**
     * Solution 2
     */
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            // sum = sum * 2 + head.val;
            sum = (sum << 1) | head.val;
            head = head.next;
        }
        return sum;
    }
}
// @lc code=end

