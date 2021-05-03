class Solution {
  public int reverse(int x) {
      long res = 0;
      while (x != 0){
          int temp = x % 10;
          x /= 10;
          res = res * 10 + temp;
      }
      return (int) res == res ? (int)res : 0;
  }
}