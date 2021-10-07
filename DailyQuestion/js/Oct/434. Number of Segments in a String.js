/**
 * @param {string} s
 * @return {number}
 */
 var countSegments = function(s) {
  if(s.length === 0) return 0;
  const arr = s.split(" ");
  let count = 0;
  for(let str of arr){
      if(str){
          count++;
      }
  }
  return count;
};