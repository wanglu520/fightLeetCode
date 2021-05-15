/**
 * @param {string} s
 * @return {number}
 */
 let romanToInt = (s)=>{
  let romanMap = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000};
  let sum=0;
  for(let i=0; i<s.length; i++){
      sum += 
        (i+1)===s.length || romanMap[s.charAt(i)] >= romanMap[s.charAt(i+1)] ? 
        romanMap[s.charAt(i)] :
        -romanMap[s.charAt(i)];
  }
  return sum;
};