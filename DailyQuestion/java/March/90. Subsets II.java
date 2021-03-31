package DailyQuestion.java.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      backTrace(nums, 0, new ArrayList<>());
      return res;
  }
  //回溯
  public void backTrace(int[] nums, int index, List<Integer> temp){
      res.add(new ArrayList<>(temp));
      for(int i=index; i<nums.length; i++){
          //去掉相邻相同的数
          if(i != index && nums[i] == nums[i-1]){
              continue;
          }
          temp.add(nums[i]);
          backTrace(nums, i+1, temp);
          temp.remove(temp.size()-1);
      }
  }
}