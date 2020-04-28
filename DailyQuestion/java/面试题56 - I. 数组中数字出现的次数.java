package DailyQuestion.java;

import java.util.Arrays;

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
    /**
     * 1.先按位抑或 得没有重复两个数的抑或值
     * 2.找到这两个数二进制相同位置不同值的位置
     * 3.通过这个位置把这两个数分道不同的组
     * */
    public int[] singleNumbers1(int[] nums) {
        int orNum = 0;
        for(int num : nums){
            orNum ^= num;
        }
        int diff = 1;
        while ((diff & orNum) == 0){
            diff <<= 1;
        }
        int a = 0;
        int b = 0;
        for(int num : nums){
            if((diff & num)==0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}