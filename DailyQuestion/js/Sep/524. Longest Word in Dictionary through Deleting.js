/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {string}
 */
//失败 只对比了字母的个数，顺序问题解决不了
 var findLongestWord = function(s, dictionary) {
  const map = new Map();
  for(let str of s){
    map.set(str, map.getOrDefault(str, 0)+1);
  }
  let res="", isInc, total;
  let tempMap;
  for(let strs of dictionary){
   isInc = true;
    tempMap = new Map();
    for(let str of strs){
      total = tempMap.getOrDefault(str, map.getOrDefault(str, 0));
      if(total <= 0){
       isInc = false;
       break;
      }
      tempMap.set(str, --total);
    }
    if(isInc){
      if(res.length === 0){
        res = strs;
      }else if(res.length < strs.length || (res.length === strs.length && strs < res)){
       res = strs;
      }
    }
  }
  return res;
};
Map.prototype.getOrDefault=function(key, defVal){
 return this.get(key) !== undefined ? this.get(key) : defVal;
}
//双指针，i和j分别指向s和dictionary中的元素t。匹配上了指针同时往后移一位。
var findLongestWord = function(s, dictionary) {
  let i, j, res="";
  for(let str of dictionary){
    i = 0, j = 0;
    while(i < s.length && j < str.length){
      if(s[i] === str[j]){
        j++;
      }
      i++;
    }
    //str是否被s包含
    if(j === str.length){
      //满足最长的要求  || 相同长度字典序最小
      if(res.length < str.length || (res.length === str.length && res > str)){
        res = str;
      }
    }
  }
  return res
}
//对dictionary按字符串长度逆序，同时按字典序顺序相同长度字符串。那么匹配到的第一个字符串就是最终的
var findLongestWord = function(s, dictionary) {
  dictionary.sort((a, b)=>{
    if(a.length === b.length){//相同长度按字典序顺序
      return a.localeCompare(b);
    }else{//长度倒序
      return b.length - a.length;
    }
  })
  let i, j;
  for(let str of dictionary){
    i = 0, j = 0;
    while(i < s.length && j < str.length){
      if(s[i] === str[j]){
        j++;
      }
      i++;
    }
    if(j === str.length){
      return str;
    }
  }
  return "";
}