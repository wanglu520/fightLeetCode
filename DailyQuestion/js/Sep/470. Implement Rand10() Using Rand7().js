/**
 * The rand7() API is already defined for you.
 * var rand7 = function() {}
 * @return {number} a random integer in the range 1 to 7
 */
 var rand10 = function() {
  return (rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7()+rand7())%10+1; 
};
//拒绝采样
//for逆模因 first为[1,6]奇偶概率为1/2,
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
//for jerry (rand7() - 1) * 7 => {0, 7, 14, 21, 28, 35, 42}  乘7可以保证均等概率 不会出现类似2+3和3+2的情况
//(rand7() - 1) * 7 + rand7()=>[1,49] 取前1-40可以保证随机1-10均等概率
var rand10 = function() {
  let num;
  do{
    num = (rand7() - 1) * 7 + rand7();
  }while(num > 40);
  return 1 + num % 10;
}