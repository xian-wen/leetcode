import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (42.89%)
 * Likes:    4923
 * Dislikes: 305
 * Total Accepted:    214.3K
 * Total Submissions: 498.4K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for a Least Frequently Used (LFU)
 * cache.
 * 
 * Implement the LFUCache class:
 * 
 * 
 * LFUCache(int capacity) Initializes the object with the capacity of the data
 * structure.
 * int get(int key) Gets the value of the key if the key exists in the cache.
 * Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or
 * inserts the key if not already present. When the cache reaches its capacity,
 * it should invalidate and remove the least frequently used key before
 * inserting a new item. For this problem, when there is a tie (i.e., two or
 * more keys with the same frequency), the least recently used key would be
 * invalidated.
 * 
 * 
 * To determine the least frequently used key, a use counter is maintained for
 * each key in the cache. The key with the smallest use counter is the least
 * frequently used key.
 * 
 * When a key is first inserted into the cache, its use counter is set to 1
 * (due to the put operation). The use counter for a key in the cache is
 * incremented either a get or put operation is called on it.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
 * "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * 
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element
 * is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 * ⁠                // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest,
 * invalidate 2.
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * ⁠                // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate
 * 1.
 * ⁠                // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * ⁠                // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 * ⁠                // cache=[4,3], cnt(4)=2, cnt(3)=3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= capacity <= 10^4
 * 0 <= key <= 10^5
 * 0 <= value <= 10^9
 * At most 2 * 10^5 calls will be made to get and put.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class LFUCache {
    // private Map<Integer, DLLNode> nodeMap;
    // private Map<Integer, DLinkedList> freqMap;
    // private int minFreq;
    // private int capacity;

    // private class DLLNode {
    //     private int key, value;
    //     private int freq;
    //     private DLLNode prev, next;

    //     public DLLNode() {
    //     }

    //     public DLLNode(int key, int value) {
    //         this.key = key;
    //         this.value = value;
    //         this.freq = 1;
    //     }

    //     @Override
    //     public String toString() {
    //         return String.format("(%d, %d, %d)", key, value, freq);
    //     }
    // }
    
    // private class DLinkedList {
    //     private DLLNode head;

    //     public DLinkedList() {
    //         head = new DLLNode();
    //         head.next = head;
    //         head.prev = head;
    //     }

    //     public boolean isEmpty() {
    //         return head.next == head;
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

    // private void moveNewFirst(DLLNode node) {
    //     DLinkedList list = freqMap.get(node.freq);
    //     list.remove(node);
    //     if (list.isEmpty() && minFreq == node.freq) {
    //         minFreq = node.freq + 1;
    //     }
        
    //     ++node.freq;
    //     freqMap.putIfAbsent(node.freq, new DLinkedList());
    //     list = freqMap.get(node.freq);
    //     list.addFirst(node);
    // }

    // /**
    //  * Solution 1
    //  */
    // public LFUCache(int capacity) {
    //     this.capacity = capacity;
    //     nodeMap = new HashMap<>();
    //     freqMap = new HashMap<>();
    //     freqMap.put(1, new DLinkedList());
    // }
    
    // public int get(int key) {
    //     DLLNode node = nodeMap.get(key);
    //     if (node == null) {
    //         return -1;
    //     }

    //     moveNewFirst(node);
    //     return node.value;
    // }
    
    // public void put(int key, int value) {
    //     if (nodeMap.containsKey(key)) {
    //         DLLNode node = nodeMap.get(key);
    //         node.value = value;
    //         moveNewFirst(node);
    //         return;
    //     }

    //     if (nodeMap.size() == capacity) {
    //         DLinkedList list = freqMap.get(minFreq);
    //         DLLNode removed = list.removeLast();
    //         nodeMap.remove(removed.key);
    //     }

    //     DLLNode node = new DLLNode(key, value);
    //     nodeMap.put(key, node);
    //     DLinkedList list = freqMap.get(1);
    //     list.addFirst(node);
    //     minFreq = 1;
    // }

    private Map<Integer, Integer> map;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Set<Integer>> freqSetMap;
    private int capacity;
    private int minFreq;

    /**
     * Solution 2: Built-in
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqSetMap = new HashMap<>();
        freqSetMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        move(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            move(key);
            return;
        }

        if (map.size() == capacity) {
            Set<Integer> set = freqSetMap.get(minFreq);
            int removed = set.iterator().next();
            map.remove(removed);
            freqMap.remove(removed);
            set.remove(removed);
        }

        map.put(key, value);
        freqMap.put(key, 1);
        freqSetMap.get(1).add(key);
        minFreq = 1;
    }

    private void move(int key) {
        int freq = freqMap.get(key);
        Set<Integer> set = freqSetMap.get(freq);
        set.remove(key);
        if (set.isEmpty() && minFreq == freq) {
            minFreq = freq + 1;
        }

        ++freq;
        freqMap.put(key, freq);
        freqSetMap.putIfAbsent(freq, new LinkedHashSet<>());
        freqSetMap.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

