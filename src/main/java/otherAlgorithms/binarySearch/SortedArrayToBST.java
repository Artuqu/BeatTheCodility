package otherAlgorithms.binarySearch;

import java.util.Random;

public class SortedArrayToBST {

    public TreeNode<Integer> solution(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private TreeNode<Integer> createMinimalBST(int[] arr, int left, int right) {
        if (left > right) return null;


//        always left element
        int middle = (left + right) / 2;

//        always right element
//        if ((left + right) % 2 == 1) middle++;

//        random element
        if ((left + right) % 2 == 1) middle += new Random().nextInt(2);


        TreeNode<Integer> node = new TreeNode<>(arr[middle]);
        node.setLeft(createMinimalBST(arr, left, middle - 1));
        node.setRight(createMinimalBST(arr, middle + 1, right));
        return node;
    }

    public static void main(String[] args) {

        int[] arr = {-3, 1, 0, 6, 9, 14, 22, 90};
        TreeNode<Integer> solution = new SortedArrayToBST().solution(arr);
        DepthFirstSearch ds = new DepthFirstSearch();
        System.out.print("Preorder: ");
        ds.preorder(solution);
        System.out.println();
        System.out.print("Postorder: ");
        ds.postorder(solution);
        System.out.println();
        System.out.print("Inorder: ");
        ds.inorder(solution);
    }
}
