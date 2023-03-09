import java.util.Arrays;
import java.util.Random;

public class Sort {
    /**
     * Swap with the minimum.
     */
    public void selectionSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; ++i) {
            int min = i;
            for (int j = i + 1; j < N; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Once found the valid position, stop swapping.
     */
    public void insertionSort(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; ++i) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; --j) {
                swap(arr, j - 1, j);
            }
        }
    }

    /**
     * Swap `arr.length - 1` times.
     */
    public void bubbleSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; ++i) {
            int exchanges = 0;
            for (int j = N - 1; j > i; --j) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    ++exchanges;
                }
            }

            if (exchanges == 0) {
                break;
            }
        }
    }

    /**
     * Divide and conquer.
     */
    public void mergeSort(int[] arr) {
        int N = arr.length;
        int[] aux = new int[N];
        mergeSortHelper(arr, aux, 0, N - 1);
    }

    private void mergeSortHelper(int[] arr, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSortHelper(arr, aux, lo, mid);
        mergeSortHelper(arr, aux, mid + 1, hi);

        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        
        merge(arr, aux, lo, mid, hi);
    }

    public void mergeSortBottomUp(int arr[]) {
        int N = arr.length;
        int[] aux = new int[N];
        for (int len = 1; len < N; len += len) {
            for (int lo = 0; lo < N - len; lo += len + len) {
                // Merge arr[lo..mid] with arr[(mid+1)..hi].
                // len = mid - lo + 1 = hi - mid
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, N - 1);
                merge(arr, aux, lo, mid, hi);
            }
        }
    }

    /**
     * Merge arr[lo..mid] with arr[(mid+1)..hi] using aux[lo..hi].
     */
    private void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; ++i) {
            aux[i] = arr[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; ++k) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }

    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private void quickSortHelper(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);
        quickSortHelper(arr, lo, pivot - 1);
        quickSortHelper(arr, pivot + 1, hi);
    }

    /**
     * Partition arr so that arr[lo..(pivot-1)] <= arr[pivot] <= arr[(pivot+1), hi].
     */
    private int partition(int[] arr, int lo, int hi) {
        Random r = new Random();
        int ri = r.nextInt(hi - lo + 1) + lo;
        swap(arr, ri, hi);
        
        int sentinel = arr[hi], pivot = lo;
        for (int i = lo; i < hi; ++i) {
            if (arr[i] < sentinel) {
                swap(arr, pivot++, i);
            }
        }
        
        swap(arr, pivot, hi);
        return pivot;
    }
    
    /**
     * Partition arr so that arr[lo..(j-1)] <= arr[j] <= arr[(j+1)..hi].
     */
    private int partition2(int[] arr, int lo, int hi) {
        Random r = new Random();
        int ri = r.nextInt(hi - lo + 1) + lo;
        swap(arr, lo, ri);

        int sentinel = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            // Find the first i such that arr[i] > sentinel.
            while (arr[++i] <= sentinel) {
                if (i == hi) {
                    break;
                }
            }

            // Find the first j such that arr[j] < sentinel.
            while (arr[--j] >= sentinel) {
                if (j == lo) {
                    break;
                }
            }

            // Check i, j is valid.
            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        // If i < j before break, i.e., i > j after break, then after swap,
        // arr[j] < sentinel, arr[i] > sentinel, so only j not i can be swapped.
        swap(arr, lo, j);
        return j;
    }

    public void quickSort3Way(int[] arr) {
        quickSort3WayHelper(arr, 0, arr.length - 1);
    }

    /**
     * Sort arr so that arr[lo..(lt-1)] < v = arr[lt..gt] < arr[(gt+1)..hi].
     */
    private void quickSort3WayHelper(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        
        int sentinel = arr[lo];
        int lt = lo, gt = hi, i = lo + 1;
        // When i == gt, it is unknown whether arr[i] < or = or > sentinel.
        while (i <= gt) {
            if (arr[i] < sentinel) {
                swap(arr, lt++, i++);
            } else if (arr[i] > sentinel) {
                swap(arr, i, gt--);
            } else {
                ++i;
            }
        }

        quickSort3WayHelper(arr, lo, lt - 1);
        quickSort3WayHelper(arr, gt + 1, hi);
    }

    public void heapSort(int[] arr) {
        heapify(arr);
        int N = arr.length;
        for (int i = N - 1; i > 0; --i) {
            swap(arr, 0, i);
            // The heap to be sunk is smaller.
            sink(arr, 0, i);
        }
    }

    // Construct a max heap.
    private void heapify(int[] arr) {
        int N = arr.length, parentOfLast = N / 2 - 1;
        for (int i = parentOfLast; i >= 0; --i) {
            sink(arr, i, N);
        }
    }

    private void sink(int[] arr, int k, int N) {
        int left = 2 * k + 1;
        while (left < N) {
            int max = left, right = left + 1;
            if (right < N && arr[right] > arr[left]) {
                max = right;
            }

            if (arr[k] >= arr[max]) {
                break;
            }

            swap(arr, k, max);
            k = max;
            left = 2 * k + 1;
        }
    }

    private void swim(int[] arr, int k) {
        int parent = (k - 1) / 2;
        while (parent >= 0 && arr[parent] < arr[k]) {
            swap(arr, parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    public static void main(String[] args) {
        // int[] aux = generateRandomArray(10, -10, 10);
        int[] aux = generateRandomArray(100_000, -100_000, 100_000);
        System.out.println("Array: " + Arrays.toString(aux) + "\n");

        Sort s = new Sort();
        int[] arr = aux.clone();
        long start = System.currentTimeMillis();
        s.selectionSort(arr);
        boolean isSorted = isSorted(arr);
        long end = System.currentTimeMillis();
        System.out.printf("Selection sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);

        arr = aux.clone();
        start = System.currentTimeMillis();
        s.insertionSort(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Insertion sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
        
        arr = aux.clone();
        start = System.currentTimeMillis();
        s.bubbleSort(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Bubble sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
        
        arr = aux.clone();
        start = System.currentTimeMillis();
        s.mergeSort(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Merge sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);

        arr = aux.clone();
        start = System.currentTimeMillis();
        s.mergeSortBottomUp(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Merge sort bottom up: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
        
        arr = aux.clone();
        start = System.currentTimeMillis();
        s.quickSort(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Quick sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
        
        arr = aux.clone();
        start = System.currentTimeMillis();
        s.quickSort3Way(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Quick sort 3-way: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
        
        arr = aux.clone();
        start = System.currentTimeMillis();
        s.heapSort(arr);
        isSorted = isSorted(arr);
        end = System.currentTimeMillis();
        System.out.printf("Heap sort: %s, sorted: %b, time: %d ms\n\n", 
                Arrays.toString(arr), isSorted, end - start);
    }

    /**
     * Return an integer array of size n and in range [origin, bound).
     */
    private static int[] generateRandomArray(int size, int origin, int bound) {
        // Random r = new Random(12345);
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
