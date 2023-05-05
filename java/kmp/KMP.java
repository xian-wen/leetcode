import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Knuth–Morris–Pratt Algorithm
 * 
 * Ref: https://en.wikipedia.org/wiki/Knuth-Morris-Pratt_algorithm
 */
public class KMP {
    public List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] lps = longestPrefixSuffix(pattern);
        // i: position of the current character in text.
        // j: position of the current character in pattern.
        int N = text.length(), M = pattern.length(), i = 0, j = 0;
        while (i < N) {
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                if (j == M) {
                    positions.add(i - j);
                    j = lps[j];  // j != -1
                }
            } else {
                j = lps[j];
                if (j < 0) {
                    ++i;
                    ++j;
                }
            }
        }
        return positions;
    }

    private int[] longestPrefixSuffix(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M + 1];
        lps[0] = -1;
        // j: position of the current character in pattern.
        // cnd: position of the next character of the candidate prefix.
        int j = 1, cnd = 0;
        while (j < M) {
            if (pattern.charAt(j) == pattern.charAt(cnd)) {
                lps[j] = lps[cnd];
            } else {
                lps[j] = cnd;
                while (cnd >= 0 && pattern.charAt(j) != pattern.charAt(cnd)) {
                    cnd = lps[cnd];
                }
            }

            ++j;
            ++cnd;
        }

        // j = pattern.length(), used for search all matches.
        lps[M] = cnd;
        return lps;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String pattern = "ABCDABD";
        int[] lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));
        
        pattern = "ABACABABC";
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));

        pattern = "ABACABABA";
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));

        pattern = "PARTICIPATE IN PARACHUTE";
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));

        pattern = "AAAAAAAAB";
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));

        String text = "ABC ABCDAB ABCDABCDABDE";
        pattern = "ABCDABD";
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("text: " + text);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));
        System.out.println("kmp_search: " + kmp.search(text, pattern));

        text = generateRandomString(1000);
        pattern = generateRandomString(2);
        lps = kmp.longestPrefixSuffix(pattern);
        System.out.println("text: " + text);
        System.out.println("pattern: " + pattern);
        System.out.println("kmp_table: " + Arrays.toString(lps));
        System.out.println("kmp_search: " + kmp.search(text, pattern));
    }

    private static String generateRandomString(int length) {
        int[] indices = generateRandomArray(length, 0, 26);
        StringBuilder sb = new StringBuilder();
        for (int index : indices) {
            sb.append((char) (index + 'A'));
        }
        return sb.toString();
    }

    private static int[] generateRandomArray(int size, int origin, int bound) {
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
