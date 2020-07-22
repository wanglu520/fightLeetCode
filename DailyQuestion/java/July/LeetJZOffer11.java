package DailyQuestion.java.July;

class Solution {
    //从后往前遍历数组，当前一个比当前大时，跳出循环
    //竟然双100
    public int minArray(int[] numbers) {
        int len = numbers.length-1;
        int res = numbers[len];
        for(int i=len-1; i>=0; i--){
            if(numbers[i] <= res){
                res = numbers[i];
            }else {
                break;
            }
        }
        return res;
    }
}