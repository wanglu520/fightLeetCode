package DailyQuestion.java.December;

import java.util.ArrayList;
import java.util.List;

class Solution {
  //注意跳出循环需要判断最后一组是不是符合要求
  public List<List<Integer>> largeGroupPositions(String s) {
      List<List<Integer>> lists = new ArrayList<>();
      int len = s.length();
      if(s == null || len < 2){
          return lists;
      }
      int startIndex = 0;
      char start = s.charAt(startIndex);
      for(int i = 1; i<len; i++){
          if(start != s.charAt(i)){
              if(i - startIndex >= 3){
                  List<Integer> list = new ArrayList<>();
                  list.add(startIndex);
                  list.add(i-1);
                  lists.add(list);
              }
              startIndex = i;
              start = s.charAt(i);
          }
      }
      if(len - startIndex >= 3){
          List<Integer> list = new ArrayList<>();
          list.add(startIndex);
          list.add(len-1);
          lists.add(list);
      }
      return lists;
  }
}