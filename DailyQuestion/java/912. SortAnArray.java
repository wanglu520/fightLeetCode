package DailyQuestion.java;
import java.util.Arrays;

class SortAnArray {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortArraya(int[] nums){
        if(nums.length < 2){return nums;}
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return helper(sortArraya(left), sortArraya(right));
    }

    private int[] helper(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int l = 0, r = 0;
        for(int i = 0; i < result.length; i++){
            if(l >= left.length){
                result[i] = right[r++];
            }else if(r >= right.length){
                result[i] = left[l++];
            }else if (left[l] > right[r]){
                result[i] = right[r++];
            }else{
                result[i] = left[l++];
            }
        }
        return result;
    }

}