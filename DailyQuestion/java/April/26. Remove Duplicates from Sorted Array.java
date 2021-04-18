package DailyQuestion.java.April;
class Solution {
  public int removeDuplicates(int[] nums) {
      if(nums == null || nums.length == 0){
          return 0;
      }
      int index=1;
      for(int i=0; i<nums.length - 1; i++){
          if(nums[i] != nums[i+1]){
              if(index != i+1){//避免原地复制
                  nums[index] = nums[i+1];
              }
              index++;
          }
      }
      return index;
  } 
}