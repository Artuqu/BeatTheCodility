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
        if (list.size() == 1) return true;
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) return false;
        }
        return true;
    }

    public boolean solution3(ListNode<Integer> head) {
        String s = getString(head);
        if (s.isEmpty()) return false;
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private ListNode<Integer> frontPointer;

    public boolean recursiveCheck(ListNode<Integer> head) {
        if (head != null) {
            if (!recursiveCheck(head.next)) return false;
            if (head.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean solution4(ListNode<Integer> head) {
        frontPointer = head;
        return recursiveCheck(head);
    }

    private String getString(ListNode<Integer> head) {
        ListNode<Integer> node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.getNext();
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(1);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(new PalindromeLinkedList().solution4(head));

    }
}
