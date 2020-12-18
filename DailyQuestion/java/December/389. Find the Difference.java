package DailyQuestion.java.December;

class Solution {
  //通过相同数字异或为0，找到多出的那个
  public char findTheDifference(String s, String t) {
      int len = s.length();
      char diff = t.charAt(len);
      for(int i=0; i<len; i++){
          diff ^= s.charAt(i) ^ t.charAt(i);
      }
      return diff;
  }
}