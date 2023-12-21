package otherAlgorithms.medium.LRU;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public void insertHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.previous = node;
        node.previous = head;
    }

    public void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public int removeTail() {
        Node node = tail.previous;
        int key = node.key;
        remove(node);
        return key;
    }

}
