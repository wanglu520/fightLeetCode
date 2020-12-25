import java.util.Arrays;

class Solution {
  //先排序 保证拿到的饼干是当前最优的
  public int findContentChildren(int[] g, int[] s) {
      int count = 0;
      Arrays.sort(g);
      Arrays.sort(s);
      int lenG = g.length;
      int lenS = s.length;
      int j=0;
      for(int i=0; i<lenG; i++){
          if(j>= lenS){break;}
          for(;j<lenS;j++){
              if(s[j] >= g[i]){
                  count++;
                  j++;
                  break;
              }
          }
      }
      return count;
  }
}