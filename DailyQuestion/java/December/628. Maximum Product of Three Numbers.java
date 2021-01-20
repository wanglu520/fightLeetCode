package DailyQuestion.java.December;

import java.util.Arrays;

class Solution {
  //负负得正需要考虑最小两个数和最大数的乘积
  public int maximumProduct(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
  }
}