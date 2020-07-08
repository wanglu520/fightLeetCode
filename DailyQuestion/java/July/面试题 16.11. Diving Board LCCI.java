package DailyQuestion.java.July;

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){//判空
            return new int[]{};
        }
        if(shorter == longer){//shorter与longer大小相同时 只有一个结果；
            return new int[]{shorter*k};
        }
       int[] res = new int[k+1];
        for(int i = 0; i<=k; i++){
            res[i] = (i*longer + (k-i)*shorter);
        }
        return res;
    }
}