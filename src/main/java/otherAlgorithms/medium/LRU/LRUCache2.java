package otherAlgorithms.medium.LRU;

import java.util.HashMap;

public class LRUCache2 {

    private HashMap<Integer, Node> cache;
    private DoublyLinkedList list;
    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        else {
            Node node = cache.get(key);
            list.remove(node);
            list.insertHead(node);
            return cache.get(key).value;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
//          update
        if (cache.containsKey(key)) {
            list.remove(cache.get(key));
//          insert
        } else if (cache.size() >= capacity) {
            int k = list.removeTail();
            cache.remove(k);
        }
        save(key, node);
    }

    private void save(int key, Node node) {
        list.insertHead(node);
        cache.put(key, node);
    }
}
