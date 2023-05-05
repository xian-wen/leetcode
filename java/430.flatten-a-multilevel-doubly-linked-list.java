/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // /**
    //  * Solution 1: Iteration
    //  * 
    //  * Similar to LeetCode 114.
    //  */
    // public Node flatten(Node head) {
    //     Node node = head;
    //     while (node != null) {
    //         // Has child.
    //         if (node.child != null) {
    //             // Find the tail of child.
    //             Node childNext = node.child;
    //             while (childNext.next != null) {
    //                 childNext = childNext.next;
    //             }

    //             // Connect tail with node.next.
    //             childNext.next = node.next;
    //             if (node.next != null) {
    //                 node.next.prev = childNext;
    //             }

    //             // Connect node with node.child and remove node.child.
    //             node.next = node.child;
    //             node.child.prev = node;
    //             node.child = null;
    //         }

    //         // No child or finish flatten.
    //         node = node.next;
    //     }
    //     return head;
    // }

    /**
     * Solution 2: Recursive
     * 
     * Similar to LeetCode 114.
     */
    public Node flatten(Node head) {
        return flattenHelper(head, null);
    }

    public Node flattenHelper(Node head, Node prev) {
        if (head == null) {
            return prev;
        }

        Node next = flattenHelper(head.next, prev);
        Node child = flattenHelper(head.child, next);
        
        if (child == null) {
            return head;
        }

        // Do not forget to set head.child to null!!!
        head.next = child;
        child.prev = head;
        head.child = null;
        return head;
    }
}
// @lc code=end

