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
    //二分查找
    public int minArray1(int[] numbers) {
        int start = 0;
        int end = numbers.length-1;
        while (start <= end){
            int mid = (end - start)/2 + start;
            //如果最右边大于中间的数，说明最小的在左边区域
            if(numbers[mid] < numbers[end]){
                end = mid;
            }else if(numbers[mid] > numbers[end]){//中间大于最右边，说明旋转过。最小值在右边区域
                start = mid+1;
            }else {//如果相同，区分不了最小区域在哪边，最右边为无用值，最右边向左移动一位；
                end--;
            }
        }
        return numbers[start];
    }
}