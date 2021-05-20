/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
 var topKFrequent = function(words, k) {
   const map = new Map();
   for(const word of words){
     map.set(word, (map.get(word)||0)+1);
   }
   const arr = [];
   for(const str of map.keys()){
     arr.push(str);
   }
   arr.sort((word1, word2)=>{
     return map.get(word1) === map.get(word2) ? word1.localeCompare(word2) : map.get(word2) - map.get(word1);
   })
   return arr.slice(0, k);
};