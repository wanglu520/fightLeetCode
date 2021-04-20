class Solution {
  //直接遍历
  public int strStr(String haystack, String needle) {
      if(haystack == null || needle == null || haystack.length() < needle.length()){
          return -1;
      }
      if("".equals(needle) || needle.equals(haystack)){
          return 0;
      }
      int haLen = haystack.length();
      int nLen = needle.length();
      for(int i=0; i+nLen<=haLen; i++){
          boolean flag = true;
          for(int j=0; j<nLen; j++){
              if(haystack.charAt(i+j) != needle.charAt(j)){
                  flag = false;
                  break;
              }
          }
          if(flag){
              return i;
          }
      }
      return -1;
  }
}