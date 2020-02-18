package graphs;

/* @author AlecBp */
public class QNode {

    public QNode next;
    public String data;

    public QNode(String data) {
        next = null;
        this.data = data;
    }
}
