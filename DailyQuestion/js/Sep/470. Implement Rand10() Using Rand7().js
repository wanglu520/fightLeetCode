/**
 * The rand7() API is already defined for you.
 * var rand7 = function() {}
 * @return {number} a random integer in the range 1 to 7
 */
 var rand10 = function() {
  return (rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7())%10+1; 
};
//拒绝采样
//逆模因 first为[1,6]奇偶概率为1/2
var rand10 = function() {
  let first, second;
  do{
    first = rand7();
  }while(first > 6);
  do{
    second = rand7();
  }while(second > 5);
  return first % 2 === 1 ? second : 5 + second;
};