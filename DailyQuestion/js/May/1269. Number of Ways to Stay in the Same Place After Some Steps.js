var numWays = function(steps, arrLen) {
  const MODULO = 1000000007;
  let maxColumn = Math.min(arrLen - 1, steps);
  const dp = new Array(steps + 1).fill(0).map(() => new Array(maxColumn + 1).fill(0));
  dp[0][0] = 1;
  for (let i = 1; i <= steps; i++) {
      for (let j = 0; j <= maxColumn; j++) {
          dp[i][j] = dp[i - 1][j];
          if (j - 1 >= 0) {
              dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
          }
          if (j + 1 <= maxColumn) {
              dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
          }
      }
  }
  return dp[steps][0];
};
