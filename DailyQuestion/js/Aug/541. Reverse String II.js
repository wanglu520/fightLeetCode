/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
 var reverseStr = function(s, k) {
  const arr = [...s];
  const len = arr.length;
  for(let i=0; i<len; i += 2*k){
    reverse(arr, i, Math.min(i+k, len) - 1);
  }
  return arr.join("");
};

const reverse = (arr, left, right) => {
  while(left < right){
    const temp = arr[left];
    arr[left++] = arr[right];
    arr[right--] = temp;
  }
}