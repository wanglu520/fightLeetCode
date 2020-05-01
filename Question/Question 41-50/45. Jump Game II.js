/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if(nums.length === 1){return 0;}
    myNums =nums.map((v,k)=>v+k);
    let index=1;
    let len = nums.length-1;
    if(len === 0){return 0;}
    for(let i=0; i<len;){
        if(nums[i] + i >= len){
            break;
        }
        i+=Math.max.apply(null,myNums.slice(i+1,i+nums[i]+1).concat([0]));
        index++;
    }
    return index;
};
  
console.log(jump([1,2,3]))
console.log(jump([2,3,1,1,4]))
console.log(jump([1,1,1,1]))
console.log(jump([1,1,1,1]))