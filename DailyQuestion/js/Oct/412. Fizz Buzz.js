/**
 * @param {number} n
 * @return {string[]}
 */
 var fizzBuzz = function(n) {
  const res = [];
  for(let i = 1; i<=n; i++){
      res.push(numToStr(i));
  }
  return res;
};
/**
* @param {number} n
* @return {string}
*/
const numToStr = (n)=>{
  if(n % 15 === 0){
      return "FizzBuzz";
  }else if(n % 3 === 0){
      return "Fizz";
  }else if(n % 5 === 0){
      return "Buzz";
  }else{
      return n+"";
  }
}