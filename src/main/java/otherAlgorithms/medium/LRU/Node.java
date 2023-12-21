package otherAlgorithms.medium.LRU;

public class Node {

     int key;
     int value;
     Node previous;
     Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}
