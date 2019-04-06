import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (44.79%)
 * Total Accepted:    238.4K
 * Total Submissions: 528.2K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */

/* 
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(); // result list
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>(); // current list
            for (int j = 0; j <= i; j++) { // length of each list is i + 1
                if (j == 0 || j == i) { // each first and end in list are 1
                    cur.add(1);
                } else { // list j gets from list j - 1
                    cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(cur); // add cur into res
        }

        return res;
    }
}
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(); // result list
        List<Integer> cur = new ArrayList<>(); // current list
        
        for (int i = 0; i < numRows; i++) {
            cur.add(0, 1); // each list add 1 at 0
            for (int j = 1; j < cur.size() - 1; j++) { // modify [1..(cur.size()-2)]
                cur.set(j, cur.get(j) + cur.get(j + 1));
            }
            res.add(new ArrayList<>(cur)); // add a copy of cur
        }

        return res;
    }
}
