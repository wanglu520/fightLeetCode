class Solution {
  public int[] shuffle(int[] nums, int n) {
      int[] res = new int[n*2];
      int len = n;
      for(int i=0, index = 0; i<len; i++){
          res[index++] = nums[i];
          res[index++] = nums[n++];
      }
      return res;
  }
}