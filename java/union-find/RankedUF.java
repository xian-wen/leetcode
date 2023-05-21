import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RankedUF {
    private int[] parent;
    private int[] rank;
    private int count;

    public RankedUF(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int count() {
        return count;
    }

    /**
     * find with path compression.
     */
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                ++rank[rootP];
            }
        }

        --count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of pairs: ");
        int size = sc.nextInt();
        sc.close();
        
        int[][] pairs = generateRandomPairs(size, 0, size);
        RankedUF uf = new RankedUF(size);
        for (int[] pair : pairs) {
            if (uf.find(pair[0]) == uf.find(pair[1])) {
                continue;
            }

            uf.union(pair[0], pair[1]);
            System.out.println(pair[0] + " " + pair[1]);
        }

        System.out.println("parent: " + Arrays.toString(uf.parent));
        System.out.println("rank: " + Arrays.toString(uf.rank));
        System.out.println(uf.count + " components.");
    }

    private static int[][] generateRandomPairs(int size, int origin, int bound) {
        Random r = new Random(12345);
        int[][] pairs = new int[size][2];
        for (int i = 0; i < size; ++i) {
            pairs[i] = r.ints(2, origin, bound).toArray();
        }
        return pairs;
    }
}
