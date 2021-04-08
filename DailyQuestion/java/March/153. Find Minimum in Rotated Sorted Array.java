package DailyQuestion.java.March;

import java.util.Arrays;

class Solution {
  //通过二分搜索
  public int findMin(int[] nums) {
      int start = 0, end = nums.length-1;
      while (start < end){
          int mid = start + (end - start)/2;
          //如果mid>end,最小值一点在mid右边区域
          if(nums[mid] > nums[end]){
              start = mid+1;
          }else {
              end = mid;
          }
      }
      return nums[start];
  }
  //简单粗暴直接排序
  public int findMin1(int[] nums) {
    Arrays.sort(nums);
    return nums[0];
  }
}