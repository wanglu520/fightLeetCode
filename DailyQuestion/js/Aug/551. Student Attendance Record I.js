/**
 * @param {string} s
 * @return {boolean}
 */
 var checkRecord = function(s) {
  const len = s.length;
  let countA=0, countL=0;
  for(let i=0; i<len; i++){
      if(s[i] === "A"){
              countA++;
      }
      if(s[i] === "L"){
          countL++;
      }else {
          countL = 0;
      }
      if(countA >= 2 || countL >= 3){
          return false;
      }
  }
  return true;
};

var checkRecord1 = function(s) {
  return !s.includes("LLL") && s.indexOf("A") === s.lastIndexOf("A"); 
};
