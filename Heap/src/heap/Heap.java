package heap;

/* @author AlecBp */
public class Heap {

    public static void main(String[] args) {
        MyHeap mh = new MyHeap(100);
        int[] data = new int[]{15, 17, 180, 25, 14, 13, 9, 15, 22};
        for (int i = 0; i < data.length; i++) {
            mh.insert(data[i]);
        }
        mh.print();
        System.out.println("Number of items in q: " + mh.getNumItems());
        
        while (!mh.isEmpty()) {
            System.out.println("Removed: " + mh.delete());
            mh.print();
        }
        
        System.out.println("Number of items in q: " + mh.getNumItems());
    }
}
