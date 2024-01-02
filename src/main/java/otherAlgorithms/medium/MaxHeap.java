package otherAlgorithms.medium;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public int getParent(int index) {
//        array starts from index 0 not 1
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void insert(int value) {
        if (isFull()) throw new RuntimeException("Heap is full");
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int deleteMaxValue() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        int maxValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        fixHeapBelow(0, size - 1);
        return maxValue;
    }

    private void fixHeapBelow(int index, int lastIndex) {
        int childToSwap;
        while (index <= lastIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastIndex) {
//                protection against out of bound exception
                if (rightChild > lastIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else break;
                index = childToSwap;
            } else break;
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
