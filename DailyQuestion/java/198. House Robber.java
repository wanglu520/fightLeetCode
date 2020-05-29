package DailyQuestion.java;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int first = 0;
        int second = nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}