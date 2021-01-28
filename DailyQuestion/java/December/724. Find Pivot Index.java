package DailyQuestion.java.December;

import java.util.Arrays;

class Solution {
  //如果满足题意那么：前+中+后 = 总和
  //已知：前=后 那么可转换成满足 2x + num[i] = total
  public int pivotIndex(int[] nums) {
      int sum = 0;
      int total = Arrays.stream(nums).sum();
      for(int i=0; i<nums.length; i++){
          if(2 * sum + nums[i] == total){
              return i;
          }
          sum += nums[i];
      }
      return -1;
  }
}