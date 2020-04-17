package DailyQuestion.java;
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length==0){return false;}
        if(nums.length == 1){return true;}
        int count = 0;
        int len = nums.length-1;
        for(int i=0; i<len;i++){
            count = Math.max(--count, nums[i]);
            if(count == 0){break;}
            if(nums[i] + i >= len){
                return true;
            }
        }
        return false;
    }
}