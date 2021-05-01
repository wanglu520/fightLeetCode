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
}