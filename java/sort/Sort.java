import java.util.Arrays;
import java.util.Random;

public class Sort {
    public void selectionSort(int[] arr) {
        // Swap with the minium.
        for (int i = 0; i < arr.length; ++i) {
            int min = i;
            for (int j = i + 1; j < arr.length; ++j) {
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

    public void insertionSort(int[] arr) {
        // Once found valid, stop swap.
        for (int i = 1; i < arr.length; ++i) {
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; --j) {
                swap(arr, j - 1, j);
            }
        }
    }

    public void bubbleSort(int[] arr) {
        // Swap `arr.length - 1` times.
        for (int i = arr.length - 1; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSortHelper(arr, lo, mid);
        mergeSortHelper(arr, mid + 1, hi);

        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        
        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] copy = arr.clone();
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (copy[i] < copy[j]) {
                arr[k++] = copy[i++];
            } else {
                arr[k++] = copy[j++];
            }
        }
        
        while (i <= mid) {
            arr[k++] = copy[i++];
        }
        
        while (j <= hi) {
            arr[k++] = copy[j++];
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

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) {
                --hi;
            }

            arr[lo] = arr[hi];

            while (lo < hi && arr[lo] <= pivot) {
                ++lo;
            }

            arr[hi] = arr[lo];
        }

        arr[lo] = pivot;
        return lo;
    }

    public void heapSort(int[] arr) {
        heapify(arr);
        int N = arr.length;
        for (int i = N - 1; i >= 1; --i) {
            swap(arr, 0, i);
            // The heap to be sunk is smaller.
            sink(arr, 0, --N);
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
        int[] arr = randomGenerator(10000, -10000, 10000);
        System.out.println("Array: " + Arrays.toString(arr));

        Sort s = new Sort();
        int[] copy = arr.clone();
        long start = System.currentTimeMillis();
        s.selectionSort(copy);
        long end = System.currentTimeMillis();
        System.out.printf("Selection sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);

        copy = arr.clone();
        start = System.currentTimeMillis();
        s.insertionSort(copy);
        end = System.currentTimeMillis();
        System.out.printf("Insertion sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);
        
        copy = arr.clone();
        start = System.currentTimeMillis();
        s.bubbleSort(copy);
        end = System.currentTimeMillis();
        System.out.printf("Bubble sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);
        
        copy = arr.clone();
        start = System.currentTimeMillis();
        s.mergeSort(copy);
        end = System.currentTimeMillis();
        System.out.printf("Merge sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);
        
        copy = arr.clone();
        start = System.currentTimeMillis();
        s.quickSort(copy);
        end = System.currentTimeMillis();
        System.out.printf("Quick sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);
        
        copy = arr.clone();
        start = System.currentTimeMillis();
        s.heapSort(copy);
        end = System.currentTimeMillis();
        System.out.printf("Heap sort: %s, time: %d ms\n", 
                Arrays.toString(copy), end - start);
    }

    /**
     * Return an integer array of size n and in range [origin, bound).
     */
    private static int[] randomGenerator(int size, int origin, int bound) {
        // Random r = new Random(12345);
        Random r = new Random();
        return r.ints(size, origin, bound).toArray();
    }
}
