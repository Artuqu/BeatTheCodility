package otherAlgorithms.binarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class DepthFirstSearch {


    public void preorder(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            System.out.print(curr.getVal() + " ");
            if (curr.getLeft() != null) preorder(curr.getLeft());
            if (curr.getRight() != null) preorder(curr.getRight());
        }
    }

    public void inorder(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            if (curr.getLeft() != null) inorder(curr.getLeft());
            System.out.print(curr.getVal() + " ");
            if (curr.getRight() != null) inorder(curr.getRight());
        }
    }

    public void postorder(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> curr = queue.poll();
            if (curr.getLeft() != null) postorder(curr.getLeft());
            if (curr.getRight() != null) postorder(curr.getRight());
            System.out.print(curr.getVal() + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> leaf2 = new TreeNode<>(2);
        TreeNode<Integer> leaf3 = new TreeNode<>(3);
        TreeNode<Integer> leaf4 = new TreeNode<>(4);
        TreeNode<Integer> leaf5 = new TreeNode<>(5);
        TreeNode<Integer> leaf6 = new TreeNode<>(6);
        TreeNode<Integer> leaf7 = new TreeNode<>(7);

        root.setLeft(leaf2);
        root.setRight(leaf3);

        leaf2.setLeft(leaf4);
        leaf2.setRight(leaf5);

        leaf3.setLeft(leaf6);
        leaf3.setRight(leaf7);

        new DepthFirstSearch().preorder(root);
        System.out.println();
        new DepthFirstSearch().inorder(root);
        System.out.println();
        new DepthFirstSearch().postorder(root);
    }
}
