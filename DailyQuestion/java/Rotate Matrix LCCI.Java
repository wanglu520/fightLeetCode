class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        int[][] newMa = new int[y][x];
        for(int i = 0; i < x; i++){
            int[] tempArr = new int[x];
            int index = 0;
            for(int j = y-1; j>=0; j--){
                tempArr[index++] = matrix[j][i];
            }
            newMa[i] = tempArr;
        }
        for(int i = 0; i < newMa.length; i++){
            matrix[i] = newMa[i];
        }
    }
}