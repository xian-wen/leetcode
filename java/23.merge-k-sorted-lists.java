import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (48.87%)
 * Likes:    15482
 * Dislikes: 581
 * Total Accepted:    1.5M
 * Total Submissions: 3.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 * 
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
    //  * Solution 1: priority queue.
    //  */
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0) {
    //         return null;
    //     }

    //     Queue<ListNode> pq = new PriorityQueue<>(
    //             (n1, n2) -> Integer.compare(n1.val, n2.val));
    //     for (ListNode list : lists) {
    //         if (list != null) {
    //             pq.offer(list);
    //         }
    //     }

    //     ListNode dummy = new ListNode(-1), cur = dummy;
    //     while (!pq.isEmpty()) {
    //         cur.next = pq.poll();
    //         cur = cur.next;
    //         if (cur.next != null) {
    //             pq.offer(cur.next);
    //         }
    //     }
    //     return dummy.next;
    // }

    /**
     * Solution 2: divide and conquer.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }

        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeKLists(lists, lo, mid);
        ListNode right = mergeKLists(lists, mid + 1, hi);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val < right.val) {
            left.next = merge2Lists(left.next, right);
            return left;
        }

        right.next = merge2Lists(left, right.next);
        return right;
    } 

    private void printQueue(Queue<ListNode> queue) {
        for (ListNode list : queue) {
            System.out.print(listToString(list) + " ");
        }

        System.out.println();
    }

    private String listToString(ListNode list) {
        if (list.next == null) {
            return String.valueOf(list.val);
        }
        return String.format("%d->%s", list.val, listToString(list.next));
    }
}
// @lc code=end

