package DailyQuestion.java.December;
//贪心算法，只要扣除手续费能赚钱就操作
class Solution {
  public int maxProfit(int[] prices, int fee) {
      int profit = 0;
      int buy = prices[0] + fee;
      for(int i=1; i<prices.length; i++){
          int temp = prices[i] + fee;
          if(temp < buy){
              buy = temp;
          }else if(prices[i] > buy){
              profit += prices[i] - buy;
              buy = prices[i];
          }
      }
      return profit;
  }
}