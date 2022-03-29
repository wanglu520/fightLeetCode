/**
 * @param {string} answerKey
 * @param {number} k
 * @return {number}
 */
 var maxConsecutiveAnswers = function(answerKey, k) {
  return Math.max(maxConsecutiveChar(answerKey, k, "T"), maxConsecutiveChar(answerKey, k, "F"));
};

const maxConsecutiveChar = (key, k, ch) => {
  const len = key.length;
  let ans = 0;
  for(let left = 0, right = 0, sum = 0; right < len; right++){
      sum += key[right] !== ch ? 1 : 0;
      while(sum > k){
          sum -= key[left++] !== ch ? 1 : 0; 
      }
      ans = Math.max(ans, right - left + 1);
  }
  return ans;
}