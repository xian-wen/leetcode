import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = getValues(head);
        int N = vals.size();
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            while (!stack.isEmpty() && vals.get(i) > vals.get(stack.peek())) {
                res[stack.pop()] = vals.get(i);
            }

            stack.push(i);
        }
        return res;
    }

    private List<Integer> getValues(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}
// @lc code=end

