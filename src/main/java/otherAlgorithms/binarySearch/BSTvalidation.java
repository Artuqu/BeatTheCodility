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
        getCounter = list.size() - 3;
        counter = list.size() - 2;
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
            System.out.print(currVal + " ");
            if (curr.getRight() != null) solution(curr.getRight());
        }
    }

    //    valid range solution
    public boolean solution2(TreeNode<Integer> root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode<Integer> root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && low >= root.getVal() || high != null && high <= root.getVal()) return false;
        System.out.print(root.getVal() + " ");
        return validateBST(root.getRight(), root.getVal(), high) && validateBST(root.getLeft(), low, root.getVal());
    }

    //    DFS Inorder improved

    private Integer prev;

    public boolean solution3(TreeNode<Integer> root) {
        prev = null;
        return secondInorder(root);
    }

    private boolean secondInorder(TreeNode<Integer> root) {
        if (root == null) return true;
        if (!secondInorder(root.getLeft())) return false;
        if (prev != null && root.getVal() <= prev) return false;
        prev = root.getVal();
        System.out.print(root.getVal() + " ");
        if (!secondInorder(root.getRight())) return false;
        return true;
    }

    //    iterative in-order
    public boolean solution4(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        Integer prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null){
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            if (prev != null && root.getVal() <= prev) return false;
            prev = root.getVal();
            System.out.print(prev + " ");
            root = root.getRight();
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode<Integer> valid = new TreeNode<>(8);
        TreeNode<Integer> firstNode1 = new TreeNode<>(3);
        TreeNode<Integer> firstNode2 = new TreeNode<>(10);
        TreeNode<Integer> firstNode3 = new TreeNode<>(1);
        TreeNode<Integer> firstNode4 = new TreeNode<>(6);
        TreeNode<Integer> firstNode5 = new TreeNode<>(14);
        TreeNode<Integer> firstNode6 = new TreeNode<>(4);
        TreeNode<Integer> firstNode7 = new TreeNode<>(7);
        TreeNode<Integer> firstNode8 = new TreeNode<>(13);

        valid.setLeft(firstNode1);
        valid.setRight(firstNode2);
        firstNode1.setLeft(firstNode3);
        firstNode1.setRight(firstNode4);
        firstNode2.setRight(firstNode5);
        firstNode4.setLeft(firstNode6);
        firstNode4.setRight(firstNode7);
        firstNode5.setLeft(firstNode8);

        TreeNode<Integer> notValid = new TreeNode<>(8);
        TreeNode<Integer> secondNode1 = new TreeNode<>(3);
        TreeNode<Integer> secondNode2 = new TreeNode<>(10);
        TreeNode<Integer> secondNode3 = new TreeNode<>(1);
        TreeNode<Integer> secondNode4 = new TreeNode<>(6);
        TreeNode<Integer> secondNode5 = new TreeNode<>(14);
        TreeNode<Integer> secondNode6 = new TreeNode<>(4);
        TreeNode<Integer> secondNode7 = new TreeNode<>(7);
        TreeNode<Integer> secondNode8 = new TreeNode<>(9);

        notValid.setLeft(secondNode1);
        notValid.setRight(secondNode2);
        secondNode1.setLeft(secondNode3);
        secondNode1.setRight(secondNode4);
        secondNode2.setLeft(secondNode7);
        secondNode2.setRight(secondNode5);
        secondNode4.setLeft(secondNode6);
        secondNode4.setRight(secondNode7);
        secondNode5.setLeft(secondNode8);

        System.out.println(new BSTvalidation().solution(valid));
        System.out.println(new BSTvalidation().solution(notValid));
        System.out.println();

        System.out.println(new BSTvalidation().solution2(valid));
        System.out.println(new BSTvalidation().solution2(notValid));
        System.out.println();

        System.out.println(new BSTvalidation().solution3(valid));
        System.out.println(new BSTvalidation().solution3(notValid));
        System.out.println();

        System.out.println(new BSTvalidation().solution4(valid));
        System.out.println(new BSTvalidation().solution4(notValid));
    }
}
