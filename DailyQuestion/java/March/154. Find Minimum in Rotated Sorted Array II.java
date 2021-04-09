package DailyQuestion.java.March;

class Solution {
  public int findMin(int[] nums) {
      int start = 0, end = nums.length - 1, mid;
      if(end == 0 || nums[start] < nums[end]){
          return nums[start];
      }
      while (start < end){
          mid = start + (end - start) / 2;
          if(nums[mid] == nums[end]){//过滤相等的，要不然无法判断最小值的区间
              end--;
              continue;
          }
          //mid > end此时最小值必定在右边，mid不可能是最小值所以mid+1
          if(nums[mid] > nums[end]){
              start = mid + 1;
          }else {//mid可能是最小值，不能mid-1；
              end = mid;
          }
      }
      return nums[start];
  }
}