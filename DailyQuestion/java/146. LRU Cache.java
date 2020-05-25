package DailyQuestion.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
class LRUCache {
    Map<Integer,int[]> cache;//{value, count, cache.count, key}
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        count = 0;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int[] temp = cache.get(key);
            temp[1] = ++count;
            return temp[0];
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            int[] temp = cache.get(key);
            temp[0] = value;
            temp[1] = ++count;
        }else {
            if(capacity > cache.size()){
                cache.put(key, new int[]{value, ++count, key});
            }else {
                int[] removeMap = new int[]{};
                Collection<int[]> c = cache.values();
                for(int[] temp : c){
                    if(removeMap.length == 0){
                        removeMap = temp;
                    }else{
                        if(removeMap[1] > temp[1]){
                            removeMap = temp;
                        }
                    }
                }
                cache.remove(removeMap[2]);
                cache.put(key,new int[]{value, ++count, key});
            }
        }
    }
}
//哈希+双链表
class LRUCache1 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode next;
        DLinkedNode pre;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    DLinkedNode head;
    DLinkedNode tail;
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode temp = cache.get(key);
        if(temp == null){
            return -1;
        }
        moveTohead(temp);
        return temp.value;
    }

    public void put(int key, int value){
        DLinkedNode temp = cache.get(key);
        if(temp == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                DLinkedNode res = removeTail();
                cache.remove(res.key);
                size--;
            }
        }else {
            temp.value = value;
            moveTohead(temp);
        }

    }

    private void moveTohead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private void addToHead(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return  res;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */