import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
    // private DLinkedList list;
    // private int capacity;

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

    // private class DLinkedList {
    //     private DLLNode head;

    //     public DLinkedList() {
    //         head = new DLLNode();
    //         head.next = head;
    //         head.prev = head;
    //     }

    //     public void addFirst(DLLNode node) {
    //         node.next = head.next;
    //         node.prev = head;
    //         head.next.prev = node;
    //         head.next = node;
    //     }
    
    //     public void remove(DLLNode node) {
    //         DLLNode prev = node.prev;
    //         DLLNode next = node.next;
    //         prev.next = next;
    //         next.prev = prev;
    //     }
    
    //     public DLLNode removeLast() {
    //         DLLNode tail = head.prev;
    //         remove(tail);
    //         return tail;
    //     }
    
    //     public void moveFirst(DLLNode node) {
    //         remove(node);
    //         addFirst(node);
    //     }

    //     @Override
    //     public String toString() {
    //         return toString(head);
    //     }
    
    //     private String toString(DLLNode node) {
    //         if (node.next == head) {
    //             return String.format("%s", node);
    //         }
    //         return String.format("%s<->%s", node, toString(node.next));
    //     }
    // }

    // /**
    //  * Solution 1
    //  */
    // public LRUCache(int capacity) {
    //     this.capacity = capacity;
    //     map = new HashMap<>();
    //     list = new DLinkedList();
    // }
    
    // public int get(int key) {
    //     DLLNode node = map.get(key);
    //     if (node == null) {
    //         return -1;
    //     }

    //     list.moveFirst(node);
    //     return node.value;
    // }
    
    // public void put(int key, int value) {
    //     if (map.containsKey(key)) {
    //         DLLNode node = map.get(key);
    //         node.value = value;
    //         list.moveFirst(node);
    //         return;
    //     }

    //     if (map.size() == capacity) {
    //         DLLNode removed = list.removeLast();
    //         map.remove(removed.key);
    //     }

    //     DLLNode node = new DLLNode(key, value);
    //     list.addFirst(node);
    //     map.put(key, node);
    // }

    // private Map<Integer, Integer> map;
    // // LinkedHashSet: doubly linked list, remove: O(1)
    // // LinkedList: doubly linked list, remove: O(N)
    // private Set<Integer> set;
    // private int capacity;

    // /**
    //  * Solution 2: Linked Hash Set
    //  */
    // public LRUCache(int capacity) {
    //     this.capacity = capacity;
    //     map = new HashMap<>();
    //     set = new LinkedHashSet<>();
    // }
    
    // public int get(int key) {
    //     if (!map.containsKey(key)) {
    //         return -1;
    //     }

    //     moveLast(set, key);
    //     return map.get(key);
    // }

    // private void moveLast(Set<Integer> set, int num) {
    //     set.remove(num);
    //     set.add(num);
    // }
    
    // public void put(int key, int value) {
    //     if (map.containsKey(key)) {
    //         map.put(key, value);
    //         moveLast(set, key);
    //         return;
    //     }

    //     if (map.size() == capacity) {
    //         int first = set.iterator().next();
    //         map.remove(first);
    //         set.remove(first);
    //     }

    //     map.put(key, value);
    //     set.add(key);
    // }

    private Map<Integer, Integer> map;

    /**
     * Solution 3: Linked Hash Map
     */
    public LRUCache(int capacity) {
        // Ref: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
        // LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
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

