package otherAlgorithms.binarySearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameBinaryTrees {

    public boolean bfsSolution(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null || q == null) return false;
        if (p == null && q == null) return true;
        Queue<TreeNode<Integer>> queueP = new ArrayDeque<>();
        Queue<TreeNode<Integer>> queueQ = new ArrayDeque<>();
        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode<Integer> currP = queueP.poll();
            TreeNode<Integer> currQ = queueQ.poll();
            if (currP.getVal() != currQ.getVal()) return false;
            if (currP.getLeft() != null && currQ.getLeft() != null) {
                queueP.add(currP.getLeft());
                queueQ.add(currQ.getLeft());
            }
            if (currP.getRight() != null && currQ.getRight() != null) {
                queueP.add(currP.getRight());
                queueQ.add(currQ.getRight());
            }
            if (currP.getLeft() == null && currQ.getLeft() != null) return false;
            if (currP.getRight() == null && currQ.getRight() != null) return false;
        }
        return true;
    }

    public boolean dfsSolution(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.getVal() != q.getVal()) return false;
        return dfsSolution(p.getLeft(), q.getLeft()) && dfsSolution(p.getRight(), q.getRight());
    }

    public static void main(String[] args) {

        TreeNode<Integer> p1Root = new TreeNode<>(1);
        TreeNode<Integer> p1Node1 = new TreeNode<>(2);
        TreeNode<Integer> p1Node2 = new TreeNode<>(3);
        p1Root.setLeft(p1Node1);
        p1Root.setRight(p1Node2);

        TreeNode<Integer> q1Root = new TreeNode<>(1);
        TreeNode<Integer> q1Node1 = new TreeNode<>(2);
        TreeNode<Integer> q1Node2 = new TreeNode<>(3);
        q1Root.setLeft(q1Node1);
        q1Root.setRight(q1Node2);

        TreeNode<Integer> p2Root = new TreeNode<>(1);
        TreeNode<Integer> p2Node1 = new TreeNode<>(2);
        p2Root.setLeft(p2Node1);

        TreeNode<Integer> q2Root = new TreeNode<>(1);
        TreeNode<Integer> q2Node1 = new TreeNode<>(2);
        q2Root.setRight(q2Node1);

        TreeNode<Integer> p3Root = new TreeNode<>(1);
        TreeNode<Integer> p3Node1 = new TreeNode<>(2);
        TreeNode<Integer> p3Node2 = new TreeNode<>(1);
        p3Root.setLeft(p3Node1);
        p3Root.setRight(p3Node2);

        TreeNode<Integer> q3Root = new TreeNode<>(1);
        TreeNode<Integer> q3Node1 = new TreeNode<>(1);
        TreeNode<Integer> q3Node2 = new TreeNode<>(2);
        q3Root.setLeft(q3Node1);
        q3Root.setRight(q3Node2);

        System.out.println(new SameBinaryTrees().bfsSolution(p1Root, q1Root));
        System.out.println(new SameBinaryTrees().bfsSolution(p2Root, q2Root));
        System.out.println(new SameBinaryTrees().bfsSolution(p2Root, q2Root));
        System.out.println("Second solution:");
        System.out.println(new SameBinaryTrees().dfsSolution(p1Root, q1Root));
        System.out.println(new SameBinaryTrees().dfsSolution(p2Root, q2Root));
        System.out.println(new SameBinaryTrees().dfsSolution(p2Root, q2Root));

    }

}
