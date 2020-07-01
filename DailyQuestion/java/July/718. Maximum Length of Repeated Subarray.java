package DailyQuestion.java.July;

class Solution {
    //暴力解法
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int res = 0;
        for(int i=0; i<lenA; i++){
            for(int j=0; j<lenB; j++){
                int index = 0;
                int count = 0;
                while (i+index<lenA && j+index<lenB && A[i+index] == B[j+index]){
                    count++;
                    index++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}