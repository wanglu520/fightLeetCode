/**
 * @param {number[]} arr
 * @return {number}
 */
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