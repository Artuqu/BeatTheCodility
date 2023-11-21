package otherAlgorithms.binarySearch;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class NTreeNode<T extends Comparable<T>> {
    private T value;
    private List<NTreeNode<T>> children;

    public NTreeNode(T value, List<NTreeNode<T>> children) {
        this.value = value;
        this.children = children;
    }

    public NTreeNode() {
    }

    public NTreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NTreeNode{" +
                "value=" + value +
                '}';
    }
}
