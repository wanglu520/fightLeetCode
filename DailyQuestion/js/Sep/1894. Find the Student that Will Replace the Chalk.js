/**
 * @param {number[]} chalk
 * @param {number} k
 * @return {number}
 */
//假设数组[1,2,7]和为10，那么1、11、21..这些取模为1的数都落在索引1上，
//所以只需要计算k%数组一个循环总消耗数的余数
 var chalkReplacer = function(chalk, k) {
  let sum = chalk.reduce((a, b)=> a+b, 0);
  let index = 0;
  let num = k % sum;
  while(true){
      num -= chalk[index];
      if(num < 0){
          return index;
      }
      index++;
  }
};
//取模然后通过前缀和+二分
var chalkReplacer = function(chalk, k) {
  const len = chalk.length;
  if(chalk[0] > k) return 0;
  for(let i=1; i<len; i++){
    chalk[i] += chalk[i-1];
    if(chalk[i] > k){
      return i;
    }
  }
  k %= chalk[len-1];
  return binarysearch(chalk, k);
};
const binarysearch = function(arr, k){
  let left = 0, right = arr.length;
  while(left <= right){
    const mid = (right - left)/2|0 + left;
    if(k >= arr[mid]){
      left = mid + 1;
    }else{
      right = mid - 1;
    }
  }
  return left;
}