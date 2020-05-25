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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */