package DailyQuestion.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || matrix[newX][newY] != -1){
                    continue;
                }
                matrix[newX][newY] = matrix[x][y] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        return matrix;
    }
}