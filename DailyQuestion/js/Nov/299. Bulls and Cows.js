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
  for(let i = 0; i<guess.length; i++){
      let count = map.get(guess[i]);
      if(secret[i] === guess[i]){
          x++;
          map.set(guess[i], --count);
      }
      
  }
  for(let i = 0; i<guess.length; i++){
      let count = map.get(guess[i]);
      if(count && secret[i] !== guess[i]){
          y++;
          map.set(guess[i], --count);
      } 
  }
  return `${x}A${y}B`;
};
