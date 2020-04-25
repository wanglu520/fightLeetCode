package DailyQuestion.java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return list;
    }
    public void backtrack(int[] nums, List<Integer>track){
        if(track.size() == nums.length){
            list.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.remove(track.size()-1);
        }
    }
}