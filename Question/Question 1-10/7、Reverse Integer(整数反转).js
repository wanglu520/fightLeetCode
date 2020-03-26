/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
/**
 * @param {number} x 
 * @returns {number}
 */
let reverse = function(x) {
    let val = (x+"").replace(/(-?)([0-9]*)/,(_, $0, $1)=> $0 + [...$1].reverse().join("")) >> 0;
    if(-Math.pow(2,31) > val || Math.pow(2,31) < val){
        return 0;
    }
    return val;
}
console.log(reverse(-123));