import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SegmentTree {
    private int[] seg;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        seg = new int[4 * n];
        build(nums, 0, n - 1, 0);
    }
    
    private void build(int[] nums, int lo, int hi, int i) {
        if (lo == hi) {
            seg[i] = nums[lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;
        build(nums, lo, mid, 2 * i + 1);
        build(nums, mid + 1, hi, 2 * i + 2);

        // The aggregation function can not only be SUM, but also MAX, MIN, etc.
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public int query(int qLo, int qHi) {
        if (qLo < 0 || qHi >= n || qLo > qHi) {
            throw new IllegalArgumentException("Invalid index");
        }
        return query(qLo, qHi, 0, n - 1, 0);
    }

    private int query(int qLo, int qHi, int lo, int hi, int i) {
        if (qLo <= lo && qHi >= hi) {
            return seg[i];
        }

        if (qLo > hi || qHi < lo) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;
        int leftSum = query(qLo, qHi, lo, mid, 2 * i + 1);
        int rightSum = query(qLo, qHi, mid + 1, hi, 2 * i + 2);
        return leftSum + rightSum;
    }

    public void update(int idx, int val) {
        if (idx < 0 || idx >= n) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        update(idx, val, 0, n - 1, 0);
    }

    private void update(int idx, int val, int lo, int hi, int i) {
        if (lo == hi) {
            seg[i] = val;
            return;
        }

        int mid = lo + (hi - lo) / 2;
        if (idx <= mid) {
            update(idx, val, lo, mid, 2 * i + 1);
        } else {
            update(idx, val, mid + 1, hi, 2 * i + 2);
        }

        // Update root value.
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public static void main(String[] main) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the size of the array: ");
        int size = sc.nextInt();
        sc.close();
        
        int[] nums = generateRandomArray(size, -size, size);
        System.out.println("nums: " + Arrays.toString(nums));
        SegmentTree st = new SegmentTree(nums);
        
        int qLo = size / 3, qHi = 2 * size / 3;
        System.out.printf("query(%d, %d): %d\n", qLo, qHi, st.query(qLo, qHi));
        
        int idx = size / 2, val = size / 2;
        System.out.printf("update(%d, %d)\n", idx, val);
        nums[idx] = val;
        st.update(idx, val);
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.printf("query(%d, %d): %d\n", qLo, qHi, st.query(qLo, qHi));
    }

    private static int[] generateRandomArray(int size, int origin, int bound) {
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
