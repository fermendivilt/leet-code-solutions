class LRUCache {
    public capacity: number;
    protected cachedValues: {[key: number]: {
        value: number;
        node: LinkedList;
    }};

    protected head: LinkedList | null;
    protected tail: LinkedList | null; 

    constructor(capacity: number) {
        this.capacity = capacity;
        this.cachedValues = {};
        this.head = null;
        this.tail = null;
    }

    get(key: number): number {
        if(this.cachedValues[key]) {
            this.moveToHead(this.cachedValues[key].node);
            return this.cachedValues[key].value;
        }
        return -1;
    }

    put(key: number, value: number): void {
        if(this.cachedValues[key]) {
            this.cachedValues[key].value = value;
            this.moveToHead(this.cachedValues[key].node); 
        } else {
            const newNode = new LinkedList(key); // create a new node
             this.cachedValues[key] = { // assign node to the object containing the keys
                value: value,
                node: newNode,
            }

            this.moveToHead(newNode); // move this node to head
           
            if(Object.keys(this.cachedValues).length > this.capacity) {
                this.removeTail();
            }
        }
    }

    private moveToHead(node: LinkedList): void {
        // node not head
        if(node !== this.head) { 
            if(node.prev) { 
                // skip current node, so assign it to the next
                node.prev.next = node.next;
            }
            if(node.next) { 
                // skip current node, assign it to the pev
                node.next.prev = node.prev;
            }

            if(node === this.tail) { 
                this.tail = node.prev; 
            }

            node.prev = null; // head doesn't have prev
            node.next = this.head; // update new next to the previous head
            
            if(this.head) {
                this.head.prev = node; // update prev head to new head
            }
            this.head = node; // set new head

            if(!this.tail) {
                this.tail = node; // head = tail when no tail
            }
        }
    }

    private removeTail(): void {
        if(this.tail) { 
            const key = this.tail.key;
            delete this.cachedValues[key]; // remove tail
            if(this.tail === this.head) {
                this.head = null;
                this.tail = null;
            } else {
                const prevTail = this.tail.prev; // get new ntail
                if(prevTail) {
                    prevTail.next = null; // set next value to null
                }
                this.tail = prevTail; // set new tail with next value = null
            }
        }
    }
}

class LinkedList {
    public key: number;
    public prev: LinkedList | null;
    public next: LinkedList | null;

    constructor(key: number) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */