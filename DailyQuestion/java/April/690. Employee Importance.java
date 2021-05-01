/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
  public int getImportance(List<Employee> employees, int id) {
      int res = 0;
      Queue<Integer> queue = new LinkedList<>();
      queue.add(id);
      Map<Integer, Employee> map = new HashMap<>();
      //转化为hash表
      for(Employee em : employees){
          map.put(em.id, em);
      }
      //通过队列
      while (!queue.isEmpty()){
          int emId = queue.poll();
          Employee tempEm = map.get(emId);
          if(tempEm != null){
              res += tempEm.importance;
              queue.addAll(map.get(emId).subordinates);
          }
      }
      return res;
  }
  Map<Integer, Employee> map = new HashMap<>();
  //dfs
  public int getImportance1(List<Employee> employees, int id) {
      Map<Integer, Employee> map = new HashMap<>();
      for(Employee em : employees){
          map.put(em.id, em);
      }
      return dfs(id);
  }
  public int dfs(int id){
      Employee em = map.get(id);
      int total = em.importance;
      List<Integer> subordinates = em.subordinates;
      for(int subId : subordinates){
          total += dfs(subId);
      }
      return total;
  }
}