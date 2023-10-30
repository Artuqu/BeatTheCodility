package otherAlgorithms.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public static void main(String[] args) {
        printList();
        boolean cycle = isCycle(getListCycle());
        boolean noCycle = isCycle(getListNoCycle());
        System.out.println("Is isCycleList has cycle: " + cycle);
        System.out.println("Is noCycleList has cycle: " + noCycle);
    }

    public static void printList() {
        ListNode head = new ListNode(10);
        ListNode node = new ListNode(20);
        ListNode tail = new ListNode(15);
        head.next = node;
        node.next = tail;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static boolean isCycle(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (cache.contains(node)) return true;
            cache.add(node);
            node = node.next;
        }
        return false;
    }

    public static ListNode getListNoCycle() {
        ListNode head = new ListNode(10);
        ListNode node = new ListNode(20);
        ListNode tail = new ListNode(15);
        head.next = node;
        node.next = tail;
        return head;
    }

    public static ListNode getListCycle() {
        ListNode head = new ListNode(10);
        ListNode node = new ListNode(20);
        ListNode tail = new ListNode(15);
        head.next = node;
        node.next = tail;
        tail.next = head;
        return head;
    }
}
