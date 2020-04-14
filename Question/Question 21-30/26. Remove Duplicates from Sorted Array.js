/**
 * @param {number[]} nums
 * @return {number}
 */
let removeDuplicates = function(nums) {
    let index = 1;
    for(let i = 0; i < nums.length-1; i++){
        if(nums[i] != nums[i+1]){
            nums[index++] = nums[i+1];
        }
    }
};

var removeDuplicates1 = function(nums) {
    let index = 1
    for(let i = 0 ;i<nums.length;i++){
        if(nums[i]!==nums[i+1]){
            nums[index++] = nums[i+1]
        }
    }
    return index-1
};