class LRUCache(var capacity: Int) {
    var length = 0
    var cache = mutableMapOf<Int, Node>()
    val alist = DoubleLinkedList()

    fun get(key: Int): Int {
        var node = cache.get(key)
        if (node == null) return -1
        alist.pushHead(node);
        return node.value;
    }

    fun put(key: Int, value: Int) {
        var node = cache.get(key);
        // Update the value of the key if the key exists.
        if (node != null) {
            node.value = value;
            this.alist.pushHead(node);
            return;
        }
        // Otherwise, add the key-value pair to the cache.
        node = Node(key, value);
        if (length >= capacity) {
            var lrukey = alist.popTail()
            cache.remove(lrukey)
            length -= 1
        }
        alist.pushHead(node);
        cache.put(key, node);
        length += 1;
    }

}

class DoubleLinkedList(){
    var head: Node? = null
    var tail: Node? = null

    fun pushHead(node: Node) {
        // First node created
        if (head == null || tail == null) {
            head = node
            tail = node
            return
        }
        if (node == head) return
        if (node == tail) {
            tail = node.next
            node.prev = head
            head?.let { safeHead -> safeHead.next = node }
            head = node
            return
        }
        if (node.prev != null) node.prev?.let{ safePrev -> safePrev.next = node.next }
        if (node.next != null) node.next?.let{ safeNext -> safeNext.prev = node.prev }
        node.prev = head
        head?.let{ safeHead -> safeHead.next = node }
        head = node
    };
 
    fun popTail(): Int {
        if (tail == null) return -1
        var lrukey = tail!!.key
        if (tail == head) {
            tail = null
            head = null
            return lrukey
        }
        var newTail = tail!!.next!!
        newTail.prev = null
        tail = newTail
        return lrukey
    };
}

class Node(var key: Int, var value: Int){
    var next: Node? = null
    var prev: Node? = null
}