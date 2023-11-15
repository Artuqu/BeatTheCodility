package otherAlgorithms.linkedList;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T extends Comparable<T>> {
    @Setter(AccessLevel.NONE)
    T val;
    ListNode<T> next;
    ListNode<T> prev;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(T val, ListNode<T> next, ListNode<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
