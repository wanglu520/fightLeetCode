package DailyQuestion.java;
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int len = nums.length;
        int count = 1;
        for(int i=0; i<len; count++){
            if(nums[i] + i + 1 >= len){
                return count;
            }
            int maxNum = -1;
            int num = nums[i];
            int index = i;
            for(int j=1; j <= num;j++){
                if(nums[index+j] + index + j + 1 >= len){
                    count++;
                    return count;
                }
                if(maxNum <= (nums[j+index] + j+index)){
                    maxNum = nums[j+index] + j+index;
                    i=j+index;
                }
            }
        }
        return count;
    }

    public int jump1(int[] nums) {
        int len = nums.length;
        int maxSteps = 0;
        int steps = 0;
        int end = 0;
        for(int i=0; i< len - 1; i++){
            maxSteps = Math.max(maxSteps, i + nums[i]);
            if(i == end){
                end = maxSteps;
                steps++;
            }
        }
        return steps;
    }
}