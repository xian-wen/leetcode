import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Trie {
    private static final int R = 26;
    private Node root;

    private class Node {
        private Node[] next;
        private boolean isWord;

        public Node() {
            next = new Node[R];
        }
    }

    public Trie() {
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node node, String word, int index) {
        if (node == null) {
            node = new Node();
        }

        if (index == word.length()) {
            node.isWord = true;
        } else {
            char c = word.charAt(index);
            node.next[c - 'a'] = insert(node.next[c - 'a'], word, index + 1);
        }
        return node;
    }

    public boolean search(String word) {
        Node node = search(root, word, 0);
        return node == null ? false : node.isWord;
    }

    private Node search(Node node, String word, int index) {
        if (node == null || index == word.length()) {
            return node;
        }

        char c = word.charAt(index);
        return search(node.next[c - 'a'], word, index + 1);
    }

    public boolean startsWith(String prefix) {
        Node node = search(root, prefix, 0);
        return node != null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of strings: ");
        int size = sc.nextInt();
        System.out.println("Please input the range of string length [min, max]: ");
        int minLen = sc.nextInt();
        int maxLen = sc.nextInt();
        String[] ss = generateRandomStrings(size, minLen, maxLen);
        sc.close();

        Trie trie = new Trie();
        for (String s : ss) {
            trie.insert(s);
        }

        System.out.println("All strings in " + Arrays.toString(ss) 
                + " are inserted.");

        for (String s : ss) {
            String prefix = s.substring(0, s.length() / 2);
            System.out.printf("search(%s): %b\n", s, trie.search(s));
            System.out.printf("startsWith(%s): %b\n", 
                    prefix, trie.startsWith(prefix));
        }
    }

    private static String[] generateRandomStrings(int size, int origin, 
                                                  int bound) {
        String[] res = new String[size];
        Random r = new Random();
        for (int i = 0; i < size; ++i) {
            int length = r.nextInt(origin, bound);
            res[i] = generateRandomString(r, length);
        }
        return res;
    }

    private static String generateRandomString(Random r, int length) {
        int[] indices = r.ints(length, 0, 26).toArray();
        StringBuilder sb = new StringBuilder();
        for (int index : indices) {
            sb.append((char) (index + 'a'));
        }
        return sb.toString();
    }
}
