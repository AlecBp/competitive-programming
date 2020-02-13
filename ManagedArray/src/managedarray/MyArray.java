package managedarray;

/**
 * @author Alec
 */
public class MyArray {

    private int maxItems;
    private int numItems;
    private int[] arr;

    public MyArray(int max) {
        this.maxItems = max;
        this.numItems = 0;
        this.arr = new int[this.maxItems];
    }

    public boolean addLast(int data) {
        if (numItems < maxItems) {
            arr[numItems++] = data;
            return true;
        }
        return false;

    }

    public boolean addFront(int data) {
        if (numItems < maxItems) {
            int j = numItems - 1;
            while (j >= 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = data;
            numItems++;
            return true;
        }
        return false;
    }

    public boolean addInOrder(int data) {
        if (numItems < maxItems) {
            int j = numItems - 1;
            while (j >= 0 && data < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = data;
            numItems++;
            return true;
        }
        return false;
    }

    public void printArray() {
        for (int i = 0; i < numItems; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
    }

    public int linearSearch(int key) {
        for (int i = 0; i < numItems; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearchASC(int key) {
        int lo, mid, hi;
        lo = 0;
        hi = numItems - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
    
     public int binarySearchDESC(int key) {
        int lo, mid, hi;
        lo = 0;
        hi = numItems - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public boolean removeInOrder(int key) {
        // Uses binary search and will shift after deletion
        int idx = binarySearchASC(key);
        if (idx != -1) {
            while (idx < numItems - 1) {
                arr[idx] = arr[idx + 1];
                idx++;
            }
            numItems--;
        }
        return false;
    }

    public boolean remove(int key) {
        // Uses linear search and will replace deleted element with last element of array
        int idx = linearSearch(key);
        if (idx != -1) {
            arr[idx] = arr[numItems - 1];
            numItems--;
            return true;
        }
        return false;
    }

    public void selectionSortASC() {
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

    public void selectionSortDESC() {
        int idx;
        int tmp;
        for (int i = 0; i < numItems - 1; i++) {
            idx = i;
            for (int j = i + 1; j < numItems; j++) {
                if (arr[j] > arr[idx]) {
                    idx = j;
                }
            }
            //swap
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
    }

    public void insertionSortASC() {
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

    public void insertionSortDESC() {
        int curr, j;

        for (int i = 1; i < numItems; i++) {
            j = i - 1;
            curr = arr[i];
            while (j >= 0 && curr > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    public void mergeSortASC() {
        mergeSortASC(0, numItems - 1);
    }

    private void mergeSortASC(int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSortASC(lo, mid);
            mergeSortASC(mid + 1, hi);
            mergeSortASC(lo, mid, hi);
        }
    }

    private void mergeSortASC(int lo, int mid, int hi) {
        int sizeL = mid - lo + 1;
        int sizeR = hi - mid;
        int[] left = new int[sizeL];
        int[] right = new int[sizeR];

        for (int i = 0; i < sizeL; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < sizeR; i++) {
            right[i] = arr[mid + i + 1];
        }

        int pointerL, pointerR, out;
        pointerL = pointerR = 0;
        out = lo;

        while (pointerL < sizeL && pointerR < sizeR) {
            if (left[pointerL] <= right[pointerR]) {
                arr[out++] = left[pointerL++];
            } else {
                arr[out++] = right[pointerR++];
            }
        }

        while (pointerL < sizeL) {
            arr[out++] = left[pointerL++];
        }

        while (pointerR < sizeL) {
            arr[out++] = right[pointerR++];
        }
    }
    
    public void mergeSortDESC() {
        mergeSortDESC(0, numItems - 1);
    }

    private void mergeSortDESC(int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSortDESC(lo, mid);
            mergeSortDESC(mid + 1, hi);
            mergeSortDESC(lo, mid, hi);
        }
    }

    private void mergeSortDESC(int lo, int mid, int hi) {
        int sizeL = mid - lo + 1;
        int sizeR = hi - mid;
        int[] left = new int[sizeL];
        int[] right = new int[sizeR];

        for (int i = 0; i < sizeL; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < sizeR; i++) {
            right[i] = arr[mid + i + 1];
        }

        int pointerL, pointerR, out;
        pointerL = pointerR = 0;
        out = lo;

        while (pointerL < sizeL && pointerR < sizeR) {
            if (left[pointerL] >= right[pointerR]) {
                arr[out++] = left[pointerL++];
            } else {
                arr[out++] = right[pointerR++];
            }
        }

        while (pointerL < sizeL) {
            arr[out++] = left[pointerL++];
        }

        while (pointerR < sizeL) {
            arr[out++] = right[pointerR++];
        }
    }
    
    
}
