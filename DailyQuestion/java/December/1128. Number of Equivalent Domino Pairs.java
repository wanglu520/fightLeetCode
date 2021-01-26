package DailyQuestion.java.December;

class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
      int res = 0;
      int[] nums = new int[100];
      for(int[] dominoe : dominoes){
          int val = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1]*10 + dominoe[0];
          res += nums[val];
          nums[val]++;
      }
      return res;
  }
}