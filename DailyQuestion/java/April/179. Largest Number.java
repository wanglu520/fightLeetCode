package DailyQuestion.java.April;

import java.util.Arrays;
class Solution {
  public String largestNumber(int[] nums) {
      int len = nums.length;
      if(len == 0){
          return "";
      }
      String[] strs = new String[len];
      for(int i=0; i<len; i++){
          strs[i] = String.valueOf(nums[i]);
      }
      //排序[2,44]=>442 > 244 所以[44,2]  
      Arrays.sort(strs,(a,b)->{
          return (b+a).compareTo(a+b);
      });
      if("0".equals(strs[0])){
          return "0";
      }
      StringBuilder sb = new StringBuilder();
      for(int j=0; j<len; j++){
          sb.append(strs[j]);
      }
      return sb.toString();
  }
}