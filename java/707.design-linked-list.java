/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {
    private ListNode head;
    private int size;

    private class ListNode {
        private int val;
        private ListNode prev, next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new ListNode();
        head.prev = head;
        head.next = head;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        ListNode node = get(head, index);
        return node.val;
    }

    private ListNode get(ListNode node, int index) {
        if (index < 0) {
            return node;
        }
        return get(node.next, index - 1);
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        addNode(node, head);
    }

    private void addNode(ListNode node, ListNode prev) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
        ++size;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        addNode(node, head.prev);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode next = get(head, index);
        ListNode node = new ListNode(val);
        addNode(node, next.prev);
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode node = get(head, index);
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        --size;
    }

    private String toString(ListNode node) {
        if (node.next == head) {
            return String.valueOf(node.val);
        }
        return String.format("%d->%s", node.val, toString(node.next));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

