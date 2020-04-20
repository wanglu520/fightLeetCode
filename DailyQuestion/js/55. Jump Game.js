/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let count=0;
    let len = nums.length-1;
    if(len === 0){return true;}
    for(let i=0; i<len; i++){
        if((count=Math.max(--count,nums[i])) <=0){
            break;
        }
        if(nums[i] + i >= len){
            return true;
        }
    }
    return false;
};

console.log(canJump([2,0,0]))