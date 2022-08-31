/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (56.59%)
 * Likes:    8004
 * Dislikes: 100
 * Total Accepted:    658.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and
 * startsWith.
 * 
 * 
 */

// @lc code=start
class Trie {
    private static final int R = 26;
    private Node root; 

    private class Node {
        Node[] next = new Node[R];
        boolean isWord;
    }

    public Trie() {
        
    }
    
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node node, String word, int d) {
        if (node == null) {
            node = new Node();
        }

        if (d == word.length()) {
            node.isWord = true;
        } else {
            char c = word.charAt(d);
            node.next[c - 'a'] = insert(node.next[c - 'a'], word, d + 1);
        }
        return node;
    }
    
    public boolean search(String word) {
        Node node = search(root, word, 0);
        return node == null ? false : node.isWord;
    }

    private Node search(Node node, String word, int d) {
        if (node == null) {
            return null;
        }

        if (d == word.length()) {
            return node;
        }

        char c = word.charAt(d);
        return search(node.next[c - 'a'], word, d + 1);
    }
    
    public boolean startsWith(String prefix) {
        Node node = search(root, prefix, 0);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

