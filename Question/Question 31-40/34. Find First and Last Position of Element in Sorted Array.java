class Solution {
    public int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }
        int l = left_bound(nums, 0, nums.length-1, target);
        if(l == -1){
            return new int[]{-1,-1};
        }
        int r = right_bound(nums, 0, nums.length-1, target);
        return new int[]{l, r};

    }
    private int left_bound(int[] nums, int l, int r, int target){
        while (l <= r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        if(l >= nums.length || nums[l] != target){
            return -1;
        }
        return l;
    }
    private int right_bound(int[] nums, int l, int r, int target){
        while (l <= r){
            int mid = l + ((r-l)>>1);
            if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else {
                l = mid + 1;
            }
        }
        if(r >= nums.length || nums[r] != target){
            return -1;
        }
        return r;
    }
}