package DailyQuestion.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int allLen = grid.length;
        int oneLen = grid[0].length;
        int count = 0;
        for(int i=0; i < allLen; i++){
            for(int j=0; j < oneLen; j++){
                if(grid[i][j] == '1'){
                    grid[i][j]='0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        int x = temp[0];
                        int y = temp[1];
                        if(x-1 >= 0 && grid[x-1][y] == '1'){//上
                            queue.offer(new int[]{x-1,y});
                            grid[x-1][y] = 0;
                        }
                        if(x+1 < allLen && grid[x+1][y] == '1'){//下
                            queue.offer(new int[]{x+1,y});
                            grid[x+1][y] = 0;
                        }
                        if(y-1 >= 0 && grid[x][y-1]=='1'){//左
                            queue.offer(new int[]{x,y-1});
                            grid[x][y-1] = 0;
                        }
                        if(y+1 < oneLen && grid[x][y+1]=='1'){//右
                            queue.offer(new int[]{x,y+1});
                            grid[x][y+1] = 0;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}