package otherAlgorithms.binarySearch;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class TreeNode<T extends Comparable<T>> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T val;

    public TreeNode(T val) {
        this.val = val;
        left = null;
        right = null;
    }

    public TreeNode() {
    }

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
