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
}