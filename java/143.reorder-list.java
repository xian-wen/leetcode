/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = middle(head, head);
        ListNode rightHead = mid.next;
        mid.next = null;

        rightHead = reverse(rightHead);
        head = combine(head, rightHead);
    }

    private ListNode middle(ListNode fast, ListNode slow) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        return middle(fast.next.next, slow.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    private ListNode combine(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode next1 = list1.next;
        list1.next = list2;
        list2.next = combine(next1, list2.next);
        return list1;
    }
}
// @lc code=end

