
class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n-1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar){
            for(int i = l; i <= r; i++) res[t][i] = num++;//左到右
            t++;
            for(int i = t; i <= b; i++) res[i][r] = num++;//上到下
            r--;
            for(int i = r; i>=l; i--) res[b][i] = num++;//右到左
            b--;
            for(int i=b; i>=t; i--) res[i][l] = num++;//下到上
            l++;
        }
        return res;
    }
}