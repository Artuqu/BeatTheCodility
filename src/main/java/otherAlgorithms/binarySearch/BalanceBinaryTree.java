package otherAlgorithms.binarySearch;

public class BalanceBinaryTree {


    public boolean solution(TreeNode<Integer> root) {
        if (root == null) return true;
        if (Math.abs(height(root.getLeft()) - height(root.getRight())) > 1) return false;
        else return solution(root.getLeft()) && solution(root.getRight());
    }

    private int height(TreeNode<Integer> root) {
        if (root == null) return 0;
        return Math.max(height(root.getRight()), height(root.getLeft())) + 1;
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
        firstNode2.setLeft(firstNode6);
        firstNode6.setRight(firstNode7);
        firstNode7.setLeft(firstNode8);

        System.out.println(new BalanceBinaryTree().solution(valid));
    }
}
