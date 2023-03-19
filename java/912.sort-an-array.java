import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (58.48%)
 * Likes:    4633
 * Dislikes: 676
 * Total Accepted:    440K
 * Total Submissions: 737.6K
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order and
 * return it.
 * 
 * You must solve the problem without using any built-in functions in
 * O(nlog(n)) time complexity and with the smallest space complexity
 * possible.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not
 * changed (for example, 2 and 3), while the positions of other numbers are
 * changed (for example, 1 and 5).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Built-in
    //  */
    // public int[] sortArray(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums;
    // }

    // /**
    //  * Solution 2: Priority Queue
    //  */
    // public int[] sortArray(int[] nums) {
    //     Queue<Integer> queue = new PriorityQueue<>();
    //     for (int num : nums) {
    //         queue.offer(num);
    //     }

    //     int i = 0;
    //     while (!queue.isEmpty()) {
    //         nums[i++] = queue.poll();
    //     }
    //     return nums;
    // }

    // /**
    //  * Solution 3: Merge Sort
    //  */
    // public int[] sortArray(int[] nums) {
    //     int N = nums.length;
    //     int[] aux = new int[N];
    //     mergeSort(nums, aux, 0, N - 1);
    //     return nums;
    // }

    // private void mergeSort(int[] nums, int[] aux, int lo, int hi) {
    //     if (lo >= hi) {
    //         return;
    //     }

    //     int mid = lo + (hi - lo) / 2;
    //     mergeSort(nums, aux, lo, mid);
    //     mergeSort(nums, aux, mid + 1, hi);

    //     if (nums[mid] <= nums[mid + 1]) {
    //         return;
    //     }

    //     merge(nums, aux, lo, mid, hi);
    // }

    // private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
    //     System.arraycopy(nums, lo, aux, lo, hi - lo + 1);

    //     int i = lo, j = mid + 1;
    //     for (int k = lo; k <= hi; ++k) {
    //         if (i == mid + 1) {
    //             nums[k] = aux[j++];
    //         } else if (j == hi + 1) {
    //             nums[k] = aux[i++];
    //         } else if (aux[i] < aux[j]) {
    //             nums[k] = aux[i++];
    //         } else {
    //             nums[k] = aux[j++];
    //         }
    //     }
    // }

    // private final Random r = new Random();

    // /**
    //  * Solution 4: Quick Sort
    //  */
    // public int[] sortArray(int[] nums) {
    //     quickSort(nums, 0, nums.length - 1);
    //     return nums;
    // }

    // private void quickSort(int[] nums, int lo, int hi) {
    //     if (lo >= hi) {
    //         return;
    //     }

    //     int pivot = partition(nums, lo, hi);
    //     quickSort(nums, lo, pivot - 1);
    //     quickSort(nums, pivot + 1, hi);
    // }

    // private int partition(int[] nums, int lo, int hi) {
    //     int ri = r.nextInt(hi - lo + 1) + lo;
    //     swap(nums, lo, ri);

    //     int sentinel = nums[lo];
    //     int i = lo, j = hi + 1;
    //     while (true) {
    //         while (nums[++i] < sentinel) {
    //             if (i == hi) {
    //                 break;
    //             }
    //         }

    //         while (nums[--j] > sentinel) {
    //             if (j == lo) {
    //                 break;
    //             }
    //         }

    //         if (i >= j) {
    //             break;
    //         }

    //         swap(nums, i, j);
    //     }

    //     swap(nums, lo, j);
    //     return j;
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    // /**
    //  * Solution 5: Heap Sort
    //  */
    // public int[] sortArray(int[] nums) {
    //     heapify(nums);
    //     int N = nums.length;
    //     for (int i = N - 1; i > 0; --i) {
    //         swap(nums, 0, i);
    //         sink(nums, 0, i);
    //     }
    //     return nums;
    // }

    // private void heapify(int[] nums) {
    //     int N = nums.length, parentOfLast = N / 2 - 1;
    //     for (int i = parentOfLast; i >= 0; --i) {
    //         sink(nums, i, N);
    //     }
    // }

    // private void sink(int[] nums, int k, int N) {
    //     int left = 2 * k + 1;
    //     while (left < N) {
    //         int j = left, right = left + 1;
    //         if (right < N && nums[right] > nums[left]) {
    //             j = right;
    //         }

    //         if (nums[k] >= nums[j]) {
    //             break;
    //         }

    //         swap(nums, k, j);
    //         k = j;
    //         left = 2 * k + 1;
    //     }
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }

    /**
     * Solution 6: Counting Sort
     */
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return nums;
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            ++count[num - min];
        }

        int N = nums.length, i = 0;
        int[] res = new int[N];
        for (int num = min; num <= max; ++num) {
            while (count[num - min] > 0) {
                res[i++] = num;
                --count[num - min];
            }
        }
        return res;
    }
}
// @lc code=end

