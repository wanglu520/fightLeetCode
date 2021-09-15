/**
 * @param {number[]} nums
 * @return {number}
 */
//nums[i] != nums[i+1],如果i不满足，那么满足的一定在上坡趋势的方向（nums[i]>nums[i+1]往左，num[i]<num[i+1]往右）
//上升趋势是有序的，可以用二分搜索
 var findPeakElement = function(nums) {
  let left = 0,right = nums.length - 1;
  while(left < right){
      const mid = (right - left)/2|0 + left;
      if(nums[mid] > nums[mid + 1]){
          right = mid;
      }else{
          left = mid + 1;
      }
  }
  return left;
};
