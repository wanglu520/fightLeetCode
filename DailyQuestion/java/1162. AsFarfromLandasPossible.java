package DailyQuestion.java;

import java.util.ArrayList;
import java.util.List;

class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        List<int[]> list = new ArrayList<int[]>();
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    list.add(new int[]{i,j});
                }
            }
        }
        boolean hasOcean =false;
        int[] point=null;
        while(!list.isEmpty()){
            point = list.get(0);
            list.remove(0);
            int x=point[0], y=point[1];
            for(int i=0;i<4;i++){
                int newx=x+dx[i];
                int newy=y+dy[i];
                if(newx < 0 || newx >=m || newy < 0 || newy >= n || grid[newx][newy] !=0){
                    continue;
                }
                grid[newx][newy] = grid[x][y]+1;
                list.add(new int[]{newx,newy});
                hasOcean=true;
            }
        }
        if(point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]]-1;
    }
 
}