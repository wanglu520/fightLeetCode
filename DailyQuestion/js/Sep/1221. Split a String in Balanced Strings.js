/**
 * @param {string} s
 * @return {number}
 */
 var balancedStringSplit = function(s) {
   let res = 0, count = 0;
   for(let temp of s){
     temp === "L" ? count++ : count--;
     if(count === 0){
       res++;
     }
   }
   return res;
};