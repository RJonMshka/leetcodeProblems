import java.util.Map;
import java.util.HashMap;

public class LRUCache {

    class DataNode {
        int value;
        int key;
        DataNode next;
        DataNode prev;
        public DataNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DataNode(int key, int value, DataNode next, DataNode prev) {
            this.key = key;
            this.value = value;
            this.next =  next;
            this.prev = prev;
        }
    }
    private int capacity;
    private DataNode left = new DataNode(-1, -1);
    private DataNode right = new DataNode(-1, -1);
    private Map<Integer, DataNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public static void main(String[] args) {
        // Test Case
        LRUCache lCache = new LRUCache(2);
        lCache.put(1, 1);
        lCache.put(2, 2);
        System.out.println( lCache.get(1) );
        lCache.put(3, 3);
        System.out.println( lCache.get(2) );
        lCache.put(4, 4);
        System.out.println( lCache.get(1) );
        System.out.println( lCache.get(3) );
        System.out.println( lCache.get(4) );
    }

    public int get(int key) {
        if(this.cache.containsKey(key)) {
            DataNode node = this.cache.get(key);
            this.moveToTop(node);
            return node.value;
        }
        return -1;
    }

    public void moveToTop(DataNode node) {
        this.removeNode(node);
        this.addToCache(node);
    }

    public void removeNode(DataNode node) {
        DataNode nextNode = node.next;
        DataNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        DataNode node;
        if(this.cache.containsKey(key)) {
            node = this.cache.get(key);
            node.value = value;
            this.moveToTop(node);
            return;
        }
        node = new DataNode(key, value);
        this.cache.put(key, node);
        this.addToCache(node);
        if(this.cache.size() > this.capacity) {
            this.removeLeastUsed();
        }
    }

    public void removeLeastUsed() {
        if(this.cache.size() != 0) {
            DataNode nodeToRemove = this.right.prev;
            int key = nodeToRemove.key;
            this.right.prev = nodeToRemove.prev;
            this.right.prev.next = this.right;
            this.cache.remove(key);
        }
    }

    public void addToCache(DataNode node) {
        node.next = this.left.next;
        node.next.prev = node;
        this.left.next = node;
        node.prev = this.left;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */