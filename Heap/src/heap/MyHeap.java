package heap;

/* @author AlecBp */
public class MyHeap {

    private int[] arr;
    private int max;

    public MyHeap(int max) {
        this.max = max;
        arr = new int[max + 1];
        arr[0] = 1;
    }

    // Left here for reference
    private void siftup(int pos) {
        int p1 = pos / 2;
        int temp = arr[pos];
        while (pos != 0 && arr[p1] > temp) {
            arr[pos] = arr[p1];
            pos = p1;
            p1 = pos / 2;
        }
        arr[pos] = temp;
    }

    public void insert(int data) {
        int p1, p2;
        p1 = arr[0]++;
        arr[p1] = data;
        // sift up
        p2 = (p1 / 2);
        System.out.println("p1 " + p1 + " p2 " + p2);
        while (p2 >= 1 && arr[p2] > data) {
            swap(p1, p2);
            p1 = p2;
            p2 = (p2 / 2);
        }
    }

    public int delete() {
        if (arr[0] < 1) {
            return -1;
        }
        int curr, p1, p2, removed;
        removed = arr[1];

        arr[1] = arr[arr[0] - 1];
        arr[0]--;

        //sift down
        curr = 1;
        p1 = curr * 2;
        p2 = curr * 2 + 1;

        while (p2 < arr[0] || p1 < arr[0]) {
            if (arr[p1] < arr[p2]) {
                if (arr[p1] < arr[curr]) {
                    swap(curr, p1);
                    curr = p1;
                }
            } else {
                if (arr[p2] < arr[curr]) {
                    swap(curr, p2);
                    curr = p2;
                }
            }

            p1 = curr * 2;
            p2 = curr * 2 + 1;
        }
        return removed;
    }

    public void print() {
        for (int i = 1; i < arr[0]; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int getNumItems() {
        return arr[0] - 1;
    }

    public boolean isEmpty() {
        return arr[0] == 1;
    }
}
