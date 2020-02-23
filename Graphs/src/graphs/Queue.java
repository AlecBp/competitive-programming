package graphs;

/* @author AlecBp */
public class Queue {

    private QNode head;
    private QNode tail;

    public Queue() {
        head = tail = null;
    }

    public String peek() {
        if(head==null){
            return null;
        }
        return head.data;
    }

    public void enqueue(String data) {
        QNode temp = new QNode(data);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public String dequeue() {
        if (head != null) {
            String data = head.data;
            head = head.next;
            return data;
        }
        return null;
    }
}
