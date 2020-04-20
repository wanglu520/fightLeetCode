/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
//TODO 还有bug，待修复
 var nextPermutation = function(nums) {
    let len = nums.length;
    if(nums && len > 0){
        let bool = true;
        for(let i=len-1; i>0;i--){
            if(nums[i] > nums[i-1]){
                let temp = nums[len-1];
                for(let k=len-1;k>=i;k--){
                    nums[k] = nums[k-1];
                }
                nums[i-1] = temp;
                bool = false;
                break;
            }
        }
        if(bool){
            for(let i=0;i<len;i++){
                for(let j=i+1; j<=len-i; j++){
                    if(nums[i] > nums[j]){
                        let temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                    }
                }
            } 
        }
    }
};
let n1 = [2,3,1];
nextPermutation(n1)
console.log(n1);
n1 =[3,2,1];
nextPermutation(n1)
console.log(n1);
n1 = [1,1,5];
nextPermutation(n1)
console.log(n1);
n1 = [1,2];
nextPermutation(n1)
console.log(n1);