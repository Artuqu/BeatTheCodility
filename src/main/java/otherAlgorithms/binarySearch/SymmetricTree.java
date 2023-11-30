package otherAlgorithms.binarySearch;

public class SymmetricTree {


    public boolean solution(TreeNode<Integer> root) {
        return searchTree(root, root);
    }
// DFS solution
    private boolean searchTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.getVal() == root2.getVal() && searchTree(root1.getLeft(), root2.getRight())
                && searchTree(root1.getRight(), root2.getLeft());
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> firstNode1 = new TreeNode<>(3);
        TreeNode<Integer> firstNode2 = new TreeNode<>(3);

        TreeNode<Integer> firstNode3 = new TreeNode<>(4);
        TreeNode<Integer> firstNode4 = new TreeNode<>(5);
        TreeNode<Integer> firstNode5 = new TreeNode<>(5);
        TreeNode<Integer> firstNode6 = new TreeNode<>(4);

        TreeNode<Integer> root2 = new TreeNode<>(1);
        TreeNode<Integer> secondNode1 = new TreeNode<>(3);
        TreeNode<Integer> secondNode2 = new TreeNode<>(2);


        root.setLeft(firstNode1);
        root.setRight(firstNode2);
        firstNode1.setLeft(firstNode3);
        firstNode1.setRight(firstNode4);
        firstNode2.setLeft(firstNode5);
        firstNode2.setRight(firstNode6);

        root2.setLeft(secondNode1);
        root2.setRight(secondNode2);

        System.out.println(new SymmetricTree().solution(root));
        System.out.println(new SymmetricTree().solution(root2));


    }
}
