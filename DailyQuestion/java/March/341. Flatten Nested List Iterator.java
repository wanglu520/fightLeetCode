package DailyQuestion.java.March;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
//深度优先搜索遍历list
class NestedIterator implements Iterator<Integer> {

  private List<Integer> list;
  private Iterator<Integer> cur;
  public NestedIterator(List<NestedInteger> nestedList) {
      list = new ArrayList<>();
      dfs(nestedList);
      cur = list.iterator();
  }
  @Override
  public Integer next(){
      return cur.next();
  }
  @Override
  public boolean hasNext(){
      return cur.hasNext();
  }
  private void dfs(List<NestedInteger> nestedList){
      for(NestedInteger nested : nestedList){
          if(nested.isInteger()){
              list.add(nested.getInteger());
          }else {
              dfs(nested.getList());
          }
      }
  }
}

/**
* Your NestedIterator object will be instantiated and called as such:
* NestedIterator i = new NestedIterator(nestedList);
* while (i.hasNext()) v[f()] = i.next();
*/