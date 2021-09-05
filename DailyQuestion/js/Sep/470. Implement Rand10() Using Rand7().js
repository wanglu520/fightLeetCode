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
//(rand7() - 1) * 7 + rand7()=>[1,49] 取前1-40拒绝采集41-49可以保证随机1-10均等概率
var rand10 = function() {
  let num;
  do{
    num = (rand7() - 1) * 7 + rand7();
  }while(num > 40);
  return 1 + num % 10;
}
//for jerry (randx()-1) * y + randY()=>[1,x*y]的均等随机数
var rand10 = function() {
  while(true){
    let num = (rand7() - 1) * 7 + rand7();
    //拒绝采集41-49 9个数
    if(num <= 40){
      return 1 + num%10;
    }
    //41-49之间，再随机一次[1,63]拒绝采集3个数61-63
    num = (num - 40 -1) * 7 + rand7();
    if(num <= 60){
      return 1 + num%10;
    }
    //61-63之间，再随机一次[1,21]拒绝采集1个数21
    num = (num - 60 - 1) * 7 + rand7;
    if(num <= 20){
      return 1 + num%10;
    }
  }
}