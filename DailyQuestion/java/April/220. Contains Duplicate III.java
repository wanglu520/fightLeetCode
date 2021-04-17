package DailyQuestion.java.April;

import java.util.TreeSet;

class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //k或t不能为负数
      if(k<0 || t<0){
          return false;
      }
      TreeSet<Long> set = new TreeSet<>();
      for(int i=0; i<nums.length; i++){
          //设x1=x，那么x2取值范围为[x-t, x+t]范围
          //集合中比x-t大的最小值，必定要满足小于等于x+t
          Long c = set.ceiling((long)nums[i] - (long)t);
          if(c != null && c<=((long)nums[i]+(long)t)){
              return true;
          }
          set.add((long) nums[i]);
          //保证在k个范围内
          if(i >= k){
              set.remove((long)nums[i-k]);
          }
      }
      return false;
  }
}