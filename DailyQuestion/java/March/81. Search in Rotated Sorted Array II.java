package DailyQuestion.java.March;

class Solution {
  public boolean search(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
          return false;
      }
      int start = 0, end = nums.length - 1;
      while (start <= end){
          int mid = start + (end - start) / 2;
          if(nums[mid] == target || nums[start] == target || nums[end] == target){
              return true;
          }
          //过滤重复数据，要不然判断不了target在前半部分还是后半部分
          if(nums[mid] == nums[start]){
              start++;
              continue;
          }
          if(nums[mid] > nums[start]){
              if(nums[mid] > target && nums[start] < target){
                  end = mid - 1;
              }else {
                  start = mid + 1;
              }
          }else {
              if(nums[mid]<target && target < nums[end]){
                  start = mid + 1;
              }else {
                  end = mid - 1;
              }
          }
      }
      return false;
  }
}