/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (49.00%)
 * Likes:    11551
 * Dislikes: 645
 * Total Accepted:    1.2M
 * Total Submissions: 2.4M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
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
// Iterative:
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null) {
//             return true;
//         }

//         // Find middle.
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         // Reverse the right part.
//         ListNode reversedRight = null, next = null;
//         while (slow != null) {
//             next = slow.next;
//             slow.next = reversedRight;
//             reversedRight = slow;
//             slow = next;
//         }

//         // Check palindrome, i.e. check in the length of the right part
//         // whether the left part is equal to the reversed right part.
//         while (reversedRight != null) {
//             if (head.val != reversedRight.val) {
//                 return false;
//             }

//             head = head.next;
//             reversedRight = reversedRight.next;
//         }
//         return true;
//     }
// }

// Recursive:
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head, head);
        middle = reverse(middle);
        return isPalindrome(head, middle);
    }

    private void print(ListNode head) {
        if (head == null) {
            return;            
        }

        System.out.print(head.val + " ");
        print(head.next);
    }

    private ListNode findMiddle(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        
        return findMiddle(slow.next, fast.next.next);
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

    private boolean isPalindrome(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return true;
        }

        if (head1.val != head2.val) {
            return false;
        }

        return isPalindrome(head1.next, head2.next);
    }
}
// @lc code=end

