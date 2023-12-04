package otherAlgorithms.binarySearch;

import java.util.Deque;
import java.util.LinkedList;

public class LargestElementInBSTByK {

    private int counter = 0;
    private int counterInt = 0;
    private int result;

    public void solution(TreeNode<Integer> root, int k) {
        if (root == null || counter >= k) return;
        solution(root.getRight(), k);
        counter++;
        if (counter == k) System.out.println(root.getVal());
        solution(root.getLeft(), k);
    }

    public int solution2(TreeNode<Integer> root, int k) {
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            if (curr.getRight() != null) solution2(curr.getRight(), k);
            counterInt++;
            if (counterInt == k) {
                result = curr.getVal();
                return result;
            }
            if (curr.getLeft() != null) solution2(curr.getLeft(), k);
        }
        return result;
    }


    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(8);
        TreeNode<Integer> firstNode1 = new TreeNode<>(3);
        TreeNode<Integer> firstNode2 = new TreeNode<>(10);
        TreeNode<Integer> firstNode3 = new TreeNode<>(1);
        TreeNode<Integer> firstNode4 = new TreeNode<>(6);
        TreeNode<Integer> firstNode5 = new TreeNode<>(14);
        TreeNode<Integer> firstNode6 = new TreeNode<>(4);
        TreeNode<Integer> firstNode7 = new TreeNode<>(7);
        TreeNode<Integer> firstNode8 = new TreeNode<>(13);

        root.setLeft(firstNode1);
        root.setRight(firstNode2);
        firstNode1.setLeft(firstNode3);
        firstNode1.setRight(firstNode4);
        firstNode2.setRight(firstNode5);
        firstNode4.setLeft(firstNode6);
        firstNode4.setRight(firstNode7);
        firstNode5.setLeft(firstNode8);
        new LargestElementInBSTByK().solution(root, 6);
        System.out.println(new LargestElementInBSTByK().solution2(root, 1));

    }
}
