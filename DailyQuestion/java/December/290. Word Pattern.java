package DailyQuestion.java.December;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] sArr = s.split(" ");
    String[] pArr = pattern.split("");
    if(pArr.length != sArr.length){
        return false;
    }
    Map<String,String> map = new HashMap<>();
    Map<String,String> mapVal = new HashMap<>();
    for(int i=0; i < pArr.length; i++){
        String key = pArr[i];
        if(map.containsKey(key)){
            if(!map.get(key).equals(sArr[i])){
                return false;
            }
            continue;
        }else {
            if(mapVal.containsKey(sArr[i])){
                return false;
            }
            map.put(key, sArr[i]);
            mapVal.put(sArr[i], key);
        }
    }
    return true;
}
  /**
   * "abba"
   * "dog dog dog dog"
   * @param args
   */
  public static void main(String[] args) {
    Boolean b = new Solution().wordPattern("abba", "dog dog dog dog");
    System.out.println(b);
  }
}