/**
 * @param {number[]} arr
 * @return {number}
 */
  //暴力
 var sumOddLengthSubarrays = function(arr) {
  const len = arr.length;
  let sum=0, left;
  for(let i=0; i<len; i+=2){
      left = 0;
      for(let j=i+1; j<=len; j++){
          sum += add(arr.slice(left++, j))
      }
  }
  return sum;
};
//前缀和
var sumOddLengthSubarrays = function(arr) {
  const len = arr.length;
  const preSums  = [0];
  //计算前缀和
  for(let i=0; i<len; i++){
    preSums[i+1] = preSums[i] + arr[i];
  }
  let sum=preSums[len], start;
  for(let i=2; i<len; i+=2){
      start = 0;
      for(let j=i+1; j<=len; j++){
          //通过前缀和计算数组和
          sum += preSums[j] - preSums[start++];
      }
  }
  return sum;
};
/**
* @param {number[]} arr
* @return {number}
*/
const add = (arr)=>{
  let res = 0;
  for(let temp of arr){
      res += temp;
  }
  return res;
}