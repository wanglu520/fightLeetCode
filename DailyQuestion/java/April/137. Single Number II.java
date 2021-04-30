class Solution {
  public int singleNumber(int[] nums) {
      long arrSum=0;
      long setSum=0;
      Set<Integer> set = new HashSet<>();
      for(int num : nums){
          arrSum += num;
          set.add(num);
      }
      for(Integer num : set){
          setSum += num;
      }
      return (int)(3*setSum - arrSum)/2;
  }
  //HashMap
  public int singleNumber1(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums){
          map.put(num,map.getOrDefault(num,0)+1);
      }
      for(int key : map.keySet()){
          if(map.get(key) == 1){
              return key;
          }
      }
      return -1;
  }
  //NOT，AND 和 XOR
  public int singleNumber2(int[] nums){
      int seen_once = 0;
      int seen_twice = 0;
      for(int num : nums){
          seen_once = ~seen_twice & (seen_once ^ num);
          seen_twice = ~seen_once & (seen_twice ^ num);
      }
      return seen_once;
  }
  //
  public int[] singleNumber3(int[] nums){
      int xorNum = 0;
      //求得两个只出现一次数的异或值
      for(int num : nums){
          xorNum ^= num;
      }
      //找到两个数位的掩码不相同的
      int diffNum = 1;
      while ((xorNum & diffNum) == 0){
          diffNum <<= 1;
      }
      int[] res = {0,0};
      for(int num : nums){
          if((num & diffNum) == 0){
              res[0] ^= num;
          }else {
              res[1] ^= num;
          }
      }
      return res;
  }
}