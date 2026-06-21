public class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void insert(Node node) {
        Node temp = head.next;

        node.prev = head;
        node.next = temp;

        head.next = node;
        temp.prev = node;
    }

    void remove(Node node) {
        Node delPrev = node.prev;
        Node delNext = node.next;

        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        
        Node node = cache.get(key);
        cache.remove(key);

        remove(node);
        insert(node);

        cache.put(key, head.next);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.remove(key);
            remove(node);
        }

        if (cache.size() == cap) {
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }

        insert(new Node(key, value));
        cache.put(key, head.next);  
    }
}
