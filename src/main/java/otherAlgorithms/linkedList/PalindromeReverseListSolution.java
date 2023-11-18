package otherAlgorithms.linkedList;

public class PalindromeReverseListSolution {


    public boolean solution(ListNode<Integer> head) {
        if (head == null) return true;

        ListNode<Integer> firstHalfEnd = endOfFirstEnd(head);
        ListNode<Integer> secondHalfStart = reverseList(firstHalfEnd.getNext());

        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
//        back to original list
        firstHalfEnd.setNext(reverseList(secondHalfStart));
        return result;
    }

    private ListNode<Integer> reverseList(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = head;
        while (curr != null) {
            ListNode<Integer> nextTemp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode<Integer> endOfFirstEnd(ListNode<Integer> head) {
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node1 = new ListNode<>(2);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(1);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        boolean solution = new PalindromeReverseListSolution().solution(head);
        System.out.println(solution);
    }
}
