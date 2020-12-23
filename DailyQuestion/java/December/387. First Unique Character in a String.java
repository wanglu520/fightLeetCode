class Solution {
  //从前往后与从后往前是相同位置
  public int firstUniqChar(String s) {
      for(int i=0; i<s.length(); i++){
          int index = s.charAt(i);
          if(s.lastIndexOf(index) == s.indexOf(index)){
              return i;
          }
      }
      return -1;
  }
}