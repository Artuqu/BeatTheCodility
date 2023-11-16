package otherAlgorithms.linkedList;

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

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(1);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(new PalindromeLinkedList().solution(head));

    }
}
