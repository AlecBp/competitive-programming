package sortsbenchmark;
import java.util.Random;
import java.lang.Math;

/* @author AlecBp */
public class SortsBenchmark {

    public static void main(String[] args) {
        int[] coreData = new int[1000000];
        Random rand = new Random();
        for (int i = 0; i < coreData.length; i++) {
            coreData[i] = rand.nextInt(3000000);
        }
        int[] testSizes = new int[]{50, 1000, 10000, 100000, 1000000};

        for (int i = 0; i < testSizes.length; i++) {
            System.out.println("Benchmarking sorts with " + testSizes[i] + " dataset size");
            benchmarkQuickSort(coreData, testSizes[i]);
            benchmarkMergeSort(coreData, testSizes[i]);
            benchmarkInsertionSort(coreData, testSizes[i]);
            benchmarkSelectionSort(coreData, testSizes[i]);
            System.out.println("____________________________________________");
        }
    }

    public static void benchmarkQuickSort(int[] coreData, int size) {
        int[] temp = copyArray(coreData, size);
        long start = System.nanoTime();
        quickSortASC(temp, 0, size - 1);
        long end = System.nanoTime();
        long delta = end - start;
        printTimes(delta);
    }

    public static void benchmarkMergeSort(int[] coreData, int size) {
        int[] temp = copyArray(coreData, size);
        long start = System.nanoTime();
        mergeSortASC(temp, size);
        long end = System.nanoTime();
        long delta = end - start;
        printTimes(delta);
    }

    public static void benchmarkInsertionSort(int[] coreData, int size) {
        int[] temp = copyArray(coreData, size);
        long start = System.nanoTime();
        insertionSortASC(temp, size);
        long end = System.nanoTime();
        long delta = end - start;
        printTimes(delta);
    }

    public static void benchmarkSelectionSort(int[] coreData, int size) {
        int[] temp = copyArray(coreData, size);
        long start = System.nanoTime();
        selectionSortASC(temp, size);
        long end = System.nanoTime();
        long delta = end - start;
        printTimes(delta);
    }

    public static void printTimes(long nanosecods) {
        System.out.print("Nanoseconds " + nanosecods + "\t\t\t");
        System.out.print("Microseconds " + (nanosecods / 1000.0) + "\t\t\t");
        System.out.print("Milliseconds " + (nanosecods / 1000000.0) + "\t\t\t");
        System.out.println("Seconds " + (nanosecods / 1000000000.0) + "\t\t\t");
    }

    public static int[] copyArray(int[] coreData, int size) {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = coreData[i];
        }
        return temp;
    }

    public static void printData(int[] data, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void selectionSortASC(int[] arr, int numItems) {
        int idx;
        int tmp;
        for (int i = 0; i < numItems - 1; i++) {
            idx = i;
            for (int j = i + 1; j < numItems; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            //swap
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void insertionSortASC(int[] arr, int numItems) {
        int curr, j;

        for (int i = 1; i < numItems; i++) {
            j = i - 1;
            curr = arr[i];
            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    public static void mergeSortASC(int[] arr, int lo, int mid, int hi) {
        int numLHalf = (mid - lo) + 1;
        int numUHalf = hi - mid;
        int[] arr1 = new int[numLHalf];
        int[] arr2 = new int[numUHalf];
        for (int i = 0; i < numLHalf; i++) {
            arr1[i] = arr[lo + i];
        }
        for (int i = 0; i < numUHalf; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int lPointer = 0, uPointer = 0, outPointer = lo;
        while (lPointer < numLHalf && uPointer < numUHalf) {
            if (arr1[lPointer] < arr2[uPointer]) {
                arr[outPointer++] = arr1[lPointer++];
            } else {
                arr[outPointer++] = arr2[uPointer++];
            }
        }
        while (lPointer < numLHalf) {
            arr[outPointer++] = arr1[lPointer++];
        }
        while (uPointer < numUHalf) {
            arr[outPointer++] = arr2[uPointer++];
        }

    }

    public static void mergeSortASC(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSortASC(arr, lo, mid);
            mergeSortASC(arr, mid + 1, hi);
            mergeSortASC(arr, lo, mid, hi);
        }
    }

    public static void mergeSortASC(int[] arr, int numItems) {
        mergeSortASC(arr, 0, numItems - 1);
    }

    public static int partition(int arr[], int lo, int hi) {
        int pivot = arr[hi];
        int i = (lo - 1);
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = temp;
        return i + 1;
    }

    public static void quickSortASC(int arr[], int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);
            quickSortASC(arr, lo, pi - 1);
            quickSortASC(arr, pi + 1, hi);
        }
    }
}
