class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        //return Arrays.stream(nums).filter(value -> value != val).toArray().length;
        for(int i=0; i<len; i++){
            if(nums[i] == val){
                System.arraycopy(nums,i+1,nums,i,nums.length-i-1);
                i--;
                len--;
            }
        }
        return len;
    }
}