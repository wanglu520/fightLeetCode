package DailyQuestion.java;
class Solution {
    public int trap(int[] height) {
        int count = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0 ;
        int r = height.length - 1;
        while(l < r){
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if(leftMax < rightMax){
                count += leftMax - height[l];
                l++;
            }else{
                count += rightMax - height[r];
                r--;
            }
        }
        return count;
    }
}