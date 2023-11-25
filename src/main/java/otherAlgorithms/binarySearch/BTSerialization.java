package otherAlgorithms.binarySearch;

public class BTSerialization {

    public void serializePreOrder(TreeNode<Integer> node, StringBuilder treeStr) {
        if (node == null) {
            treeStr.append("#");
            return;
        }
        treeStr.append("^").append(node.getVal());
        serializePreOrder(node.getLeft(), treeStr);
        serializePreOrder(node.getRight(), treeStr);
    }

    public static void main(String[] args) {
        TreeNode<Integer> p1Root = new TreeNode<>(1);
        TreeNode<Integer> p1Node1 = new TreeNode<>(2);
        TreeNode<Integer> p1Node2 = new TreeNode<>(3);
        p1Root.setLeft(p1Node1);
        p1Root.setRight(p1Node2);

        StringBuilder sb = new StringBuilder();
        new BTSerialization().serializePreOrder(p1Root, sb);
        System.out.println("Pre Order: " + sb);
    }
}
