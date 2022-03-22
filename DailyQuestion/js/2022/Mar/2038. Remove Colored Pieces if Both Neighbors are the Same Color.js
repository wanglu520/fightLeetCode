/**
 * @param {string} colors
 * @return {boolean}
 */
 var winnerOfGame = function(colors) {
  const colArr = [...colors];
  let len = 0;
  for(let i=1; i<colors.length; i++){
      if(colArr[i-1] === "A" && colArr[i] === "A" && colArr[i+1] === "A") len++;
      if(colArr[i-1] === "B" && colArr[i] === "B" && colArr[i+1] === "B") len--;
  }
  return len > 0;
};