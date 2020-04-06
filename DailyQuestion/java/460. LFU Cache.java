package DailyQuestion.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
class LFUCache {
    Map<Integer, int[]> map = new HashMap<>();
    int capacity = 0;
    int count = 0;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int[] temp = map.get(key);
            temp[1]++;
            temp[2] = ++count;
            return temp[0];
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(this.capacity == 0){return;}
        if(map.containsKey(key)){
            int[] temp = map.get(key);
            temp[0] = value;
            temp[1]++;
            temp[2] = ++count;
        }else if(capacity > map.size()){
            map.put(key,new int[]{value, 1, ++count, key});
        }else{
            int[] removeMap = new int[]{};
            Collection<int[]> c = map.values();
            for(int[] temp : c){
                if(removeMap.length == 0){
                    removeMap = temp;
                }else{
                    if(removeMap[1] == temp[1]){
                        if(removeMap[2] > temp[2]){
                            removeMap = temp;
                        }
                    }else if(removeMap[1] > temp[1]){
                        removeMap = temp;
                    }
                }
            }
            map.remove(removeMap[3]);
            map.put(key,new int[]{value, 1, ++count, key});
        }
    }
}