package DailyQuestion.java.December;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  //逐位相加
  public List<Integer> addToArrayForm(int[] A, int K) {
      List<Integer> res = new ArrayList<>();
      int len = A.length - 1;
      for(int i=len; i >= 0; i--){
          int sum = A[i] + K % 10;
          K /= 10;
          if(sum >= 10){
              K++;
              sum -= 10;
          }
          res.add(sum);
      }
      for(;K>0;K/=10){
          res.add(K%10);
      }
      Collections.reverse(res);
      return res;
  }
}