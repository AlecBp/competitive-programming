package managedarray;

/**
 * @author Alec
 */
public class ManagedArray {

    public static void main(String[] args) {
        MyArray ma = new MyArray(1000);
        int[] data = new int[]{25, 10, 15, 20, 24, 40, 50, 60};
        for (int i = 0; i < data.length; i++) {
            ma.addLast(data[i]);
        }

        ma.printArray();
        ma.mergeSortASC();
        ma.printArray();
        ma.addFront(1);
        ma.addLast(1000);
        ma.printArray();
        ma.removeInOrder(10);
        ma.printArray();

        int[] keys = new int[]{60, 1000, 99, 78, 1, 40};
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Binary search [" + keys[i] + "]:\t" + ma.binarySearchASC(keys[i]));
            System.out.println("Linear search [" + keys[i] + "]:\t" + ma.linearSearch(keys[i]));
        }

    }
}
