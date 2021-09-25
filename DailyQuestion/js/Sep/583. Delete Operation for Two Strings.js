/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
//失败，通过hash只能获得相同字母个数，顺序无法保证（例如sea和ate预期为4，结果为2）
 var minDistance = function(word1, word2) {
  const map = {/**String:Number */};
  let count = 0;
  for(const s of word1){
      if(!map[s]){
          map[s] = 0;
      }
      map[s]++;
  }
  for(const s of word2){
      if(map[s]){
          map[s]--;
          count++;
      }
  }
  return word1.length - count + word2.length - count;
};
//通过
var minDistance = function(word1, word2) {
  const y = word1.length, x = word2.length;
  const dp = new Array(y+1).fill(0).map(()=>new Array(x+1).fill(0));
  for(let i = 1; i<=y; i++){
    const s1 = word1[i-1];
    for(let j = 1; j<=x; j++){
      if(s1 === word2[j-1]){
        dp[i][j] = dp[i-1][j-1] + 1;
      }else{
        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
      }
    }
  }
  const lcs = dp[y][x];
  return y - lcs + x - lcs;
};