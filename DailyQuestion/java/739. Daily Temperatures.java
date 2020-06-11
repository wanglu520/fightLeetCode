package DailyQuestion.java;
class Solution {
    //暴力
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            int temp=0;
            for(int j=i+1; j<len;j++){
                if(T[i] < T[j]){
                    temp = j -i;
                    break;
                }
            }
            res[i] = temp;
        }
        return res;
    }
}