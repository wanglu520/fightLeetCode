/**
 * @param {string[]} words
 * @return {string[]}
 */
 var findWords = function(words) {
  const ids = "12210111011122000010020202";
  const res = [];
  for(const word of words){
      let isRow = true;
      const rowId = ids[word[0].toLowerCase().charCodeAt() - 97];
      for(let i = 1; i < word.length; i++){
          if(ids[word[i].toLowerCase().charCodeAt() - 97] !== rowId){
              isRow = false;
              break;
          }
      }
      isRow && res.push(word);
  }
  return res;
};