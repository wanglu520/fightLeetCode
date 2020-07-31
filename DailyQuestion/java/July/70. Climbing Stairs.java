package DailyQuestion.java.July;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //回溯+剪枝（去掉大于2的）
    //超时。。。
    public int climbStairs(int n) {
        Map<String,Integer> map = new HashMap<>();
        map.put("count",0);
        int sum = 0;
        backtrack(map, sum, n);
        return map.get("count");
    }
    public void backtrack(Map<String,Integer> map, int sum, int n){
        if(sum == n){
            map.put("count",map.get("count")+1);
            return;
        }
        for(int i=1; i<=n; i++){
            sum += i;
            if(sum > n || i>2){
                break;
            }
            backtrack(map, sum, n);
            sum -= i;
        }
    }
}