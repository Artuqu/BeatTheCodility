package otherAlgorithms.medium.LRU;

public class LRUApp {


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println("Second solution:");
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1,1);
        lruCache2.put(2,2);
        System.out.println(lruCache2.get(1));
        lruCache2.put(3, 3);
        System.out.println(lruCache2.get(2));
        lruCache2.put(4, 4);
        System.out.println(lruCache2.get(1));
        System.out.println(lruCache2.get(3));
        System.out.println(lruCache2.get(4));
    }
}
