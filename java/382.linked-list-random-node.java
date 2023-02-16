import java.util.Random;

/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
 *
 * https://leetcode.com/problems/linked-list-random-node/description/
 *
 * algorithms
 * Medium (59.68%)
 * Likes:    1956
 * Dislikes: 471
 * Total Accepted:    164.4K
 * Total Submissions: 275.5K
 * Testcase Example:  '["Solution","getRandom","getRandom","getRandom","getRandom","getRandom"]\n' +
  '[[[1,2,3]],[],[],[],[],[]]'
 *
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Implement the Solution class:
 * 
 * 
 * Solution(ListNode head) Initializes the object with the head of the
 * singly-linked list head.
 * int getRandom() Chooses a node randomly from the list and returns its value.
 * All the nodes of the list should be equally likely to be chosen.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom",
 * "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 3, 2, 2, 3]
 * 
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the linked list will be in the range [1, 10^4].
 * -10^4 <= Node.val <= 10^4
 * At most 10^4 calls will be made to getRandom.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the linked list is extremely large and its length is unknown to
 * you?
 * Could you solve this efficiently without using extra space?
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
    // private ListNode head;

    // /**
    //  * Solution 1: get length.
    //  */
    // public Solution(ListNode head) {
    //     this.head = head;
    // }

    // public int getRandom() {
    //     int res = 0;
    //     int i = 1;
    //     ListNode p = head;
    //     while (p != null) {
    //         // The probability < 1 / i.
    //         if (Math.random() * i < 1) {
    //             res = p.val;
    //         }

    //         ++i;
    //         p = p.next;
    //     }
    //     return res;
    // }

    private int[] nums;
    private int N;
    private Random r;

    /**
     * Solution 2: get length.
     */
    public Solution(ListNode head) {
        N = length(head);
        nums = new int[N];
        ListNode p = head;
        int i = 0;
        while (p != null) {
            nums[i++] = p.val;
            p = p.next;
        }

        r = new Random();
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        }
        return length(head.next) + 1;
    }

    public int getRandom() {
        int index = r.nextInt(N);
        return nums[index];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

