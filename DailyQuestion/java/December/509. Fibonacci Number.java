package DailyQuestion.java.December;

class Solution {
  //当n>2时，始终保留前两位的值
  public int fib(int n) {
      if(n < 2){
          return n;
      }
      int q=0, p=0, r=1;
      for (int i=2; i<=n; i++){
          q = p;
          p = r;
          r = q + p;
      }
      return r;
  }
}