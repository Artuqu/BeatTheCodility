package otherAlgorithms.binarySearch;

public class SubTree {
    public boolean solution(TreeNode<Integer> root, TreeNode<Integer> root2) {
        if (root == null) return false;
        if (isIdentical(root, root2)) return true;
        return solution(root.getLeft(), root2) || solution(root.getRight(), root2);
    }

    private boolean isIdentical(TreeNode<Integer> root, TreeNode<Integer> root2) {
        if (root == null || root2 == null) return root == null && root2 == null;
        return root.getVal() == root2.getVal() && isIdentical(root.getLeft(), root2.getLeft()) && isIdentical(root.getRight(), root2.getRight());
    }


    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(40);
        TreeNode<Integer> root2 = new TreeNode<>(30);
        TreeNode<Integer> node1 = new TreeNode<>(30);
        TreeNode<Integer> node2 = new TreeNode<>(10);
        TreeNode<Integer> node3 = new TreeNode<>(20);
        TreeNode<Integer> node23 = new TreeNode<>(20);
        TreeNode<Integer> node4 = new TreeNode<>(90);
        TreeNode<Integer> node24 = new TreeNode<>(90);
        TreeNode<Integer> node5 = new TreeNode<>(70);
        TreeNode<Integer> node6 = new TreeNode<>(80);
        TreeNode<Integer> node26 = new TreeNode<>(80);
        TreeNode<Integer> node7 = new TreeNode<>(6);
        TreeNode<Integer> node27 = new TreeNode<>(6);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        node3.setLeft(node7);

        root2.setLeft(node23);
        root2.setRight(node24);

        node23.setLeft(node27);
        node23.setRight(node26);

        System.out.println(new SubTree().solution(root, root2));


    }
}
