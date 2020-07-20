package DailyQuestion.java.July;


class Solution {
    //双指针。一个指向第一个值，另一个指向最后一个值，两个数和大于target，最后一个指针向左移一位；
    //小于target第一个指针向右移一位；等于直接返回
    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        int start = 0, end = len - 1;
        while (start < end){
            if(numbers[start] + numbers[end] == target){
                return new int[]{start+1, end+1};
            }else if(numbers[start] + numbers[end] > target){
                end--;
            }else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
    //暴力解
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i == j){
                    continue;
                }
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[0];
    }
    //二分查找target - numbers[i]的值
    public int[] twoSum1(int[] numbers, int target) {
        int len = numbers.length;
        for(int i=0; i<len; i++){
            int start = i+1, end = len-1;
            while (start<=end){
                int mid = (end - start)/2 + start;
                int temp = target - numbers[i];
                if(numbers[mid] == temp){
                    return new int[]{i+1, mid+1};
                }else if(numbers[mid] > temp){
                    end = mid -1;
                }else {
                    start = mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}