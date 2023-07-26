import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cachedValues;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cachedValues = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (cachedValues.containsKey(key)) {
            Node node = cachedValues.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cachedValues.containsKey(key)) {
            Node node = cachedValues.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cachedValues.put(key, newNode);
            moveToHead(newNode);
            if (cachedValues.size() > capacity) {
                removeTail();
            }
        }
    }

    private void moveToHead(Node node) {
        if (node != head) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == tail) {
                tail = node.prev;
            }
            node.prev = null;
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
        }
    }

    private void removeTail() {
        if (tail != null) {
            int key = tail.key;
            cachedValues.remove(key);
            if (tail == head) {
                head = null;
                tail = null;
            } else {
                Node prevTail = tail.prev;
                if (prevTail != null) {
                    prevTail.next = null;
                }
                tail = prevTail;
            }
        }
    }

    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */