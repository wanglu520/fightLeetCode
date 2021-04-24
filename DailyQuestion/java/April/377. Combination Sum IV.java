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
  //背包组合
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
        for (int num : nums) {
            if (num <= i) {
                dp[i] += dp[i - num];
            }
        }
    }
    return dp[target];
}
}