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

    public static void main(String[] args) {
        Integer[] l1 = {1, 2, 3, 4, 5};
        LinkedList<Integer> list1 = new LinkedList<>(List.of(l1));
        System.out.println(new ReversedLinkedList().solution((list1)));
    }
}
