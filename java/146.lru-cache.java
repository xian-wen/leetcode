import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (40.53%)
 * Likes:    14956
 * Dislikes: 605
 * Total Accepted:    1.2M
 * Total Submissions: 2.9M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design a data structure that follows the constraints of a Least Recently
 * Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size
 * capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys
 * exceeds the capacity from this operation, evict the least recently used
 * key.
 * 
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 * 
 * 
 */

// @lc code=start
class LRUCache {
    // private Map<Integer, DLLNode> map;
    // private DLLNode head;
    // private int capacity;

    // /**
    //  * Solution 1
    //  */
    // private class DLLNode {
    //     private int key, value;
    //     private DLLNode prev, next;

    //     public DLLNode() {
    //     }

    //     public DLLNode(int key, int value) {
    //         this.key = key;
    //         this.value = value;
    //     }

    //     @Override
    //     public String toString() {
    //         return String.format("(%d, %d)", key, value);
    //     }
    // }

    // private void addFirst(DLLNode node) {
    //     node.next = head.next;
    //     node.prev = head;
    //     head.next.prev = node;
    //     head.next = node;
    // }

    // private void remove(DLLNode node) {
    //     DLLNode prev = node.prev;
    //     DLLNode next = node.next;
    //     prev.next = next;
    //     next.prev = prev;
    // }

    // private DLLNode removeLast() {
    //     DLLNode tail = head.prev;
    //     remove(tail);
    //     return tail;
    // }

    // private void moveFirst(DLLNode node) {
    //     remove(node);
    //     addFirst(node);
    // }

    // private String listToString(DLLNode node) {
    //     if (node.next == head) {
    //         return String.format("%s", node);
    //     }
    //     return String.format("%s<->%s", node, listToString(node.next));
    // }

    // public LRUCache(int capacity) {
    //     this.capacity = capacity;
    //     map = new HashMap<>();
    //     head = new DLLNode();
    //     head.next = head;
    //     head.prev = head;
    // }
    
    // public int get(int key) {
    //     DLLNode node = map.get(key);
    //     if (node == null) {
    //         return -1;
    //     }

    //     moveFirst(node);
    //     return node.value;
    // }
    
    // public void put(int key, int value) {
    //     if (map.containsKey(key)) {
    //         DLLNode node = map.get(key);
    //         node.value = value;
    //         moveFirst(node);
    //         return;
    //     }

    //     if (map.size() == capacity) {
    //         DLLNode removed = removeLast();
    //         map.remove(removed.key);
    //     }

    //     DLLNode node = new DLLNode(key, value);
    //     addFirst(node);
    //     map.put(key, node);
    // }

    private Map<Integer, Integer> map;

    /**
     * Solution 2: Built-in
     */
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

