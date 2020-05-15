package DailyQuestion.java;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //暴力
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            int sum = nums[i];
            int temp = i+1;
            if(sum == k){
                res++;
            }
            while (temp < len){
                sum += nums[temp];
                if(sum == k){
                    res++;
                }
                temp++;
            }
        }
        return res;
    }
    //前缀和 + 哈希表
    public int subarraySum1(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}