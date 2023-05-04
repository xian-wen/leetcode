/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = length(head);
        // The first remainder lists have (average + 1) nodes in each part,
        // the rest lists have average nodes in each part.
        int average = len / k, remainder = len % k, size = average;
        for (int i = 0; i < k; ++i) {
            if (i >= remainder) {
                if (average == 0) {
                    break;
                }

                size = average - 1;
            }

            res[i] = head;
            for (int j = 0; j < size; ++j) {
                head = head.next;
            }

            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return res;
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.next);
    }

    private String listsToString(ListNode[] lists) {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode list : lists) {
            sb.append("[").append(listToString(list)).append("],");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.append("]").toString();
    }

    private String listToString(ListNode head) {
        if (head == null) {
            return "";
        }

        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d->%s", head.val, listToString(head.next));
    }
}
// @lc code=end

