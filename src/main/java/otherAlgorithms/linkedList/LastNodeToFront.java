package otherAlgorithms.linkedList;

public class LastNodeToFront {

    ListNode<Integer> solution(ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        ListNode<Integer> last = head.getNext();
        while (last.getNext() != null) {
            curr = last;
            last = last.getNext();
        }
        ListNode<Integer> secondNode = head.getNext();
        head.setNext(null);
        curr.setNext(head);
        last.setNext(secondNode);

        return last;
    }


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(7);
        ListNode<Integer> node1 = new ListNode<>(4);
        ListNode<Integer> node2 = new ListNode<>(3);
        ListNode<Integer> node3 = new ListNode<>(1);
        ListNode<Integer> node4 = new ListNode<>(8);
        ListNode<Integer> node5 = new ListNode<>(2);
        ListNode<Integer> node6 = new ListNode<>(9);
        ListNode<Integer> node7 = new ListNode<>(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode<Integer> solution = new LastNodeToFront().solution(head);
       new ReversedDoublyLinkedList().printLinkedList(solution);
    }
}
