import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class AVL<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;
        private int height;

        public Node() {
        }

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.size = 1;
            this.height = 1;
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
        return node.height;
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
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
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
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
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
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
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
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node balance(Node node) {
        int rootFactor = balanceFactor(node);
        int leftFactor = balanceFactor(node.left);
        int rightFactor = balanceFactor(node.right);
        
        if (rootFactor > 1) {           // LL, LR
            if (leftFactor < 0) {       // LR
                node.left = rotateLeft(node.left);
            }

            node = rotateRight(node);
        } else if (rootFactor < - 1) {  // RR, RL
            if (rightFactor > 0) {      // RL
                node.right = rotateRight(node.right);
            }

            node = rotateLeft(node);
        }
        return node;
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node node) {
        Node res = node.left;
        node.left = res.right;
        res.right = node;

        // If not use this trick, should update node size first!!!
        res.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        
        // Note the order is important!!!
        node.height = 1 + Math.max(height(node.left), height(node.right));
        res.height = 1 + Math.max(height(res.left), height(res.right));
        return res;
    }
    
    private Node rotateLeft(Node node) {
        Node res = node.right;
        node.right = res.left;
        res.left = node;
        
        // If not use this trick, should update node size first!!!
        res.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        
        // Note the order is important!!!
        node.height = 1 + Math.max(height(node.left), height(node.right));
        res.height = 1 + Math.max(height(res.left), height(res.right));
        return res;
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

    public boolean isAVL() {
        return isBST(root, null, null) && isBalanced(root);
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

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        if (Math.abs(balanceFactor(node)) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        int[] nums = generateRandomArray(10, -10, 10);
        System.out.println("nums: " + Arrays.toString(nums));

        AVL<Integer, Integer> avl = new AVL<>();
        for (int num : nums) {
            avl.add(num, num);
        }

        System.out.println("keys: " + avl.keys());
        System.out.println("keys(-5, 5): " + avl.keys(-5, 5));
        System.out.println("isAVL: " + avl.isAVL());
        System.out.println("size: " + avl.size());
        System.out.println("height: " + avl.height());
        System.out.println("contains(3): " + avl.contains(3));
        System.out.println("min: " + avl.min());
        System.out.println("max: " + avl.max());
        System.out.println("levelOrder: " + avl.levelOrder());
        System.out.println("inorder: " + avl.inorder());

        while (!avl.isEmpty()) {
            avl.remove(avl.min());
            System.out.printf("remove min: %s, size: %d, height: %d, isAVL: %b\n",
                    avl.inorder(), avl.size(), avl.height(), avl.isAVL());
            
            avl.removeMax();
            System.out.printf("remove max: %s, size: %d, height: %d, isAVL: %b\n",
                    avl.inorder(), avl.size(), avl.height(), avl.isAVL());
        }
    }

    private static int[] generateRandomArray(int size, int origin, int bound) {
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
