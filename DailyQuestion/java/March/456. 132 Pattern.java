package DailyQuestion.java.March;

import java.util.TreeMap;

class Solution {
  //一个个遍历
  public boolean find132pattern(int[] nums) {
      if(nums == null || nums.length < 3){
          return false;
      }
      int len = nums.length;
      int s, m;
      for(int i=0; i<len; i++){
          s=nums[i];
          for(int j=i+1; j<len; j++){
              if(s < nums[j]){
                  m=nums[j];
                  for (int k=j+1; k<len; k++){
                      if(s < nums[k] && nums[k] < m){
                          return true;
                      }
                  }
              }
          }
      }
      return false;
  }
  //枚举
  public boolean find132pattern1(int[] nums) {
    int n = nums.length;
    if (n < 3) {
        return false;
    }

    // 左侧最小值
    int leftMin = nums[0];
    // 右侧所有元素
    TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

    for (int k = 2; k < n; ++k) {
        rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
    }

    for (int j = 1; j < n - 1; ++j) {
        if (leftMin < nums[j]) {
            Integer next = rightAll.ceilingKey(leftMin + 1);
            if (next != null && next < nums[j]) {
                return true;
            }
        }
        leftMin = Math.min(leftMin, nums[j]);
        rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
        if (rightAll.get(nums[j + 1]) == 0) {
            rightAll.remove(nums[j + 1]);
        }
    }

    return false;
  }
}