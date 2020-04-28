package DailyQuestion.java;
class Solution {
    //数组排序相邻不相同保留
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int index = 0;
        for(int i=0; i<nums.length;){
            if(i == nums.length -1){
                res[index] = nums[i];
                break;
            }
            if(nums[i] == nums[i+1]){
                i += 2;
            }else {
                res[index++] = nums[i];
                i++;
            }
            if(index == 2){
                break;
            }
        }
        return res;
    }
}