class Solution {
  private Boolean[][] rec;
    //cv....
  public boolean canCross(int[] stones) {
      int n = stones.length;
      rec = new Boolean[n][n];
      return dfs(stones, 0, 0);
  }

  private boolean dfs(int[] stones, int i, int lastDis) {
      if (i == stones.length - 1) {
          return true;
      }
      if (rec[i][lastDis] != null) {
          return rec[i][lastDis];
      }

      for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
          if (curDis > 0) {
              int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
              if (j >= 0 && dfs(stones, j, curDis)) {
                  return rec[i][lastDis] = true;
              }
          }
      }
      return rec[i][lastDis] = false;
  }
}
