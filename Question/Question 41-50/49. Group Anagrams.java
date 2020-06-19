import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    //通过Hash比较判断错乱的字符串是否有相同的字母
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Map<Character, Integer>,List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            Map<Character, Integer> tempMap = new HashMap<>();
            String tempStr = strs[i];
            for(int j=0; j<tempStr.length(); j++){
                tempMap.put(tempStr.charAt(j),tempMap.getOrDefault(tempStr.charAt(j),0)+1);
            }
            if(!map.containsKey(tempMap)){
                map.put(tempMap, new ArrayList<>());
            }
            map.get(tempMap).add(tempStr);//相同字母的字符串放到一起
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
    // 优化通过单个字符串排序，把排序后的字符串当做HashMap的key。
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);//排序
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}