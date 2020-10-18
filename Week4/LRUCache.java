class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> lruCache;
    int capacity;
    Node dummyHead, dummyTail;
    int currentSize;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruCache = new HashMap<>();
        
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        
        dummyHead.prev = null;
        dummyTail.next = null;
        
        currentSize = 0;
    }
    
    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToHead(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
    
    public int get(int key) {
        // key present
        if (lruCache.get(key) != null) {
            Node node = lruCache.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        // key already present, just update value
        if (lruCache.get(key) != null) {
            Node node = lruCache.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {    // key not present, create a new node and addToHead
            Node node = new Node(key, value);
            lruCache.put(key, node);
            
            // however check capacity and evict the lru
            if (currentSize < capacity) {   // absolutely new node added
                currentSize++;
                addToHead(node);
            } else {    // evict the node from tail
                // remove from both hashmap and doubly linked list
                lruCache.remove(dummyTail.prev.key);    // only for this one operation we need key both in map and ll
                deleteNode(dummyTail.prev);
                addToHead(node);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */