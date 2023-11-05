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

    // only if head is different from tail
    public Integer solution3(LinkedList<Integer> a, LinkedList<Integer> b) {
        int i = 1;
        int j = 0;
        int k = 0;
        Integer aL = a.get(0);
        Integer bL = b.get(0);
        while (!Objects.equals(aL, bL) && j < b.size() && k < a.size()) {
            aL = (i < a.size()) ? a.get(i) : b.get(j++);
            bL = (i < b.size()) ? b.get(i) : a.get(k++);
            i++;
        }
        return Objects.equals(aL, bL) ? aL : null;
    }

    public static void main(String[] args) {
        List<Integer> firstList = List.of(4, 1, 8, 4, 5);
        LinkedList<Integer> first = new LinkedList<>(firstList);
        List<Integer> secondList = List.of(9, 6, 1, 8, 4, 5);
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
        node2.next = node4;

        headB.next = node3;
        node3.next = node1;

        System.out.println(new IntersectionOfTwoLinkedList().solution3(first, second));
        System.out.println(new IntersectionOfTwoLinkedList().solution3(fourth, third));
        System.out.println("Node version: " + new IntersectionOfTwoLinkedList().solution2(headA, headB).val);
    }
}
