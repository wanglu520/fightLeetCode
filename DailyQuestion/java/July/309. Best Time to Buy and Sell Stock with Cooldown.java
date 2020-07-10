package DailyQuestion.java.July;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int dpA = 0, dpB = Integer.MIN_VALUE, dpC = 0;
        for (int i = 0; i < len; i++) {
            int temp = dpA;
            // 记录当前日不持有股票的最大收益（之前已经卖出或者当前日卖出）。
            dpA = Math.max(dpA, dpB + prices[i]);
            // 记录当前日持有股票的最大收益（以前已经买入或者当前日买入）。
            dpB = Math.max(dpB, dpC - prices[i]);
            // 记录上一日不持有股票的最大收益。
            dpC = temp;
        }
        return dpA;
    }
}
