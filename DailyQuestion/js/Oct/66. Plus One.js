/**
 * @param {number[]} digits
 * @return {number[]}
 */
 var plusOne = function(digits) {
  const len = digits.length - 1;
  for(let i = len; i >= 0; i--){
      if(digits[i] !== 9){
          digits[i]++;
          return digits;
      }else{//为9，9+1=10需要往前+1
          digits[i] = 0;
      }
  }
  //全部为9，进一位
  const arr = new Array(len+2).fill(0);
  arr[0] = 1;
  return arr;
};
