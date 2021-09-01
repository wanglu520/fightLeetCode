/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
//通过"."分割字符串，比较数组相同索引数字的大小，越界部分默认为0
 var compareVersion = function(version1, version2) {
  const arr1 = version1.split(".");
  const arr2 = version2.split(".");
  const len1 = arr1.length, len2 = arr2.length;
  let index1 = 0, index2 = 0;
  while(index1 < len1 || index2 < len2){
    const res = compareNum(arr1[index1++], arr2[index2++]);
    if(res !== 0){
      return res;
    }
  }
  return 0;
};
/**
* 
* @param {String} str1 
* @param {String} str2
* @return {Number} 
*/
const compareNum = (str1="0", str2="0")=>{
 const num1 = str1|0;
 const num2 = str2|0;
 return num1 === num2 ?
                       0 :
                       num1 > num2 ? 1 : -1;
}