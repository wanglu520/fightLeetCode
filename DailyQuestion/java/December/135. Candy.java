import java.util.Arrays;

class Solution {
  public int candy(int[] ratings) {
      int len = ratings.length;
      int[] left = new int[len];
      int[] right = new int[len];
      Arrays.fill(left,1);
      Arrays.fill(right,1);
      for(int i = 1; i<len; i++){
          if(ratings[i] > ratings[i-1]) left[i] += left[i-1];
      }
      int count = left[len - 1];
      for(int i = len-2; i>=0 ;i--){
          if(ratings[i] > ratings[i+1]) right[i] += right[i+1];
          count += Math.max(left[i], right[i]);
      }
      return count;
  }
}