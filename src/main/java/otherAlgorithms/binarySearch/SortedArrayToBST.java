package otherAlgorithms.binarySearch;

public class SortedArrayToBST {

    public TreeNode<Integer> solution(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private TreeNode<Integer> createMinimalBST(int[] arr, int left, int right) {
        if (left > right) return null;

        int middle = (left + right) / 2;
        TreeNode<Integer> node = new TreeNode<>(arr[middle]);
        node.setLeft(createMinimalBST(arr, left, middle - 1));
        node.setRight(createMinimalBST(arr, middle + 1, right));
        System.out.println(node.getVal());
        return node;
    }

    public static void main(String[] args) {

        int[] arr = {-3, 1, 0, 6, 9, 14, 22, 90};
        new SortedArrayToBST().solution(arr);
    }
}
