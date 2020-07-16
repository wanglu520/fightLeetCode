class Solution {
    //数组最后一个元素加1，小于10直接返回，大于等于10，向左移一位加1
    public int[] plusOne(int[] digits) {
        int len = digits.length -1;
        int num = 0;
        int plusOne = 1;
        for(int i = len; i>=0; i--){
            int temp = digits[i] + plusOne + num;
            plusOne = 0;
            if(temp < 10){
                digits[i] = temp;
                return digits;
            }else {
                num = 1;
                digits[i] = temp % 10;
            }
        }
        //如果循环结束还需要向前进一位，创建一个新数组，第一个元素为1，拷贝之前数组所有数据到新数组
        int[] res = new int[len+2];
        if(num == 1){
            res[0] = 1;
            System.arraycopy(digits,0, res, 1, len+1);
        }
        return res;
    }
}