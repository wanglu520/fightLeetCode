import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,List<Character>> map = new HashMap<>();//y轴
        Map<Integer,List<Character>> miniMap = new HashMap<>();//3*3
        List<Character> list = new ArrayList<>();//x轴
        for(int i=0; i<9; i++){
            list.clear();
            int miniI = i / 3 * 3;
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int mini = j / 3 + miniI;
                if(!map.containsKey(j)){
                    map.put(j, new ArrayList<>());
                }
                if(!miniMap.containsKey(mini)){
                    miniMap.put(mini, new ArrayList<>());
                };
                if(list.contains(board[i][j]) || map.get(j).contains(board[i][j]) ||
                        miniMap.get(mini).contains(board[i][j])){
                    return false;
                }
                list.add(board[i][j]);
                map.get(j).add(board[i][j]);
                miniMap.get(mini).add(board[i][j]);
            }
        }
        return true;
    }
    //使用数组
    public boolean isValidSudoku1(char[][] board) {
        int[][] arrX = new int[9][10];
        int[][] arrY = new int[9][10];
        int[][] miniSudo = new int[9][10];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int index = board[i][j] - '0';
                int miniIndex = i/3*3+j/3;
                if(arrX[i][index] + arrY[j][index] + miniSudo[miniIndex][index] > 0){
                    return false;
                }
                arrX[i][index]++;
                arrY[j][index]++;
                miniSudo[miniIndex][index]++;
            }
        }
        return true;
    }
}