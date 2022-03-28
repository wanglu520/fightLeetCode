/**
 * @param {number} n
 * @return {boolean}
 */
 var hasAlternatingBits = function(n) {
  const strs = n.toString(2);
  let temp = '-1';
  for(let str of strs){
      if(temp === str){
          return false;
      }
      temp = str;
  }
  return true;
};

/**
 * @param {number} n
 * @return {boolean}
 */
 var hasAlternatingBits = function(n) {
  const a = n ^ (n >> 1);
  return (a & (a + 1)) === 0;
};