/**
1. 为保证**存在有限个节点**和**节点使用后位置的移动**，使用双向链表。
    - 使用双向链表保证时间复杂度是0(1)的，使用单链表查找节点的时候需要从头到尾遍历，
    时间复杂度O(n)
    - node保存两个值，key和value， key用于更新HashMap的key，value用于保存值。
2. 为保证O(1)的时间复杂度，使用HashMap，value即是链表中的一个节点。

 */

class Node {
    int key, val;
    Node left, right;
    Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    static Node head, tail;
    static HashMap<Integer, Node> map = new HashMap<>();
    static int n;

    // 删除当前结构体p
    static void remove(Node p) {
        p.right.left = p.left;
        p.left.right = p.right;
    }

    // 在队头加入结构体
    static void insertToHead(Node p) {
        p.right = head.right;
        head.right.left = p;
        p.left = head;
        head.right = p;
    }

    public LRUCache(int capacity) {
        n = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
        map.clear();

    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node p = map.get(key);
        // remove p and insert p at listHead
        remove(p);
        insertToHead(p);
        return p.val;
    }
    
    public void put(int key, int value) {
        // 如果map中已存在key
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            remove(p);
            insertToHead(p);
        } else {
            if (map.size() == n) {
                Node p = tail.left;
                remove(p);
                map.remove(p.key);
            } 
            Node t = new Node(key, value);
            insertToHead(t);
            map.put(key, t);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */