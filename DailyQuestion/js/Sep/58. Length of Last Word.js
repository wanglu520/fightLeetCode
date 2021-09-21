/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLastWord = function(s) {
  let count = 0;
  for(let l = s.length-1; l >=0; l--){
      if(s[l] === " " && count > 0){
          break;
      }
      if(s[l] !== " ") count++;
  }
  return count;
};