package otherAlgorithms.linkedList;

import java.util.LinkedList;
import java.util.List;

public class ReversedLinkedList {

    public LinkedList<Integer> solution(LinkedList<Integer> l) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (Integer i : l) {
            reversed.addFirst(i);
        }
        return reversed;
    }

    public ListNode solution2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next; // keeping object next (next 3, value 2)
            head.next = prev; //set reference to back (null), but full object still has value 1
            prev = head; //set full object prev as a head (value = 1, reference = null)
            head = temp; // set object temp to head (reference = 3, value= 2)
        }
        return prev;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Integer[] l1 = {1, 2, 3, 4, 5};
        LinkedList<Integer> list1 = new LinkedList<>(List.of(l1));
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(new ReversedLinkedList().solution((list1)));
        printLinkedList(head);
        ListNode node = new ReversedLinkedList().solution2(head);
        System.out.print("\nNode version after reversed: ");
        printLinkedList(node);
    }
}
