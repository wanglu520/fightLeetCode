package DailyQuestion.java;
class Solution {
    /** *
     * @param nums
     * @return
     * 第一次循环保存索引前面的数的积,最后一个索引保存自己的值；
     * [1,2,3,4，5] ——> 记录为[1,2,6,24,5]
     * 第二次从后往前循环，除自己外其余各元素的乘积等于索引前一位的值乘以后一位的值
     * 头尾的乘积分别等于后一位和前一位的值
     * 
     * res[0] = product[1], res[len] = product[len-1];
     * 
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];
        int product[] = new int[len];
        for(int i=0; i<len; i++){
            if(i==0 || i==len-1) {
                product[i]=nums[i];
            }else {
                product[i] = product[i-1] * nums[i];
            }
        }
        for(int j=len -1; j>=0;j--){
            if(j==len-1){
                res[j] = product[j-1];
            }else if(j==0){
                res[j] = product[j+1];
            } else {
                res[j] = product[j-1] * product[j+1];
                product[j] = nums[j] * product[j+1];
            }
        }
        return  res;
    }
    /**
     * @param nums
     * @return
     * 返回数组不记录空间
     * 空间复杂度为o(1)的 第一次循环通过返回数组保存索引前面的数的积， 第二次通过一个变量每次循环时保存右边的乘积
     */
    public int[] productExceptSelf0(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1]; 
        }
        int r = 1;
        for(int j = nums.length-1; j>=0; j--){
            res[j] *= r;
            r *= nums[j];  
        }
        return res;
    }
    /**
     * 暴力
     * 
     */
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i==0){
                    res[j] = i==j ? nums[j] == 0 ? 0 : 1  : nums[i];
                }else {
                    res[j] = i==j ? res[j] : res[j]*nums[i];
                }

            }
        }
        return res;
    }
}