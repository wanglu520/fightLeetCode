package DailyQuestion.java;
class Solution {
    public int waysToChange(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] temps = {1,5,10,25};
        for(int temp : temps){
            for(int j = temp; j<=n;j++){
                dp[j] =  (dp[j] + dp[j-temp]) % 1000000007;
            }
        }
        return dp[n];
    }
}