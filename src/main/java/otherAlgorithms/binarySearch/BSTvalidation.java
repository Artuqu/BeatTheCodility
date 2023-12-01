package otherAlgorithms.binarySearch;

import java.util.*;

public class BSTvalidation {


    List<Integer> list = new ArrayList<>();
    int counter = 0;
    int getCounter = -1;

    //  DFS Inorder
    public boolean solution(TreeNode<Integer> root) {
        inorder(root);
        if (getCounter > -1) {
            int first = list.get(getCounter);
            for (int i = counter; i < list.size(); i++) {
                if (first > list.get(i)) return false;
                first = list.get(i);
            }
        }
        counter++;
        getCounter++;
        return true;
    }

    private void inorder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        Integer currVal;
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            if (curr.getLeft() != null) solution(curr.getLeft());
            currVal = curr.getVal();
            list.add(currVal);
            if (curr.getRight() != null) solution(curr.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> firstRoot = new TreeNode<>(8);
        TreeNode<Integer> firstNode1 = new TreeNode<>(3);
        TreeNode<Integer> firstNode2 = new TreeNode<>(10);
        TreeNode<Integer> firstNode3 = new TreeNode<>(1);
        TreeNode<Integer> firstNode4 = new TreeNode<>(6);
        TreeNode<Integer> firstNode5 = new TreeNode<>(14);
        TreeNode<Integer> firstNode6 = new TreeNode<>(4);
        TreeNode<Integer> firstNode7 = new TreeNode<>(7);
        TreeNode<Integer> firstNode8 = new TreeNode<>(13);

        firstRoot.setLeft(firstNode1);
        firstRoot.setRight(firstNode2);
        firstNode1.setLeft(firstNode3);
        firstNode1.setRight(firstNode4);
        firstNode2.setRight(firstNode5);
        firstNode4.setLeft(firstNode6);
        firstNode4.setRight(firstNode7);
        firstNode5.setLeft(firstNode8);

        TreeNode<Integer> secondRoot = new TreeNode<>(8);
        TreeNode<Integer> secondNode1 = new TreeNode<>(3);
        TreeNode<Integer> secondNode2 = new TreeNode<>(10);
        TreeNode<Integer> secondNode3 = new TreeNode<>(1);
        TreeNode<Integer> secondNode4 = new TreeNode<>(6);
        TreeNode<Integer> secondNode5 = new TreeNode<>(14);
        TreeNode<Integer> secondNode6 = new TreeNode<>(4);
        TreeNode<Integer> secondNode7 = new TreeNode<>(7);
        TreeNode<Integer> secondNode8 = new TreeNode<>(9);

        secondRoot.setLeft(secondNode1);
        secondRoot.setRight(secondNode2);
        secondNode1.setLeft(secondNode3);
        secondNode1.setRight(secondNode4);
        secondNode2.setLeft(secondNode7);
        secondNode2.setRight(secondNode5);
        secondNode4.setLeft(secondNode6);
        secondNode4.setRight(secondNode7);
        secondNode5.setLeft(secondNode8);

        System.out.println(new BSTvalidation().solution(firstRoot));
        System.out.println(new BSTvalidation().solution(secondRoot));
    }
}
