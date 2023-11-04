package otherAlgorithms.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IntersectionOfTwoLinkedList {

    public Integer solution(LinkedList<Integer> a, LinkedList<Integer> b) {
        if (b.size() < a.size()) return solution(b, a);
        int differance = b.size() - a.size();
        int last = -1;
        for (int i = a.size() - 1; i > 0; i--) {
            if (Objects.equals(a.get(i), b.get(i + differance))) last = a.get(i);
            else break;
        }
        return last != -1 ? last : null;
    }

    public ListNode solution2(ListNode headA, ListNode headB) {
        ListNode lA = headA;
        ListNode lB = headB;
        while (lA != lB) {
            lA = (lA != null) ? lA.next : headB;
            lB = (lB != null) ? lB.next : headA;
        }
        return lA;
    }

    public static void main(String[] args) {
        List<Integer> firstList = List.of(4, 1, 8, 4, 5);
        LinkedList<Integer> first = new LinkedList<>(firstList);
        List<Integer> secondList = List.of(5, 6, 1, 8, 4, 5);
        LinkedList<Integer> second = new LinkedList<>(secondList);
        List<Integer> thirdList = List.of(3, 4, 5);
        LinkedList<Integer> third = new LinkedList<>(thirdList);
        List<Integer> fourthList = List.of(1, 2, 4, 5);
        LinkedList<Integer> fourth = new LinkedList<>(fourthList);

        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(1);

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(8);

        headA.next = node1;
        node1.next = node2;

        headB.next = node3;
        node3.next = node1;
        node2.next = node4;

        System.out.println(new IntersectionOfTwoLinkedList().solution(first, second));
        System.out.println(new IntersectionOfTwoLinkedList().solution(fourth, third));
        System.out.println("Node version: " + new IntersectionOfTwoLinkedList().solution2(headA, headB).val);
    }
}
