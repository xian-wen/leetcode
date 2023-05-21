import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1452 lang=java
 *
 * [1452] People Whose List of Favorite Companies Is Not a Subset of Another List
 */

// @lc code=start
class Solution {
    // /**
    //  * Solution 1: Set Intersection
    //  */
    // public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    //     List<Integer> res = new ArrayList<>();
    //     int N = favoriteCompanies.size();
    //     for (int i = 0; i < N; ++i) {
    //         Set<String> seti = new HashSet<>(favoriteCompanies.get(i));
    //         boolean found = false;
    //         for (int j = 0; j < N; ++j) {
    //             if (j == i) {
    //                 continue;
    //             }

    //             Set<String> setj = new HashSet<>(favoriteCompanies.get(j));
    //             setj.retainAll(seti);
    //             if (setj.equals(seti)) {
    //                 found = true;
    //                 break;
    //             }
    //         }

    //         if (!found) {
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }

    // /**
    //  * Solution 2: Union-Find
    //  */
    // public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    //     List<Set<String>> companies = new ArrayList<>();
    //     for (List<String> company : favoriteCompanies) {
    //         companies.add(new HashSet<>(company));
    //     }

    //     int N = favoriteCompanies.size();
    //     int[] parent = new int[N];
    //     initUF(parent);

    //     for (int i = 0; i < N; ++i) {
    //         for (int j = i + 1; j < N; ++j) {
    //             if (find(parent, i) == find(parent, j)) {
    //                 continue;
    //             }

    //             union(parent, i, j, companies);
    //         }
    //     }

    //     // Get indices of the roots.
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < N; ++i) {
    //         if (parent[i] == i) {
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }

    // private void initUF(int[] parent) {
    //     int N = parent.length;
    //     for (int i = 0; i < N; ++i) {
    //         parent[i] = i;
    //     }
    // }

    // private int find(int[] parent, int p) {
    //     if (parent[p] != p) {
    //         parent[p] = find(parent, parent[p]);
    //     }
    //     return parent[p];
    // }

    // private void union(int[] parent, int p, int q, List<Set<String>> companies) {
    //     int rootP = find(parent, p);
    //     int rootQ = find(parent, q);
    //     if (rootP == rootQ) {
    //         return;
    //     }

    //     Set<String> setP = companies.get(rootP);
    //     Set<String> setQ = companies.get(rootQ);
    //     if (setP.containsAll(setQ)) {
    //         parent[rootQ] = rootP;
    //     } else if (setQ.containsAll(setP)) {
    //         parent[rootP] = rootQ;
    //     }
    // }

    /**
     * Solution 3: BitSet
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // company -> indices of people
        Map<String, BitSet> map = new HashMap<>();
        int N = favoriteCompanies.size();
        for (int i = 0; i < N; ++i) {
            for (String company : favoriteCompanies.get(i)) {
                map.putIfAbsent(company, new BitSet(N));
                map.get(company).set(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            // People with the same favorites companies,
            // initially set all bits to true.
            BitSet bs = new BitSet(N);
            bs.set(0, N);

            
            for (String company : favoriteCompanies.get(i)) {
                bs.and(map.get(company));
            }

            if (bs.cardinality() == 1) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

