package DailyQuestion.java.August;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    Map<Character, Character> map = new HashMap<>();
    public boolean isValid(String s) {
        if(map.size() == 0){
            map.put('(',')');
            map.put('[',']');
            map.put('{','}');
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(stack.size() == 0 || map.get(stack.pop()) != s.charAt(i)){
                    return false;
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }
}