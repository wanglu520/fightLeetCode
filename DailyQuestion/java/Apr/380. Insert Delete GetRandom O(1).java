class RandomizedSet {
  List<Integer> list;
  Map<Integer, Integer> map;
  Random random;
  public RandomizedSet() {
      list = new ArrayList<>();
      map = new HashMap<>();
      random = new Random();
  }

  public boolean insert(int val) {
      if(map.containsKey(val)){
          return false;
      }
      map.put(val, list.size());
      list.add(val);
      return true;
  }

  public boolean remove(int val) {
      if(!map.containsKey(val)){
          return false;
      }
      int index = map.get(val);
      int last = list.get(list.size() - 1);
      map.put(last, index);
      list.set(index, last);
      list.remove(list.size() - 1);
      map.remove(val);
      return true;
  }

  public int getRandom() {
      int index = random.nextInt(list.size());
      return list.get(index);
  }
}

/**
* Your RandomizedSet object will be instantiated and called as such:
* RandomizedSet obj = new RandomizedSet();
* boolean param_1 = obj.insert(val);
* boolean param_2 = obj.remove(val);
* int param_3 = obj.getRandom();
*/