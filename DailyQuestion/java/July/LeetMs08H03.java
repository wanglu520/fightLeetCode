package DailyQuestion.java.July;

class Solution {
    public int findMagicIndex(int[] nums) {
        int res = -1;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == i){
                return i;
            }
        }
        return res;
    }
}