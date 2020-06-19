class Solution {
    public void rotate(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        boolean[][] bH = new boolean[h][w];
        int midW = w>>1;
        //先对角调换位置。避免重复调换已调换过的做标记
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(bH[i][j]){
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                //已调换的做标记
                bH[i][j] = true;
                bH[j][i] = true;
            }
        }
        //再进行对折，可得旋转后的数组
        for(int i = 0; i<midW; i++){
            for(int j=0; j<h; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][h-1-i];
                matrix[j][h-1-i] = temp;
            }
        }
    }
}