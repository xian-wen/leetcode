import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    // private Deque<NestedInteger> stack;

    // /**
    //  * Solution 1: Stack
    //  */
    // public NestedIterator(List<NestedInteger> nestedList) {
    //     stack = new ArrayDeque<>();
    //     flatten(nestedList);
    // }

    // @Override
    // public Integer next() {
    //     return stack.pop().getInteger();
    // }

    // @Override
    // public boolean hasNext() {
    //     while (!stack.isEmpty()) {
    //         if (stack.peek().isInteger()) {
    //             return true;
    //         }

    //         flatten(stack.pop().getList());
    //     }
    //     return false;
    // }

    // private void flatten(List<NestedInteger> nestedList) {
    //     int N = nestedList.size();
    //     for (int i = N - 1; i >= 0; --i) {
    //         stack.push(nestedList.get(i));
    //     }
    // }

    // private Deque<ListIterator<NestedInteger>> stack;

    // /**
    //  * Solution 2: Stack + ListIterator
    //  */
    // public NestedIterator(List<NestedInteger> nestedList) {
    //     stack = new ArrayDeque<>();
    //     stack.push(nestedList.listIterator());
    // }

    // @Override
    // public Integer next() {
    //     return stack.peek().next().getInteger();
    // }

    // @Override
    // public boolean hasNext() {
    //     while (!stack.isEmpty()) {
    //         if (!stack.peek().hasNext()) {
    //             stack.pop();
    //         } else {
    //             NestedInteger nestedInteger = stack.peek().next();
    //             if (nestedInteger.isInteger()) {
    //                 // Move backwards after calling stack.peek().next().
    //                 stack.peek().previous();
    //                 return true;
    //             }

    //             stack.push(nestedInteger.getList().listIterator());
    //         }

    //     }
    //     return false;
    // }

    private Iterator<Integer> iterator;

    /**
     * Solution 3: DFS
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        flatten(nestedList, list);
        iterator = list.iterator();
    }

    private void flatten(List<NestedInteger> nestedList, List<Integer> res) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                flatten(nestedInteger.getList(), res);
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

