package otherAlgorithms.linkedList;

public class ReversedDoublyLinkedList {


    public ListNode<Integer> solution(ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        while (curr != null) {
            ListNode<Integer> nextTemp = curr.getNext();
            curr.setNext(curr.getPrev());
            curr.setPrev(nextTemp);
            curr = curr.getPrev();
            if (curr != null) head = curr;
        }
        return head;
    }

    public void printLinkedList(ListNode<Integer> head) {
        ListNode<Integer> listNode = head;
        while (listNode != null) {
            System.out.print(listNode.getVal() + " ");
            listNode = listNode.getNext();
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        ListNode<Integer> node2 = new ListNode<>(3);
        ListNode<Integer> node3 = new ListNode<>(4);
        ListNode<Integer> node4 = new ListNode<>(5);

        head.setNext(node1);
        node1.setPrev(head);
        node1.setNext(node2);

        node2.setPrev(node1);
        node2.setNext(node3);

        node3.setPrev(node2);
        node3.setNext(node4);

        node4.setPrev(node3);

        System.out.print("Original list: ");
        new ReversedDoublyLinkedList().printLinkedList(head);
        System.out.print("\nReversed list: ");
        ListNode<Integer> solution = new ReversedDoublyLinkedList().solution(head);
        new ReversedDoublyLinkedList().printLinkedList(solution);

    }
}
