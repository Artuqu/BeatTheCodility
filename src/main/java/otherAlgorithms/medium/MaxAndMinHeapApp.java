package otherAlgorithms.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxAndMinHeapApp {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(100);
        maxHeap.insert(200);
        maxHeap.insert(50);
        maxHeap.insert(70);
        maxHeap.insert(10);
        maxHeap.printHeap();
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(maxHeap.deleteMaxValue() + " ");
        }
        System.out.println();
        System.out.println("Priority Queue solution: ");
        Queue<Integer> pqueue = new PriorityQueue<>(5, Comparator.reverseOrder());
        pqueue.add(100);
        pqueue.add(200);
        pqueue.add(50);
        pqueue.add(70);
        pqueue.add(10);
        System.out.println(pqueue);
        for (int i = 0; i < 5; i++) {
            System.out.print(pqueue.poll() + " ");
        }
    }
}
