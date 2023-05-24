import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node() {
        }

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.size = 1;
        }

        @Override
        public String toString() {
            return key + "=" + val;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    } 

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }

        if (cmp > 0) {
            return get(node.right, key);
        }
        return node;
    }

    public void add(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key, val);
        } else if (cmp > 0) {
            node.right = add(node.right, key, val);
        } else {
            node.val = val;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node temp = node;
            node = min(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public K min() {
        return isEmpty() ? null : min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public K max() {
        return isEmpty() ? null : max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void removeMin() {
        if (isEmpty()) {
            return;
        }

        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            return;
        }

        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }

        node.right = removeMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        List<K> res = new ArrayList<>();
        if (lo == null || hi == null) {
            return res;
        }

        keys(root, lo, hi, res);
        return res;
    }

    private void keys(Node node, K lo, K hi, List<K> res) {
        if (node == null) {
            return;
        }

        int cmplo = node.key.compareTo(lo);
        int cmphi = node.key.compareTo(hi);
        if (cmplo > 0) {
            keys(node.left, lo, hi, res);
        } 
        
        if (cmplo >= 0 && cmphi <= 0) {
            res.add(node.key);
        } 
        
        if (cmphi < 0) {
            keys(node.right, lo, hi, res);
        }
    }

    public Iterable<K> inorder() {
        List<K> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node node, List<K> res) {
        if (node == null) {
            return;
        }

        inorder(node.left, res);
        res.add(node.key);
        inorder(node.right, res);
    }

    public Iterable<K> levelOrder() {
        List<K> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                continue;
            }

            res.add(node.key);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return res;
    }

    public boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node node, K min, K max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.key.compareTo(min) <= 0) {
            return false;
        }

        if (max != null && node.key.compareTo(max) >= 0) {
            return false;
        }
        return isBST(node.left, min, node.key) 
                && isBST(node.right, node.key, max);
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArray(10, -10, 10);
        System.out.println("nums: " + Arrays.toString(nums));

        BST<Integer, Integer> bst = new BST<>();
        for (int num : nums) {
            bst.add(num, num);
        }

        System.out.println("keys: " + bst.keys());
        System.out.println("keys(-5, 5): " + bst.keys(-5, 5));
        System.out.println("isBST: " + bst.isBST());
        System.out.println("size: " + bst.size());
        System.out.println("height: " + bst.height());
        System.out.println("contains(3): " + bst.contains(3));
        System.out.println("min: " + bst.min());
        System.out.println("max: " + bst.max());
        System.out.println("levelOrder: " + bst.levelOrder());
        System.out.println("inorder: " + bst.inorder());

        while (!bst.isEmpty()) {
            bst.remove(bst.min());
            System.out.printf("remove min: %s, size: %d, height: %d, isBST: %b\n", 
                    bst.inorder(), bst.size(), bst.height(), bst.isBST());

            bst.removeMax();
            System.out.printf("remove max: %s, size: %d, height: %d, isBST: %b\n", 
                    bst.inorder(), bst.size(), bst.height(), bst.isBST());
        }
    }

    private static int[] generateRandomArray(int size, int origin, int bound) {
        // Random r = new Random(12345);
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
