class Solution {
  private int res;
  //回溯算法，超时了
  public int combinationSum4(int[] nums, int target) {
      res = 0;
      dfs(nums, target, 0);
      return res;
  }
  private void dfs(int[] nums, int target, int curNum){
      if(target <= curNum){
          if(target == curNum){
              res++;
          }
          return;
      }
      for(int i=0; i<nums.length; i++){
          curNum += nums[i];
          dfs(nums, target, curNum);
          curNum -= nums[i];
      }
  }
}