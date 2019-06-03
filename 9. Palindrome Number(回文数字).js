/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
/**
 * @param {number} x
 * @return {boolean}
 */
let isPalindrome = function(x) {
    return x - [...x+""].reverse("").join("") === 0  ? true : false;
}

/**
 * @param {number} x
 * @return {boolean}
 */
let isPalindrome = function(x) {
    let str = x + "";
    let start = 0, end = str.length-1;
    while(start <= end){
        if(str[start] !== str[end]){
            return false;
        }
        start++;
        end--;
    }
    return true;
}

/**
 * @param {number} x
 * @return {boolean}
 * Follow up
 * Coud you solve it without converting the integer to a string?
 */
let isPalindrome = function(x) {
   if(x < 0 || (x !== 0 && x % 10 === 0)){return false}
   let tmp = 0;
   while(tmp < x){
       tmp = tmp * 10 + x % 10;
       x = Math.floor(x / 10);
   }
   return (x === tmp || x === Math.floor(tmp/ 10));
}










































var isPalindrome = function(x) {
	if(x < 0 || (x != 0 && x % 10 === 0)){return false}
	let tmp=0;
	while(tmp < x){
		tmp = tmp*10 + x%10;
		x = Math.floor(x/10);
	}
	return (x === tmp || x === Math.floor(tmp/10));
};