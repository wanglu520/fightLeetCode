package DailyQuestion.java;
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int num : nums){
            if(num < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(num*imax, num);
            imin = Math.min(num*imin, num);
            max = Math.max(max, imax);
        }
        return max;
    }
}