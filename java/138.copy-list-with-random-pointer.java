import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    // /**
    //  * Solution 1: Iteration
    //  */
    // public Node copyRandomList(Node head) {
    //     Map<Node, Node> map = new HashMap<>();
    //     Node node = head;
    //     while (node != null) {
    //         map.put(node, new Node(node.val));
    //         node = node.next;
    //     }

    //     node = head;
    //     while (node != null) {
    //         map.get(node).next = map.get(node.next);
    //         map.get(node).random = map.get(node.random);
    //         node = node.next;
    //     }
    //     return map.get(head);
    // }

    // /**
    //  * Solution 2: Recursion
    //  */
    // public Node copyRandomList(Node head) {
    //     Map<Node, Node> map = new HashMap<>();
    //     return copyRandomList(head, map);
    // }

    // private Node copyRandomList(Node node, Map<Node, Node> map) {
    //     if (node == null) {
    //         return null;
    //     }

    //     if (map.containsKey(node)) {
    //         return map.get(node);
    //     }

    //     Node head = new Node(node.val);
    //     map.put(node, head);
    //     head.next = copyRandomList(node.next, map);
    //     head.random = copyRandomList(node.random, map);
    //     return head;
    // }

    /**
     * Solution 3: No Map + Use Next
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Copy each node in the original list.
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }

        // Assign the random pointers of the copied nodes.
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            
            node = node.next.next;
        }

        // Extract the copied list.
        Node copyHead = head.next;
        node = head;
        while (node != null) {
            Node copy = node.next;
            node.next = node.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            node = node.next;
        }
        return copyHead;
    }

    // /**
    //  * Solution 4: No Map + Use Random
    //  */
    // public Node copyRandomList(Node head) {
    //     if (head == null) {
    //         return null;
    //     }

    //     // Copy each node in the original list.
    //     Node node = head;
    //     while (node != null) {
    //         Node random = node.random;
    //         node.random = new Node(node.val);
    //         node.random.next = random;
    //         node = node.next;
    //     }

    //     // Assign the random pointers of the copied nodes.
    //     node = head;
    //     while (node != null) {
    //         Node copy = node.random;
    //         if (copy.next != null) {
    //             copy.random = copy.next.random;
    //         }
            
    //         node = node.next;
    //     }

    //     // Extract the copies list.
    //     Node copyHead = head.random;
    //     node = head;
    //     while (node != null) {
    //         Node copy = node.random;
    //         node.random = node.random.next;
    //         copy.next = node.next != null ? node.next.random : null;
    //         node = node.next;
    //     }
    //     return copyHead;
    // }

    private String listToString(Node head) {
        if (head == null) {
            return null;
        }

        if (head.random == null) {
            return String.format("[%d,null]->%s", 
                    head.val, listToString(head.next));
        }
        return String.format("[%d,%d]->%s", 
                head.val, head.random.val, listToString(head.next));
    }
}
// @lc code=end

