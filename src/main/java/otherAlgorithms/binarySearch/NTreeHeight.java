package otherAlgorithms.binarySearch;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class NTreeHeight {

    //DFS
    public int solution(NTreeNode<Integer> root) {
        if (root == null || root.getChildren() == null) return 0;
        int height = 0;
        for (NTreeNode<Integer> node : root.getChildren()) {
            height = Math.max(height, solution(node));
        }
        return height + 1;
    }

    //BFS
    public int solution2(NTreeNode<Integer> root) {
        Deque<Pair<NTreeNode<Integer>, Integer>> queue = new ArrayDeque<>();
        NTreeNode<Integer> parent = root;
        if (parent != null) queue.add(new Pair<>(parent, 1));
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<NTreeNode<Integer>, Integer> current = queue.poll();
            parent = current.getKey();
            int h = current.getValue();
            if (parent != null) {
                depth = Math.max(depth, h);
                for (NTreeNode<Integer> node : parent.getChildren()) queue.add(new Pair<>(node, h + 1));
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        NTreeNode<Integer> root = new NTreeNode<>(1);

        NTreeNode<Integer> node1 = new NTreeNode<>(2);
        NTreeNode<Integer> node2 = new NTreeNode<>(3);
        NTreeNode<Integer> mode3 = new NTreeNode<>(4);
        NTreeNode<Integer> node4 = new NTreeNode<>(5);
        NTreeNode<Integer> node5 = new NTreeNode<>(6);
        NTreeNode<Integer> node6 = new NTreeNode<>(7);
        NTreeNode<Integer> node7 = new NTreeNode<>(8);
        NTreeNode<Integer> node8 = new NTreeNode<>(9);
        NTreeNode<Integer> node9 = new NTreeNode<>(10);

        root.setChildren(List.of(node1, node2, mode3));
        mode3.setChildren(List.of(node4, node5, node6));
        node6.setChildren(List.of(node7, node8, node9));

        System.out.println(new NTreeHeight().solution(root));
        System.out.println(new NTreeHeight().solution2(root));
    }
}
