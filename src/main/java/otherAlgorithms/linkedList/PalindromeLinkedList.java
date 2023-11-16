package otherAlgorithms.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class PalindromeLinkedList {

    public boolean solution(ListNode<Integer> head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            if (!stack.isEmpty() && Objects.equals(stack.peek(), head.val)) {
                stack.pop();
            } else stack.push(head.val);

            head = head.next;
        }
        return stack.isEmpty();
    }

    public boolean solution2(ListNode<Integer> head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(1);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(new PalindromeLinkedList().solution2(head));

    }
}
