package DailyQuestion.java.August;

//只有与边界O相连的才不会被包围，所以遍历找出和边界值相连的O
class Solution {
    int m,n;
    public void solve(char[][] board) {
        if(board.length > 0 && board[0].length > 0){
            m = board.length;
            n = board[0].length;
            //遍历Y轴的边界
            for(int i=0; i<m; i++){
                dfs(board, 0, i);
                dfs(board, n-1, i);
            }
            //遍历x轴的边界
            for(int j=0; j<n; j++){
                dfs(board, j, 0);
                dfs(board, j, m-1);
            }
            //未标记为R的 为被包围的
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == 'R'){
                        board[i][j] = 'O';
                    }else if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }
    public void dfs(char[][] board, int x, int y){
        if(x < 0 || x > n-1 || y < 0 || y > m-1 || board[y][x] != 'O'){
            return;
        }
        board[y][x] = 'R';
        dfs(board,x-1, y);//top
        dfs(board,x+1, y);//bottom
        dfs(board,x, y-1);//left
        dfs(board,x, y+1);//right
    }
}