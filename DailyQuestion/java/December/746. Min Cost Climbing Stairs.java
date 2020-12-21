class Solution {
  //创建数组dp 记录走一步或者两步的最小体力
  public int minCostClimbingStairs(int[] cost) {
      int len = cost.length;
      int[] dp = new int[len+1];
      for(int i=2; i<=len; i++){
          dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
      }
      return dp[len];
  }
}

