/**
 * @param {character[]} chars
 * @return {number}
 */
 var compress = function(chars) {
  let count = 1;
  let temp = chars[0];
  let res = temp;
  for(let i=1; i<chars.length; i++){
      if(chars[i] === temp){
          count++;
      }else{
          if(count > 1){
              res += count;
          }
          count = 1;
          temp = chars[i];
          res += temp;
      }
  }
  if(count > 1){
      res += count;
  }
  chars.splice(0, 0, ...res);
  return res.length;

};
var compress1 = function(chars) {
  const n = chars.length;
  let write = 0, left = 0;
  for (let read = 0; read < n; read++) {
      //最后一个或出现不同字母时开始压缩
      if (read === n - 1 || chars[read] !== chars[read + 1]) {
          chars[write++] = chars[read];
          let num = read - left + 1;//相同字母个数
          if (num > 1) {
              const anchor = write;
              while (num > 0) {
                  chars[write++] = '' + num % 10;
                  num = Math.floor(num / 10);
              }
              //取余添加到数组的数字是镜像的，需要颠倒这部份数字
              reverse(chars, anchor, write - 1);
          }
          left = read + 1;
      }
  }
  return write;
};

const reverse = (chars, left, right) => {
  while (left < right) {
      const temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
  }
}