/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (54.79%)
 * Likes:    9299
 * Dislikes: 281
 * Total Accepted:    607.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[4,2,1,3]'
 *
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory
 * (i.e. constant space)?
 * 
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
    //  * Solution 1: Recursion
    //  */
    // public ListNode sortList(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode sortedNext = sortList(head.next);
    //     ListNode node = sortedNext;
    //     if (head.val <= node.val) {
    //         head.next = node;
    //         return head;
    //     }

    //     while (node.next != null && head.val > node.next.val) {
    //         node = node.next;
    //     }

    //     head.next = node.next;
    //     node.next = head;
    //     return sortedNext;
    // }

    /**
     * Solution 2: MergeSort
     */
    public ListNode sortList(ListNode head) {
        if (isSorted(head)) {
            return head;
        }

        ListNode mid = middle(head, head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge2Lists(left, right);
    }

    private boolean isSorted(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.val > head.next.val) {
            return false;
        }
        return isSorted(head.next);
    }

    private ListNode middle(ListNode fast, ListNode slow) {
        if (fast.next == null || fast.next.next == null) {
            return slow;
        }
        return middle(fast.next.next, slow.next);
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = merge2Lists(list1.next, list2);
            return list1;
        }

        list2.next = merge2Lists(list1, list2.next);
        return list2;
    }
}
// @lc code=end

