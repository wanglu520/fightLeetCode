class OrderedStream {
  String[] stream;
  int len;
  int pre;
  public OrderedStream(int n) {
      len = n;
      pre=0;
      stream = new String[len];
  }

  public List<String> insert(int idKey, String value) {
      List<String> res = new ArrayList<>();
      stream[idKey-1] = value;
      while (pre<len && stream[pre] != null){
          res.add(stream[pre++]);
      }
      return res;
  }
}

/**
* Your OrderedStream object will be instantiated and called as such:
* OrderedStream obj = new OrderedStream(n);
* List<String> param_1 = obj.insert(idKey,value);
*/