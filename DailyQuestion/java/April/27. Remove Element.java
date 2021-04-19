class Solution {
  //双指针，start指向val，end从后往前指向非val的
  public int removeElement(int[] nums, int val) {
      int start = 0;
      int end = nums.length - 1;
      while (start <= end){
          while (end >= 0 && nums[end] == val){
              end--;
          }
          while (start <= end && nums[start] != val){
              start++;
          }
          if(start <= end){
              nums[start] = nums[end];
              start++;
              end--;
          }
      }
      return start;
  }
  public int removeElement1(int[] nums, int val) {
    int len = nums.length;
    int index=0;//记录val的索引
    for(int i=0; i<len; i++){
        if(nums[i] != val){//把不为val的值，替换val
          if(i != index){//避免自己替换自己
            nums[index] = nums[i];
          }
          index++;
        }
    }
    return index;
}
}