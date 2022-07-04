class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(arr);
      int minNum = Integer.MAX_VALUE;
      for(int left=0, right=1; right<arr.length; left++, right++){
          int num = arr[right] - arr[left];
          if(minNum >= num){
              if(minNum > num){
                  res.clear();
              }
              minNum = num;
              List<Integer> list = new ArrayList<>();
              list.add(arr[left]);
              list.add(arr[right]);
              res.add(list);
          }
      }
      return res;
  }
}