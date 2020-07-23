package DailyQuestion.java.July;

class Solution {
    //每个数都面临左边和上边的选择，（第一行只有左边和第一列只有上边）
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int x = grid[0].length, y = grid.length;
        //创建一个合原数组一样大的数组，记录可选择的数相加最小的值
        int[][] dp = new int[y][x];
        dp[0][0] = grid[0][0];
        //第一行
        for(int i=1; i<x; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //第一列
        for(int j=0; j<y; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        //上边与左边最小的数与原位置的相加为最小路径
        for(int i=1; i<y; i++){
            for(int j=1; j<x; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[y-1][x-1];
    }
}