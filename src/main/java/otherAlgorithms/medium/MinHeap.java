package otherAlgorithms.medium;

import java.util.Arrays;

public class MinHeap extends MaxHeap {
    public MinHeap(int capacity) {
        super(capacity);
    }

    public MinHeap() {
    }

    public int[] convertToMinHeap(int[] maxHeap) {
        if (maxHeap == null) throw new IllegalArgumentException("The given max heap can not be null");
        int parentIndex = getParent(maxHeap.length - 1);
        while (parentIndex >= 0) {
            heapifyMin(maxHeap, parentIndex);
            parentIndex--;
        }
        return maxHeap;
    }

    private void heapifyMin(int[] maxHeap, int parentIndex) {
        if (getChild(parentIndex, true) < maxHeap.length && getChild(parentIndex, false) < maxHeap.length) {
            System.out.println(Arrays.toString(maxHeap));
            int left = getChild(parentIndex, true);
            int right = getChild(parentIndex, false);
            int smallest = parentIndex;
//        condition maxHeap.length is important for null child
            if (left < maxHeap.length && maxHeap[left] < maxHeap[parentIndex]) smallest = left;
            if (right < maxHeap.length && maxHeap[right] < maxHeap[smallest]) smallest = right;
            if (smallest != parentIndex) {
                swap(maxHeap, parentIndex, smallest);
                heapifyMin(maxHeap, smallest);
            }
        }
    }

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
