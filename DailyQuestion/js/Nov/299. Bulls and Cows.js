/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
//遍历secret 通过map保存每个数字出现的次数
 var getHint = function(secret, guess) {
  const map = new Map(/*<string, Number>*/);
  let x = 0, y = 0;
  for(const str of secret){
      map.set(str, (map.get(str)||0) + 1)
  }
  //公牛数
  for(let i = 0; i<guess.length; i++){
      let count = map.get(guess[i]);
      if(secret[i] === guess[i]){
          x++;
          map.set(guess[i], --count);
      }
      
  }
  //母牛数
  for(let i = 0; i<guess.length; i++){
      let count = map.get(guess[i]);
      if(count && secret[i] !== guess[i]){
          y++;
          map.set(guess[i], --count);
      } 
  }
  return `${x}A${y}B`;
};
var getHint = function(secret, guess) {
  //保存位置不同，数字相同secret的数字的个数
  let conS = new Array(10).fill(0)
  //保存位置不同，数字相同guess的数字的个数
  let conG = new Array(10).fill(0)
  let x = 0
  for(let i=0; i<guess.length; i++){
    if(secret[i] === guess[i]){
      x++;
    }else{
      conS[secret[i] - 0]++;
      conG[guess[i] - 0]++;
    }
  }
  let y = 0;
  for(let i = 0; i<10; i++){
    y += Math.min(conS[i], conG[i]);
  }
  return `${x}A${y}B`
};
