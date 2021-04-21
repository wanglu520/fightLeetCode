class Solution {
  public int numDecodings(String s) {
      if(s == null || s.length() == 0){
          return 0;
      }
      int n = s.length();
      //f(n) = f(n-1) + f(n-2)
      int a = 0, b = 1, c = 0;
      for (int i = 1; i <= n; ++i) {
          c = 0;
          if (s.charAt(i - 1) != '0') {
              c += b;
          }
          if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
              c += a;
          }
          a = b;
          b = c;
      }
      return c;
  }
}