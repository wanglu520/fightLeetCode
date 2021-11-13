/**
 * @param {string} word
 * @return {boolean}
 */
//三种情况为true，1全部为大写；2、全部小写；3、第一个大写其它小写
 var detectCapitalUse = function(word) {
  let upNum = 0, lowNum = 0;
  for(const str of word){
      if(str === str.toUpperCase()){
          upNum++
      }else{
          lowNum++;
      }
  }
  const len = word.length;
  return upNum === len ||//全部为大写
          lowNum === len ||//全部小写
          //第一个大写其它小写
          word[0] === word[0].toUpperCase() && (lowNum + 1) === len ||
          false;
};