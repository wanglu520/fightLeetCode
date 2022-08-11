class Solution {
  public String reformat(String s) {
      if(s == null || s.isEmpty()){
          return "";
      }
      int n = s.length();
      StringBuffer sb = new StringBuffer();
      StringBuffer sb1 = new StringBuffer();
      for(int i = 0; i<n; i++){
          char ch = s.charAt(i);
          if(ch >= 48 && ch <= 57){
              sb.append(ch);
          }else {
              sb1.append(ch);
          }
      }
      if(Math.abs(sb.length() - sb1.length()) > 1){
          return "";
      }
      StringBuffer res = new StringBuffer();
      if(sb.length() > sb1.length()){
          res.append(sb.charAt(0));
          sb.deleteCharAt(0);
          return strJoin(res, sb1, sb);
      }else if(sb.length() < sb1.length()){
          res.append(sb1.charAt(0));
          sb1.deleteCharAt(0);
          return strJoin(res, sb, sb1);
      }
      return strJoin(res, sb, sb1);
  }
  public String strJoin(StringBuffer res, StringBuffer sb, StringBuffer sb1){
      for(int i=0; i<sb.length(); i++){
          res.append(sb.charAt(i));
          res.append(sb1.charAt(i));
      }
      return res.toString();
  }
}