package otherAlgorithms.binarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeHeight {


    public int solution(TreeNode<Integer> root) {
        if (root == null) return 0;
        return 1 + Math.max(solution(root.getRight()), solution(root.getLeft()));
    }

    public int solution2(TreeNode<Integer> root) {
        int height = 0;
        if (root == null) return height;
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            height++;
            for (int i = 0; i < level; i++) {
                if (queue.peek().getLeft() != null) queue.offer(queue.peek().getLeft());
                if (queue.peek().getRight() != null) queue.offer(queue.peek().getRight());
                queue.poll();
            }
        }
        return height;
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

        System.out.println(new BinaryTreeHeight().solution(root));
        System.out.println(new BinaryTreeHeight().solution2(root));
    }
}
