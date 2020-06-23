class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxSub = nums[0];
        for(int num : nums){
            pre = Math.max(pre+num, num);
            maxSub = Math.max(pre, maxSub);
        }
        return maxSub;
    }
}