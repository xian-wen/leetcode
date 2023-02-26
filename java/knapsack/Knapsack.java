import java.util.Arrays;

public class Knapsack {
    /**
     * Subproblem:
     * knapsack[i][b] = the max value attainable from a subset of object
     * 0, 1, ..., (i-1) with a total value <= b.
     * 
     * Recursive relation:
     * knapsack[i][b] = max{knapsack[i-1][b], v[i-1] + knapsack[i-1][b - w[i-1]]} if w[i-1] <= b
     *                = knapsack[i-1][b]                                          otherwise
     * knapsack[i][0] = 0
     * knapsack[0][b] = 0
     * 
     * Time complexity:
     * O(NB)
     */
    public int knapsackNoRepetition(int[] values, int[] weights, int B) {
        int N = values.length;
        int[][] knapsack = new int[N + 1][B + 1];
        for (int i = 1; i <= N; ++i) {
            int v = values[i - 1], w = weights[i - 1];
            for (int b = 1; b <= B; ++b) {
                if (w <= b) {
                    knapsack[i][b] = Math.max(knapsack[i - 1][b], 
                                              v + knapsack[i - 1][b - w]);
                } else {
                    knapsack[i][b] = knapsack[i - 1][b];
                }
            }
        }
        
        System.out.println("knapsack: " + Arrays.deepToString(knapsack));
        return knapsack[N][B];
    }
    
    /**
     * Subproblem:
     * knapsack[b] = the max value attainable from a subset of object 
     * 0, 1, ..., (N-1) with a total value <= b.
     * 
     * Recursive relation:
     * knapsack[b] = max{v[i] + knapsack[b - w[i]]} where w[i] <= b
     * knapsack[0] = 0
     * 
     * Time complexity:
     * O(NB)
     */
    public int knapsackNoRepetitionSpaceOptimization(int[] values, 
                                                     int[] weights, 
                                                     int B) {
        int N = values.length;
        int[] knapsack = new int[B + 1];
        for (int i = 0; i < N; ++i) {
            int v = values[i], w = weights[i];
            // Iterate from right to left since we need to get values from items
            // in the previous row.
            for (int b = B; b >= w; --b) {
                knapsack[b] = Math.max(knapsack[b], v + knapsack[b - w]);
            }
        }

        System.out.println("knapsack: " + Arrays.toString(knapsack));
        return knapsack[B];
    }
    
    /**
     * Subproblem:
     * knapsack[i][b] = the max value attainable from a multiset of object
     * 0, 1, ..., (i-1) with a total value <= b.
     * 
     * Recursive relation:
     * knapsack[i][b] = max{knapsack[i-1][b], v[i-1] + knapsack[i][b - w[i-1]]} if w[i-1] <= b
     *                = knapsack[i-1][b]                                        otherwise
     * knapsack[i][0] = 0
     * knapsack[0][b] = 0
     * 
     * Time complexity:
     * O(NB)
     */
    public int knapsackRepetition(int[] values, int[] weights, int B) {
        int N = values.length;
        int[][] knapsack = new int[N + 1][B + 1];
        for (int i = 1; i <= N; ++i) {
            int v = values[i - 1], w = weights[i - 1];

            for (int b = 1; b <= B; ++b) {
                if (w <= b) {
                    knapsack[i][b] = Math.max(knapsack[i - 1][b], 
                                              v + knapsack[i][b - w]);
                } else {
                    knapsack[i][b] = knapsack[i - 1][b];
                }
            }
        }
        
        System.out.println("knapsack: " + Arrays.deepToString(knapsack));
        return knapsack[N][B];
    }
    
    /**
     * Subproblem:
     * knapsack[b] = the max value attainable from a multiset of object 
     * 0, 1, ..., (N-1) with a total value <= b.
     * 
     * Recursive relation:
     * knapsack[b] = max{v[i] + knapsack[b - w[i]]} where w[i] <= b
     * knapsack[0] = 0
     * 
     * Time complexity:
     * O(NB)
     */
    public int knapsackRepetitionSpaceOptimization(int[] values, 
                                                   int[] weights, 
                                                   int B) {
        int N = values.length;
        int[] knapsack = new int[B + 1];
        for (int i = 0; i < N; ++i) {
            int v = values[i], w = weights[i];
            // Iterate from left to right since we need to get values from items
            // in the current row.
            for (int b = w; b <= B; ++b) {
                knapsack[b] = Math.max(knapsack[b], v + knapsack[b - w]);
            }
        }

        System.out.println("knapsack: " + Arrays.toString(knapsack));
        return knapsack[B];
    }

    public static void main(String[] args) {
        int[] values = new int[] {12, 10, 8, 5};
        int[] weights = new int[] {15, 12, 10, 5};
        int B = 22;
        Knapsack knapsack = new Knapsack();
        System.out.println("KnapsackNoRepetition: " 
                + knapsack.knapsackNoRepetition(values, weights, B));
        System.out.println("knapsackNoRepetitionSpaceOptimization: " 
                + knapsack.knapsackNoRepetitionSpaceOptimization(values, weights, B));
        System.out.println("KnapsackRepetition: " 
                + knapsack.knapsackRepetition(values, weights, B));
        System.out.println("knapsackRepetitionSpaceOptimization: " 
                + knapsack.knapsackRepetitionSpaceOptimization(values, weights, B));
    }
}
