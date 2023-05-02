import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 */

// @lc code=start
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
    //  * Solution 1: DFS
    //  */
    // public List<List<Integer>> verticalTraversal(TreeNode root) {
    //     // col -> (row -> vals)
    //     Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
    //     verticalTraversal(root, 0, 0, map);
    //     List<List<Integer>> res = new ArrayList<>();
    //     for (Map<Integer, List<Integer>> cols : map.values()) {
    //         List<Integer> list = new ArrayList<>();
    //         for (List<Integer> rows : cols.values()) {
    //             Collections.sort(rows);
    //             list.addAll(rows);
    //         }

    //         res.add(list);
    //     }
    //     return res;
    // }

    // private void verticalTraversal(TreeNode root, int row, int col, 
    //                                Map<Integer, Map<Integer, List<Integer>>> map) {
    //     if (root == null) {
    //         return;
    //     }

    //     map.putIfAbsent(col, new TreeMap<>());
    //     map.get(col).putIfAbsent(row, new ArrayList<>());
    //     map.get(col).get(row).add(root.val);
    //     verticalTraversal(root.left, row + 1, col - 1, map);
    //     verticalTraversal(root.right, row + 1, col + 1, map);
    // }

    private class Node implements Comparable<Node> {
        private int row, col;
        private TreeNode node;

        public Node(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }

        @Override
        public int compareTo(Node other) {
            if (this.col != other.col) {
                return Integer.compare(this.col, other.col);
            }

            if (this.row != other.row) {
                return Integer.compare(this.row, other.row);
            }
            return Integer.compare(this.node.val, other.node.val);
        }
    }

    /**
     * Solution 2: Priority Queue
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> pq = new PriorityQueue<>();
        verticalTraversal(root, 0, 0, pq);
        
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node cur = pq.peek();
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek().col == cur.col) {
                list.add(pq.poll().node.val);
            }

            res.add(list);
        }
        return res;
    }

    private void verticalTraversal(TreeNode root, int row, int col, 
                                   Queue<Node> pq) {
        if (root == null) {
            return;
        }

        pq.offer(new Node(row, col, root));
        verticalTraversal(root.left, row + 1, col - 1, pq);
        verticalTraversal(root.right, row + 1, col + 1, pq);
    }
}
// @lc code=end

