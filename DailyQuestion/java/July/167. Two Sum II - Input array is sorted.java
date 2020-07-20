package DailyQuestion.java.July;


class Solution {
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