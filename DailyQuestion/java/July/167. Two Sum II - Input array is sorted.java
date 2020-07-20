package DailyQuestion.java.July;

//暴力解
class Solution {
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
}