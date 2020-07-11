package DailyQuestion.java.July;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //暴力
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count;
        for(int i=0; i<nums.length; i++){
            count = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]) count++;
            }
            res.add(count);
        }
        return res;
    }
}