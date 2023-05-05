/*
 * @lc app=leetcode id=1367 lang=java
 *
 * [1367] Linked List in Binary Tree
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

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // /**
    //  * Solution 1: Recursion
    //  */
    // public boolean isSubPath(ListNode head, TreeNode root) {
    //     if (head == null) {
    //         return true;
    //     }

    //     if (root == null) {
    //         return false;
    //     }

    //     if (isSubPathHelper(head, root)) {
    //         return true;
    //     }
    //     return isSubPath(head, root.left) || isSubPath(head, root.right);
    // }

    // private boolean isSubPathHelper(ListNode head, TreeNode root) {
    //     if (head == null) {
    //         return true;
    //     }

    //     if (root == null) {
    //         return false;
    //     }

    //     if (root.val != head.val) {
    //         return false;
    //     }
    //     return isSubPathHelper(head.next, root.left) 
    //             || isSubPathHelper(head.next, root.right);
    // }

    /**
     * Solution 2: KMP
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> vals = new ArrayList<>(), lps = new ArrayList<>();
        longestPrefixSuffix(head, vals, lps);
        return kmp(root, 0, vals, lps);
    }

    private boolean kmp(TreeNode root, int index, List<Integer> vals, 
                        List<Integer> lps) {
        if (index == vals.size()) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val != vals.get(index)) {
            index = lps.get(index);
            if (index >= 0) {
                return kmp(root, index, vals, lps);
            }
        }
        return kmp(root.left, index + 1, vals, lps) 
                || kmp(root.right, index + 1, vals, lps);
    }

    private void longestPrefixSuffix(ListNode head, List<Integer> vals,                    
                                     List<Integer> lps) {
        vals.add(head.val);
        lps.add(-1);

        int cnd = 0;
        head = head.next;
        while (head != null) {
            vals.add(head.val);
            if (head.val == vals.get(cnd)) {
                lps.add(lps.get(cnd));
            } else {
                lps.add(cnd);
                while (cnd >= 0 && head.val != vals.get(cnd)) {
                    cnd = lps.get(cnd);
                }
            }

            ++cnd;
            head = head.next;
        }
    }
}
// @lc code=end

