package otherAlgorithms.binarySearch;

import java.util.Arrays;

public class HashingTreeStructure {


    private static final long MOD_1 = 5;
    private static final long MOD_2 = 50;

    public long[] hashTreeAtNode(TreeNode<Integer> node) {
        if (node == null) return new long[]{3, 7};
        long[] left = hashTreeAtNode(node.getLeft());
        long[] right = hashTreeAtNode(node.getRight());
        long left1 = (left[0] << 3) % MOD_1;
        long right1 = (right[0] << 1) % MOD_1;
        long left2 = (left[1] << 3) % MOD_2;
        long right2 = (right[1] << 1) % MOD_2;
        long [] hashPair = {(left1 + right1 + node.getVal()) % MOD_1, (left2 + right2 + node.getVal()) % MOD_2};
        return hashPair;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> leaf2 = new TreeNode<>(9);
        TreeNode<Integer> leaf3 = new TreeNode<>(10);
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

        System.out.println(Arrays.toString(new HashingTreeStructure().hashTreeAtNode(root)));

    }
}
