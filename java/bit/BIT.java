import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Binary Indexed Tree (Fenwick Tree)
 * Ref: https://en.wikipedia.org/wiki/Fenwick_tree
 */
public class BIT {
    private int[] bit;

    public BIT(int[] nums) {
        int N = nums.length;
        bit = new int[N + 1];
        buildDP(nums);
    }

    /**
     * Solution 1: N Point Updates
     * 
     * Time complexity:
     * O(NlogN)
     */
    private void buildNaive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; ++i) {
            update(i, nums[i]);
        }
    }

    /**
     * Solution 2: Dynamic Programming
     * 
     * Time complexity:
     * O(N)
     */
    private void buildDP(int[] nums) {
        int N = nums.length;
        System.arraycopy(nums, 0, bit, 1, N);
        for (int i = 1; i <= N; ++i) {
            // Get the index of the next node with a different parent.
            int j = i + lastSetBit(i);
            if (j <= N) {
                bit[j] += bit[i];
            }
        }
    }

    private int lastSetBit(int index) {
        return index & (-index);
    }
    
    public int query(int lo, int hi) {
        return prefixSum(hi) - prefixSum(lo - 1);
    }

    private int prefixSum(int index) {
        int sum = 0;
        // Convert index to 1-based.
        ++index;
        while (index > 0) {
            sum += bit[index];
            // Move to the parent node.
            index -= lastSetBit(index);
        }
        return sum;
    }

    public void update(int index, int value) {
        int N = bit.length, delta = value - query(index, index);
        // Convert index to 1-based.
        ++index;
        while (index < N) {
            bit[index] += delta;
            // Move to the next node with a different parent.
            index += lastSetBit(index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the size of the array: ");
        int size = sc.nextInt();
        sc.close();
        
        int[] nums = generateRandomArray(size, -size, size);
        System.out.println("nums: " + Arrays.toString(nums));
        BIT bit = new BIT(nums);
        
        int qLo = size / 3, qHi = 2 * size / 3;
        System.out.printf("query(%d, %d): %d\n", qLo, qHi, bit.query(qLo, qHi));
        
        int idx = size / 2, val = size / 2;
        System.out.printf("update(%d, %d)\n", idx, val);
        nums[idx] = val;
        bit.update(idx, val);
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.printf("query(%d, %d): %d\n", qLo, qHi, bit.query(qLo, qHi));
    }

    private static int[] generateRandomArray(int size, int origin, int bound) {
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
