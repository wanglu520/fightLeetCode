/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if(!nums  || nums.length === 0){
        return -1;
    }
    if(nums.length === 1){
        return nums[0] === target ?0:-1;
    }
    return find(nums,0, nums.length-1, target);
};
var find = function(nums, l, r, target){
    if(l >= r){return -1;}
    if(nums[l] === target){return l;}
    if(nums[r] === target){return r;}
    let mid = (l+r)>>1;
    if(nums[mid] === target){
        return mid;
    }else if(nums[mid] > nums[l]){
        if(target < nums[mid] && target > nums[l]){
            return find(nums, l, mid-1, target);
        }else{
            return find(nums, mid+1, r, target);
        }
    }else{
        if(target<nums[r] && nums[mid] < target){
            return find(nums, mid+1, r, target);
        }else{
            return  find(nums, l, mid-1, target);
        }
    }
}