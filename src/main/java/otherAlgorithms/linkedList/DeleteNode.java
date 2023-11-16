package otherAlgorithms.linkedList;

public class DeleteNode {

    public ListNode<Integer> solution(ListNode<Integer> node) {
        ListNode<Integer> nextNextNode = node.getNext().getNext();
        node.val = node.getNext().val;
        node.getNext().setNext(null);
        node.setNext(nextNextNode);
        return node;
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

        ListNode<Integer> solution = new DeleteNode().solution(node3);
        new ReversedDoublyLinkedList().printLinkedList(solution);
    }
}
