import java.util.Map;

/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
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
    //  * Solution 1: One Pass
    //  */
    // public ListNode removeZeroSumSublists(ListNode head) {
    //     ListNode dummy = new ListNode(0, head);
    //     Map<Integer, ListNode> map = new HashMap<>();
    //     int prefixSum = 0;
    //     ListNode curr = dummy;
    //     while (curr != null) {
    //         prefixSum += curr.val;
    //         if (map.containsKey(prefixSum)) {
    //             curr = map.get(prefixSum).next;
    //             int p = prefixSum + curr.val;
    //             while (p != prefixSum) {
    //                 map.remove(p);
    //                 curr = curr.next;
    //                 p += curr.val;
    //             }

    //             map.get(prefixSum).next = curr.next;
    //         } else {
    //             map.put(prefixSum, curr);
    //         }
            
    //         curr = curr.next;
    //     }
    //     return dummy.next;
    // }

    /**
     * Solution 2: Two Passes
     * 
     * head: [1,3,2,-3,-2,5,5,-5,1]
     * map: {
     *   0=[0,1,3,2,-3,-2,5,5,-5,1],
     *   1=[-2,5,5,-5,1],
     *   3=[-3,-2,5,5,-5,1],
     *   4=[3,2,-3,-2,5,5,-5,1],
     *   6=[-5,1],
     *   7=[1],
     *   11=[5,-5,1]
     * }
     * result: [1,5,1]
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        // prefixSum -> the last node
        Map<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;
        ListNode curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
            curr = curr.next;
        }

        // curr.next points to the next of the last node 
        // with the same prefix sum.
        prefixSum = 0;
        curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
            curr = curr.next;
        }
        return dummy.next;
    }

    private String mapToString(Map<Integer, ListNode> map) {
        StringBuilder sb = new StringBuilder("{");
        for (int key : map.keySet()) {
            sb.append(String.format("%d=[%s],", 
                    key, listToString(map.get(key))));
        }

        if (!map.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.append("}").toString();
    }

    private String listToString(ListNode head) {
        if (head.next == null) {
            return String.valueOf(head.val);
        }
        return String.format("%d,%s", head.val, listToString(head.next));
    }
}
// @lc code=end

