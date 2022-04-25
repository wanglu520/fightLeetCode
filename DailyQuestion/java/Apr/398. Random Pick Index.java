class Solution {
  Map<Integer, List<Integer>> map;
  Random random;
  public Solution(int[] nums) {
      map = new HashMap();
      random = new Random();
      int len = nums.length;
      for(int i=0; i<len; i++){
          map.putIfAbsent(nums[i], new ArrayList<>());
          map.get(nums[i]).add(i);
      }
  }

  public int pick(int target) {
      List<Integer> list = map.get(target);
      return list.get(random.nextInt(list.size()));
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(nums);
* int param_1 = obj.pick(target);
*/