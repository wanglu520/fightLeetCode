class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
      List<List<Integer>> lists = new ArrayList<>();
      Map<Integer, List<List<Integer>>> map = new HashMap<>();
      for(int i=0; i<groupSizes.length; i++){
          int n = groupSizes[i];
          List<List<Integer>> tempList = map.get(n);
          if(tempList == null){
              tempList = new ArrayList<>();
              map.put(n, tempList);
          }
          if(tempList.size() == 0){
              tempList.add(new ArrayList<Integer>());
          }
          List<Integer> list = tempList.get(tempList.size() - 1);
          if(list.size() == n){
              list = new ArrayList<Integer>();
              list.add(i);
              tempList.add(list);
          }else {
              list.add(i);
          }
      }
      for(List<List<Integer>> vals : map.values()){
          for(List<Integer> val : vals){
              lists.add(val);
          }
      }
      return lists;
  }
}